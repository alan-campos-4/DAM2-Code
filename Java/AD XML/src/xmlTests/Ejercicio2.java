package xmlTests;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * 2. Utilizando el fichero "productos.xml" creado anteriormente, realizar la lectura de dicho fichero XML utilizando SAX.
 * 
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
	<productos>
	    <producto codigo="1">
	        <descripcion>P1</descripcion>
	        <unidades>14</unidades>
	        <precio>12.3</precio>
	    </producto>
	    <producto codigo="2">
	        <descripcion>P2</descripcion>
	        <unidades>15</unidades>
	        <precio>34.5</precio>
	    </producto>
	    <producto codigo="3">
	        <descripcion>P3</descripcion>
	        <unidades>13</unidades>
	        <precio>28.9</precio>
	    </producto>
	    <producto codigo="4">
	        <descripcion>P4</descripcion>
	        <unidades>17</unidades>
	        <precio>16.3</precio>
	    </producto>
	</productos>
 */



public class Ejercicio2
{
	static class UserHandler extends DefaultHandler
	{
		boolean has1 = false;
		boolean has2 = false;
		boolean has3 = false;
		
		int codigo;
		String desc;
		int unidades;
		double precio;
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if (qName.equals("productos"))
			{
				System.out.println("Root Element: " + qName + "\n");
			}
			if (qName.equals("producto"))
			{
				codigo = Integer.parseInt(attributes.getValue("codigo"));
			}
			if (qName.equals("descripcion"))	{has1 = true;}
			if (qName.equals("unidades"))		{has2 = true;}
			if (qName.equals("precio"))			{has3 = true;}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			if (has1)
			{
				desc = new String(ch, start, length);
				has1 = false;
			}
			if (has2)
			{
				unidades = Integer.parseInt(new String(ch, start, length));
				has2 = false;
			}
			if (has3)
			{
				precio = Double.parseDouble(new String(ch, start, length));
				has3 = false;
			}
		}
		
		public void endElement(String uri, String localName, String qName)
		{
			if (qName.equals("producto"))
			{
				System.out.println("Producto "+codigo+" : "+desc);
				System.out.println(unidades+" unidades");
				System.out.println(precio+" €");
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
			File xmlFile = new File("src/productos.xml");

			// Creating UserHandler object
			UserHandler userHandler = new UserHandler();

			// Parsing the XML Document
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}