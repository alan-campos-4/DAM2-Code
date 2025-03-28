package ej1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Ejercicio 1 – Ficheros XML (DOM) – 2 ptos
 * 
 * Escribe un programa con la ayuda de DOM para que a partir del fichero peliculas.xml, 
 * se muestre correctamente: el id de la película, el título, año, director 
 * y los nombres de los actores principales.
 */


public class Ejercicio1
{
	public static void main(String[] args)
	{
		try
		{
			//Fichero XML
			File inputXmlFile = new File("src/peliculas.xml");
			
			//Creamos el Documento para leer el fichero.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document xmldoc = docBuilder.parse(inputXmlFile);
			
			//Leemos e imprimimos el elemento raíz.
			Element element = xmldoc.getDocumentElement();
			System.out.println("Root element name is " + element.getTagName());
			
			//Obtenemos los elementos del fichero.
			NodeList nList = element.getChildNodes();
			
			//Por cada uno de los elementos el fichero, 
			for (int i = 0; i < nList.getLength(); i++)
			{
				// identificamos el nodo.
				Node nNode = nList.item(i);
				//Si el nodo obtenido es válido,
				if (nNode.getNodeName()!="#text")
				{
					// mostramos el elemento.
					System.out.println("\nCurrent Element: " + nNode.getNodeName());
					//Si el nodo es un elemento
					if (nNode.getNodeType() == Node.ELEMENT_NODE)
					{
						//Imprimimos su atributo y todos sus subelementos.
						Element eElement = (Element) nNode;
						System.out.println("ID: " + eElement.getAttribute("id"));
						System.out.println("Título: " 
								+ eElement.getElementsByTagName("Titulo").item(0).getTextContent());
			            System.out.println("Fecha: " 
								+ eElement.getElementsByTagName("Fecha").item(0).getTextContent());
			            System.out.println("Director: " 
								+ eElement.getElementsByTagName("Director").item(0).getTextContent());
			            System.out.println("Actores: " 
								+ eElement.getElementsByTagName("Actores").item(0).getTextContent());  
					}
				}
			}
		}
		catch (DOMException e)					{e.printStackTrace();}
		catch (SAXException e)					{e.printStackTrace();} 
		catch (IOException e)					{e.printStackTrace();} 
		catch (ParserConfigurationException e)	{e.printStackTrace();}
	}
	
	
	
	
}
