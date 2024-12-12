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
import java.util.InputMismatchException;
import java.util.Scanner;


public class Ejercicio1
{
	public static Scanner input;
	public static File fichero;
	public static ObjectOutputStream OOS;
	public static ObjectInputStream OIS;
	
	//Tamaño de la variable título de un Libro.
	public final static int TitleLength = 30;
	//Tamaño de la variable autor de un Libro.
	public final static int AuthorLength = 20;
	//Tamaño total en bytes de una instancia de la clase Libro.
	public final static int sizeOfLibro = 112;
	// 	· codigo	double		8 bytes
	// 	· titulo	string(30)	2 bytes*30
	//	· autor		string(20)	2 bytes*20
	//	· año		int			4 bytes
	// 	8 + 2*30 + 2*20 + 4 = 112 bytes
	public static class Libro implements Serializable
	{
		private static final long serialVersionUID = 2242170916954979367L;
		double code;
		String title;
		String author;
		int year;
		
		public Libro(double c, String t, String a, int y)
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
	
	
	
	
	public static void clear()
	{
		System.out.println("\n\n\n\n");
	}
	
	public static void main(String[] args)
	{
		int op = 1;
		
		try
		{
			input = new Scanner(System.in);
			fichero = new File("src/biblioteca.dat");
			
			do {
				System.out.println("----- Librería -----\n");
				System.out.println("1.) Añadir un libro.");
				System.out.println("2.) Listar todos los libros.");
				System.out.println("3.) Buscar un libro por su código.");
				System.out.println("0. Salir");
				System.out.print("\nSelecciona una opcion: ");
				
				try
				{
					op = input.nextInt();
					
					if (op!=0)	{clear();}
					switch(op)
					{
						default: {System.out.println("\nOpción fuera del rango.");}	break;
						case 0:  {System.out.println("\n\nFin del programa.");}			break;
						case 1:	{anadirLibro();}	break;
						case 2:	{listarLibros();}	break;
						case 3:	{buscarLibro();}	break;
					}
				}
				//Puede ser lanzada si la opción introducida no es un entero.
				catch (InputMismatchException e)
				{
					System.out.println("\n  Opción no válida.");
					input.nextLine();	//Salta la línea para prevenir un bucle infinito.
				}
				
				if (op!=0)	{clear();}
				
			} while (op!=0);
			
			input.close();
		}
		//Puede ser lanzada cada vez que se declara un nuevo fichero de objetos.
		catch (FileNotFoundException e)		{System.out.println("\nNo se ha encontrado el fichero.");}
		//Puede ser lanzada cada vez que se lee o escribe en el fichero de objetos.
		catch (IOException e)				{e.printStackTrace();}
	}
	
	
	
	
	public static void anadirLibro() throws FileNotFoundException, IOException
	{
		try
		{
			int anio;
			double id;
			String titulo, autor;
			StringBuffer buffer1 = null, buffer2 = null;
			
			input.nextLine(); //Salta la línea para poder leer después del entero op.
			
			//Lee todos los datos por línea.
			System.out.print("Codigo: ");	id = input.nextDouble(); 
			input.nextLine(); //Salta la línea para poder leer después del double.
			System.out.print("Titulo: ");	titulo = input.nextLine();
			System.out.print("Autor: ");	autor = input.nextLine();
			System.out.print("Año: ");		anio = input.nextInt();
			
			//Pasa las cadenas a buffers para darles una longitud máxima.
			buffer1 = new StringBuffer(titulo);
			buffer2 = new StringBuffer(autor);
			buffer1.setLength(TitleLength);
			buffer2.setLength(AuthorLength);
			
			//Crea el nuevo objeto.
			Libro lib = new Libro(id, buffer1.toString(), buffer2.toString(), anio);
			
			//Declara el fichero de objetos y añade el libro.
			OOS = new ObjectOutputStream(new FileOutputStream(fichero, true));
			OOS.writeObject(lib);
			OOS.close();
			
			//Confirma el guardado.
			System.out.println("\nLibro guardado.");
		}
		//Puede ser lanzada cuando el tipo de dato leído por el Scanner no es correcto.
		catch (InputMismatchException e)	{System.out.println("\nDatos no válidos. Operación cancelada.");}
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void listarLibros() throws FileNotFoundException, IOException
	{
		OIS = new ObjectInputStream(new FileInputStream(fichero));
		Libro lib;
		ArrayList <Libro> libList;
		
		try
	    {
	        //Recorriendo todo el fichero
			lib = (Libro)OIS.readObject();
	        while (true)
	        {
	        	// muestra el libro y pasa al siguiente.
	        	lib.display();
	        	lib = (Libro)OIS.readObject();
	        }
			
		}
		//Lanzada cuando llega la final del fichero.
	    catch (EOFException e)				{System.out.println("Fin de fichero");}
		//Lanzada si no se encuentra la clase al leer el objeto.
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		
		OIS.reset();
		OIS.close();
	}
	
	
	
	
	public static void buscarLibro() throws FileNotFoundException, IOException
	{
		Libro lib;
		double idToFind;
		boolean found = false;
		
		OIS = new ObjectInputStream(new FileInputStream(fichero));
		
		try
	    {
			System.out.print("Introduce el código del libro que buscas: ");
			idToFind = input.nextDouble();
	        
	        //Recorriendo todo el fichero
	        lib = (Libro)OIS.readObject();
	        while (!found)
	        {
	        	//Si encuentra el libro termina el bucle. Si no, sigue leyendo.
	        	if (lib.getID()==idToFind)
	        	{
	        		lib.display();
	        		found = true;
	        	}
	        	else {lib = (Libro)OIS.readObject();}
	        }
	    }
		//Lanzada cuando llega la final del fichero. Si no se ha encontrado el libro, lo indica.
	    catch (EOFException e)
		{
	    	if (!found)
				{System.out.println("No hay ningún libro con este código.");}
		}
		//Lanzada si no se encuentra la clase al leer el objeto.
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		
		OIS.reset();
		OIS.close();
	}
	
	
	
	
}
