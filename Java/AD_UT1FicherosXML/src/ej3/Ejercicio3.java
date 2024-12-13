package ej3;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Ejercicio 3 – Ficheros XML (SAX)– 2 ptos
 * 
 * Crea un programa que mediante SAX lea un archivo RSS de la página 
 * 		https://rss.nytimes.com/services/xml/rss/nyt/World.xml 
 * y obtenga los títulos, descripción y fechas de las noticias.
 * Incluir una captura de pantalla del resultado de la ejecución.
 */


class UserHandler extends DefaultHandler
{
	boolean hasTitle = false;
	boolean hasDescription = false;
	boolean hasPubDate = false;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equals("rss")) {
			System.out.println("Root Element : " + qName + "\n");
		}
		if (qName.equals("item")) {
			System.out.println("Current Item" );
		}
		if (qName.equals("title"))			{hasTitle = true;}
		if (qName.equals("description"))	{hasDescription = true;}
		if (qName.equals("pubDate"))		{hasPubDate = true;}
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		if (hasTitle)
		{
			System.out.println("  Title: " + new String(ch, start, length));
			hasTitle = false;
		}
		if (hasDescription)
		{
			System.out.println("  Description: " + new String(ch, start, length));
			hasDescription = false;
		}
		if (hasPubDate)
		{
			System.out.println("  Published: " + new String(ch, start, length) + "\n");
			hasPubDate = false;
		}
	}
}

public class Ejercicio3
{
	public static void main(String args[])
	{
		try
		{
			// Creating a DocumentBuilder Object
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Reading the XML
			File xmlFile = new File("src/ej3/World.xml");

			// Creating UserHandler object
			UserHandler userHandler = new UserHandler();

			// Parsing the XML Document
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e)	{e.printStackTrace();}
	}
}
