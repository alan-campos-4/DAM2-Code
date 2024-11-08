import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * 3. Utilizando el fichero "versiones.xml", realizar la lectura de dicho fichero utilizando la clase Version.java.
 * 
 * <?xml version="1.0" encoding="utf-8" standalone="yes"?>
	<versiones>
	    <version numero="1.5">
	        <nombre>Cupcake</nombre>
	        <api>3</api>
	    </version>
	    <version numero="1.6">
	        <nombre>Donut</nombre>
	        <api>4</api>
	    </version>
	    <version numero="2.3">
	        <nombre>Gingerbread</nombre>
	        <api>9</api>
	    </version>
	    <version numero="3">
	        <nombre>Honeycomb</nombre>
	        <api>11</api>
	    </version>
	</versiones>
 */


public class Ejercicio3
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
				Version v = new Version();
				v.setNumero(numero);
				v.setNombre(nombre);
				v.setApi(api);
				System.out.println(v.toString());
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
			File xmlFile = new File("src/versiones.xml");
			
			// Creating UserHandler object
			UserHandler userHandler = new UserHandler();
			
			// Parsing the XML Document
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}