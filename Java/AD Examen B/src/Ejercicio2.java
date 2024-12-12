import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;




public class Ejercicio2
{
	public class Libro2 implements Serializable
	{
		private static final long serialVersionUID = 224217099367L;
		double code;
		String title;
		String author;
		int year;
		
		public Libro2(double c, String t, String a, int y)
		{
			this.code = c;
			this.title = t;
			this.author = a;
			this.year = y;
		}
		public void display()
		{
			System.out.println(code);
	    	System.out.println("  "+title);
	    	System.out.println("  "+author);
	    	System.out.println("  "+year);
	    	System.out.println();
		}
		
		public double getID()		{return code;}
		public String getTitulo()	{return title;}
		public String getAutor()	{return author;}
		public int getAnio()		{return year;}
		
		public String getID_str()	{return String.valueOf(code);}
		public String getAnio_str()	{return String.valueOf(year);}
	}
	
	
	public static void main(String[] args)
	{
		ArrayList<Libro2> List = new ArrayList<>();
		File fichero = new File("src/biblioteca.dat");
		
		try
		{
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(fichero));
			
			try
			{
				Libro2 l = (Libro2)OIS.readObject();
				while (true)
				{
					l.display();
					List.add(l);
					System.out.println("Libro "+l.getID()+" añadido");
					l = (Libro2)OIS.readObject();
				}
			}
			catch (EOFException e) {System.out.println("Fin del fichero.");}
			OIS.close();
		}
		catch (IOException e)				{e.printStackTrace();}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		
		try
		{
			// Creating a DocumentBuilder Object
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			
			// Create a new Document
			Document doc = db.newDocument();
			
			// Creating the root element
			Element rootElement = doc.createElement("libros");
			doc.appendChild(rootElement);
			
			for (Libro2 lib : List)
			{
				//Appending elements to the root element
				Element book = doc.createElement("libro");
				rootElement.appendChild(book);
				
				//Adding sub elements to the element
				Element title = doc.createElement("titulo");
				title.appendChild(doc.createTextNode(lib.getTitulo()));
				book.appendChild(title);
				
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(lib.getTitulo()));
				book.appendChild(autor);
				
				Element year = doc.createElement("anioPublicacion");
				year.appendChild(doc.createTextNode(lib.getAnio_str()));
				book.appendChild(year);
			}
			
			// writing the content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/biblioteca.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			System.out.println("\nResultado de la conversión:\n");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}
