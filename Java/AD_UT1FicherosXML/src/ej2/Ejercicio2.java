package ej2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
			return titulo+" ("+fecha+")\n  Director: "+director+"\n  Duracion: "+duracion+"min\n";
		}
	}
	
	
	/* Función Main */
	public static void main(String[] args)
	{
		//Fichero de donde obtenemos los datos.
		File ficheroXML = new File("src/peliculas.xml");
		//Fichero donde guardaremos y leeremos los datos.
		File ficheroDatos = new File("src/peliculas.dat");
		
		
		/* Escritura en el fichero */
		try
		{
			//Creamos el Document para leer el fichero.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document xmldoc = docBuilder.parse(ficheroXML);
			//Leemos el elemento raíz.
			Element element = xmldoc.getDocumentElement();
			//Obtenemos los nodos del fichero.
			NodeList nList = element.getChildNodes();
			
			//Establecemos una variable para detectar el índice del primer elemento Pelicula.
            int firstElement = -1;
            
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
					
					//Creamos el objeto Pelicula.
		            Pelicula p = new Pelicula
		            		(id, title, director, genre, sinopsis, duracion, year, actoresList);
		            
		            //Si este es el primer elemento, se guarda su índice.
		            if (firstElement==-1)
		            	{firstElement = temp;}
		            
		            //Guarda el elemento leído en el fichero de datos.
		            //Si el elemento actual es el primero se escribirá al principio del fichero.
		            //Si el elemento actual no es el primero se añade al fichero existente.
		            FileOutputStream fos;
		            if (temp == firstElement)
		            {
		            	fos = new FileOutputStream(ficheroDatos);
		            	ObjectOutputStream OOS = new ObjectOutputStream(fos);
						OOS.writeObject(p);
						OOS.close();
		            }
		            else
		            {
		            	fos = new FileOutputStream(ficheroDatos, true);
		            	MyObjectOutputStream Moos = new MyObjectOutputStream(fos);
		            	Moos.writeObject(p);
		            	Moos.close();
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
		try
		{
			OIS = new ObjectInputStream(new FileInputStream(ficheroDatos));
			Pelicula p = (Pelicula)OIS.readObject();
			//Mientras no llegue al final del fichero,
			while (true)
			{
				// muestra los datos de la pelicula y lee la siguiente.
				System.out.println(p.toString());
				p = (Pelicula)OIS.readObject();
			}
		}
		//Lanzada cuando ObjectInputStream.readObject() llega al final del fichero.
		catch (EOFException e)				{System.out.println("Final del fichero.");}
		//Lanzada por ObjectInputStream.readObject() si no encuentra la clase.
		catch (ClassNotFoundException e)	{System.out.println("No se ha encontrado la clase.");}
		//Lanzada por el constructor de FileInputStream() si no encuentra o no puede acceder al fichero.
		catch (FileNotFoundException e)		{System.out.println("El fichero no existe.");}
		//Lanzada por el constructor y readObject() de ObjectInputStream si tiene problemas con el fichero.
		catch (IOException e)				{e.printStackTrace();}
		finally
		{
			try {OIS.close();}
			catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
	
	
	
}
