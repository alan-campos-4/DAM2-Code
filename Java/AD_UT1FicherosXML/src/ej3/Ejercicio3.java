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
 * y obtenga los títulos, descripción  y fechas de las noticias.
 * Incluir una captura de pantalla del resultado de la ejecución.
 */

class UserHandler extends DefaultHandler
{
	boolean hasDeptName = false;
	boolean hasStaffCount = false;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		if (qName.equals("college")) {
			System.out.println("Root Element : " + qName + "\n");
		}
		if (qName.equals("department")) {
			System.out.println("Current Element : " + qName);
			System.out.println("Department code : " + attributes.getValue("deptcode"));
		}
		if (qName.equals("name")) {
			hasDeptName = true;
		}
		if (qName.equals("staffCount")) {
			hasStaffCount = true;
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		if (hasDeptName) {
			System.out.println("Department Name : " + new String(ch, start, length));
			hasDeptName = false;
		}
		if (hasStaffCount) {
			System.out.println("Staff Count : " + new String(ch, start, length) + "\n");
			hasStaffCount = false;
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
			File xmlFile = new File("college.xml");

			// Creating UserHandler object
			UserHandler userHandler = new UserHandler();

			// Parsing the XML Document
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e)	{e.printStackTrace();}
	}
}
