package xmlTests;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * 1. Utilizando el fichero "productos.dat" creado anteriormente, realizar la transformación 
 * a un fichero XML y posteriormente crear una clase para la lectura de dicho fichero XML
 */

public class Ejercicio1
{
	public static class Producto implements Serializable
	{
		private static final long serialVersionUID = 1L;
		int codigo;
		String descripcion;
		int unidades;
		double precio;

		public Producto(int c, String d, int u, double p)
		{
			this.codigo = c;
			this.descripcion = d;
			this.unidades = u;
			this.precio = p;
		}
		
		public String getCodigo()	{return String.valueOf(this.codigo);}
		public String getUnidades()	{return String.valueOf(this.unidades);}
		public String getPrecio()	{return String.valueOf(this.precio);}
	}
	
	public static ArrayList<Producto> List;
	
	public static void LeerFichero(String fichero)
	{
		try {
			Producto p;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fichero)));
			List = new ArrayList<>();
			try {
				while (true)
				{
					p = (Producto) ois.readObject();
					System.out.println("Producto " + p.codigo);
					System.out.println("  " + p.descripcion);
					System.out.println("  " + p.unidades);
					System.out.println("  " + p.precio + "\n");
					List.add(p);
				}
			}
			catch (EOFException e) {System.out.println("Fin del fichero.");}
			ois.close();
		}
		catch (IOException e)				{e.printStackTrace();}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
	}
	
	
	
	
	public static void main(String[] args)
	{
		LeerFichero("src/xmlTests/productos.dat");

		try
		{
			// Creating a DocumentBuilder Object
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();

			// Create a new Document
			Document doc = db.newDocument();

			// Creating the root element
			Element rootElement = doc.createElement("productos");
			doc.appendChild(rootElement);

			for (Producto p : List)
			{
				//Appending elements to the root element
				Element product = doc.createElement("producto");
				rootElement.appendChild(product);
				
				//Appending the attribute
				Attr attr = doc.createAttribute("codigo");
				attr.setValue(p.getCodigo());
				product.setAttributeNode(attr);

				//Adding sub elements to the element
				Element desc = doc.createElement("descripcion");
				desc.appendChild(doc.createTextNode(p.descripcion));
				product.appendChild(desc);
				
				Element unit = doc.createElement("unidades");
				unit.appendChild(doc.createTextNode(p.getUnidades()));
				product.appendChild(unit);
				
				Element precio = doc.createElement("precio");
				precio.appendChild(doc.createTextNode(p.getPrecio()));
				product.appendChild(precio);
			}

			// writing the content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/productos.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			System.out.println("\nResultado de la conversión:\n");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}