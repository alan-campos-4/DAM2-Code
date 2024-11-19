import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * 4. A partir del fichero versiones.xml crear un fichero de objetos de versiones.
 */




public class Ejercicio4
{
	static class UserHandler extends DefaultHandler
	{
		boolean hasName = false;
		boolean hasAPI = false;
		
		double numero;
		String nombre;
		int api;
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if (qName.equals("versiones"))
			{
				System.out.println("Root Element: " + qName + "\n");
			}
			if (qName.equals("version"))
			{
				numero = Double.parseDouble(attributes.getValue("numero"));
			}
			if (qName.equals("nombre"))	{hasName = true;}
			if (qName.equals("api"))	{hasAPI = true;}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			if (hasName)
			{
				nombre = new String(ch, start, length);
				hasName = false;
			}
			if (hasAPI)
			{
				api = Integer.parseInt(new String(ch, start, length));
				hasAPI = false;
			}
		}
		
		public void endElement(String uri, String localName, String qName)
		{
			if (qName.equals("version"))
			{
				Version v = new Version(numero, nombre, api);
				List.add(v);
			}
		}
	}
	
	public static ArrayList<Version> List;
	
	public static void main(String args[])
	{
		try
		{
			List = new ArrayList<>();
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			File xmlFile = new File("src/versiones.xml");
			
			UserHandler userHandler = new UserHandler();
			
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}