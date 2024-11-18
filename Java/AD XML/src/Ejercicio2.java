
/*
 * 2. Utilizando el fichero "productos.xml" creado anteriormente, 
 * realizar la lectura de dicho fichero XML utilizando SAX.
 */

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Ejercicio2
{
	static class UserHandler extends DefaultHandler
	{
		boolean hasName = false;
		boolean hasAPI = false;
		
		String numero;
		String nombre;
		int api;
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if (qName.equals("college"))
			{
				System.out.println("Root Element: " + qName + "\n");
			}
			if (qName.equals("department"))
			{
				numero = attributes.getValue("deptcode");
			}
			if (qName.equals("name"))	{hasName = true;}
			if (qName.equals("staffCount"))	{hasAPI = true;}
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
			if (qName.equals("department"))
			{
				System.out.println("Departemnt "+numero+" : "+nombre);
				System.out.println(api+" miembros");
				System.out.println("\n");
			}
		}
	}
	
	public static void main(String args[])
	{
		try
		{
			// Creating a DocumentBuilder Object
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Reading the XML
			File xmlFile = new File("src/college.xml");

			// Creating UserHandler object
			UserHandler userHandler = new UserHandler();

			// Parsing the XML Document
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}