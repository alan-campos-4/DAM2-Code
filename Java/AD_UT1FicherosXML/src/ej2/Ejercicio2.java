package ej2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import myStreams.MyObjectOutputStream;

/*
 * Ejercicio 2 – Ficheros XML (DOM) a fichero de objetos – 2 ptos
 * 
 * Guarda los datos del fichero XML en un fichero de objetos y realiza la lectura del mismo.
 */


public class Ejercicio2
{
	public static File fichero = new File("src/peliculas.dat");
	
	
	/* Definición de la clase Pelicula */
	public static class Pelicula implements Serializable
	{
		private static final long serialVersionUID = 1L;
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
			this.actores = actors;
		}
		public String toString()
		{
			return titulo+" ("+fecha+")";
		}
	}
	
	
	/* Función Main */
	public static void main(String[] args)
	{
		/* Escritura en el fichero */
		try
		{
			//Creamos el fichero XML.
			File inputXmlFile = new File("src/peliculas.xml");
			
			//Creamos el Document para leer el fichero.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document xmldoc = docBuilder.parse(inputXmlFile);
			//Leemos el elemento raíz.
			Element element = xmldoc.getDocumentElement();
			//Obtenemos los nodos del fichero.
			NodeList nList = element.getChildNodes();
			
			//Por cada uno de los nodos el fichero, 
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				//Si el nodo tiene un nombre válido y es un elemento,
				if (nNode.getNodeName()!="#text" && nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					// obtenemos el elemento y guardamos todos sus subelementos.
					Element eElement = (Element) nNode;
					String idS = eElement.getAttribute("id");
					String title = eElement.getElementsByTagName("Titulo").item(0).getTextContent();
					String director = eElement.getElementsByTagName("Director").item(0).getTextContent();
					String genre = eElement.getElementsByTagName("Genero").item(0).getTextContent();
					String durS = eElement.getElementsByTagName("Duracion").item(0).getTextContent();
					String sinopsis = eElement.getElementsByTagName("sinopsis").item(0).getTextContent();
					String yearS = eElement.getElementsByTagName("Fecha").item(0).getTextContent();
					String actoresStr = eElement.getElementsByTagName("Actores").item(0).getTextContent();
					
					//Leyendo el elemento Actores directamente con el getElementsByTagName()
					//devuelve un solo string con sus subelementos juntos y con espacios adicionales.
					//Para resolver esto creamos:
					//	un array donde separamos los actores y quitamos el espacio adicional,
					//	y si la línea restante no está vacía la añadimos a un ArrayList
					//	que se utilizará para almacenar los actores en el objeto.
					String[] actoresArr = actoresStr.replaceAll("   ","").split("\n");
					ArrayList<String> actoresList = new ArrayList<>();
					for (String s : actoresArr)
					{
						if (!s.equals(" "))	{actoresList.add(s);}
					}
					
					//Pasamos las variables que corresponden de Strings a enteros.
					int id = Integer.parseInt(idS);
					int duracion = Integer.parseInt(durS);
					int year = Integer.parseInt(yearS);
					
					//Creamos el objeto Pelicula y los mostramos.
		            Pelicula p = new Pelicula
		            		(id, title, director, genre, sinopsis, duracion, year, actoresList);
		            System.out.println("-"+p.toString());
		            
		            FileOutputStream fos = new FileOutputStream(fichero, true);
		            if (fichero.length() == 0)
		            {
		            	fos = new FileOutputStream(fichero);
			            ObjectOutputStream OOS = new ObjectOutputStream(fos);
						OOS.writeObject(p);
						OOS.close();
		            }
		            else
		            {
		            	fos = new FileOutputStream(fichero, true);
		            	MyObjectOutputStream oos = new MyObjectOutputStream(fos);
		            	oos.writeObject(p);
		            	oos.close();
		            }
		            fos.close();
				}
			}
		}
		//Lanzada por DocumentBuilder.parse() si ocurre un error en el análisis.
		catch (SAXException e)					{e.printStackTrace();} 
		//Lanzada por DocumentBuilder.parse() si ocurre un errore en entrada o salida.
		catch (IOException e)					{e.printStackTrace();} 
		//Lanzada por DocumentBuilderFactory.newDocumentBuilder() si no se crea correctamente.
		catch (ParserConfigurationException e)	{e.printStackTrace();}
		
		
		/* Lectura del fichero */
		ObjectInputStream OIS = null;
		try {
			OIS = new ObjectInputStream(new FileInputStream(fichero));
			Pelicula p = (Pelicula)OIS.readObject();
			
			while (true)
			{
				System.out.println(p.toString());
				p = (Pelicula)OIS.readObject();
			}
		}
		catch (EOFException e)				{System.out.println("Final del fichero.");}
		catch (IOException e)				{e.printStackTrace();}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		finally
		{
			try {OIS.close();}
			catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	
	
}
