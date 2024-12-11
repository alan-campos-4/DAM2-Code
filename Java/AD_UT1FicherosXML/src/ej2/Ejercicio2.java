package ej2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Ejercicio 2 – Ficheros XML (DOM) a fichero de objetos– 2 ptos
 * 
 * Guarda los datos del fichero XML en un fichero de objetos y realiza la lectura del mismo.
 */


public class Ejercicio2
{
	public static class Pelicula
	{
		int id;
		String titulo;
		int duracion;
		String genero;
		String sinopsis;
		ArrayList<String> actores;
		int fecha;
		String director;
		
		public Pelicula
		(int id, String ti, String dir, String gen, String sinop, int dur, int year, ArrayList<String> actors)
		{
			this.id = id;
			this.titulo = ti;
			this.director = dir;
			this.genero = gen;
			this.sinopsis = sinop;
			this.duracion = dur;
			this.fecha = year;
			
			actores = new ArrayList<>();
			actores = actors;
			//for (String act : actors)	{actores.add(act);}
		}
		
		public void ToString()
		{
			System.out.println("\n");
			System.out.println("ID: "+this.id);
			System.out.println(""+this.titulo+" ("+this.fecha+")");
			System.out.println("  Director: "+this.director);
			System.out.println("  Duracion: "+this.duracion+" min");
			//System.out.println("Actores: "+this.actores+"\n");
			System.out.println("  Actores: ");
			for (String actor : actores)
			{
				System.out.println("   - "+actor);
			}
		}
	}
	
	public static void main(String[] args)
	{
		try {
			// Input the XML file
			File inputXmlFile = new File("src/peliculas.xml");
			
			// creating DocumentBuilder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document xmldoc = docBuilder.parse(inputXmlFile);
			
			// Retrieving the Root Element
			Element element = xmldoc.getDocumentElement();
			System.out.println("Root element name is " + element.getTagName());
			
			// Getting the child elements List
			NodeList nList = element.getChildNodes();
			
			// Iterating through all the child elements of the root
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				if (nNode.getNodeName()!="#text")
				{
					if (nNode.getNodeType() == Node.ELEMENT_NODE)
					{
						Element eElement = (Element) nNode;
						
						String idS = eElement.getAttribute("id");
						String title = eElement.getElementsByTagName("Titulo").item(0).getTextContent();
						String director = eElement.getElementsByTagName("Director").item(0).getTextContent();
						String genre = eElement.getElementsByTagName("Genero").item(0).getTextContent();
						String durS = eElement.getElementsByTagName("Duracion").item(0).getTextContent();
						String sinopsis = eElement.getElementsByTagName("sinopsis").item(0).getTextContent();
						String yearS = eElement.getElementsByTagName("Fecha").item(0).getTextContent();
						String actoresStr = eElement.getElementsByTagName("Actores").item(0).getTextContent();
						
						ArrayList<String> actoresList = new ArrayList<>();
						String[] actoresArr = actoresStr.replaceAll("   ","").split("\n");
						for (String s : actoresArr)
						{
							if (!s.equals(" "))
								actoresList.add(s);
						}
						
						int id = Integer.parseInt(idS);
						int duracion = Integer.parseInt(durS);
						int year = Integer.parseInt(yearS);
						
			            Pelicula p = new Pelicula
			            		(id, title, director, genre, sinopsis, duracion, year, actoresList);
						p.ToString();
					}
				}
			}
		}
		//Lanzada por DocumentBuilder.parse() si ocurre un error en el análisis.
		catch (SAXException e)					{e.printStackTrace();} 
		//Lanzada por DocumentBuilder.parse() si ocurre un errore en entrada o salida.
		catch (IOException e)					{e.printStackTrace();} 
		//Lanzada por DocumentBuilderFactory.newDocumentBuilder() si no se crea correctamente.
		catch (ParserConfigurationException e)	{e.printStackTrace();}
	}
	
	
	
	
}
