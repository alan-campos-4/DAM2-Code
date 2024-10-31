package ej4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Ejercicio 4
 * 
 * Se requiere desarrollar un programa en Java que gestione un sistema de biblioteca 
 * utilizando ficheros de acceso aleatorio. 
 * Este sistema permitirá almacenar, consultar, modificar y eliminar la información de libros 
 * en un fichero de acceso directo, de forma que cada registro se pueda acceder de manera eficiente 
 * sin necesidad de recorrer todo el fichero.
 * El sistema debe estar diseñado para permitir la persistencia de datos entre ejecuciones del programa, 
 * garantizando la integridad de la información almacenada.
 * Cada registro debe ocupar un espacio fijo en el fichero para facilitar la lectura y escritura 
 * de manera directa usando el ID del libro como clave para la posición en el fichero.
 * 
 * El programa debe validar que no existan ID duplicados cuando se agregue un nuevo libro.
 *  Cada libro debe contener los siguientes campos:
 * o	ID del libro (entero, 4 bytes)
 * o	Título del libro (cadena de texto, máximo 50 caracteres)
 * o	Autor (cadena de texto, máximo 30 caracteres)
 * o	Año de publicación (entero, 4 bytes)
 * o	Disponibilidad (booleano, 1 byte) – para controlar si el libro está disponible para préstamo.
 *  Operaciones del sistema: El programa debe ofrecer un menú con las siguientes opciones:
 * o	Añadir un nuevo libro:
 * 		 El usuario introducirá la información necesaria para agregar un nuevo libro a la biblioteca.
 * o	Consultar libro por ID:
 * 		 Se buscará un libro por su ID y se mostrarán sus detalles (si existe).
 * o	Modificar los datos de un libro: 
 * 		 Permitir al usuario modificar el título, el autor o el año de publicación de un libro existente.
 * o	Eliminar un libro: 
 * 		 Marcar un libro como no disponible, eliminándolo lógicamente (sin borrar el registro del fichero).
 * o	Listar todos los libros disponibles: 
 * 		 Mostrar en pantalla los libros que están disponibles para préstamo.

 */

public class Ejercicio4
{
	static Scanner input;
	static File recordfile;
	
	public static void clear()
	{
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\n\n\n\n");
	}
	public static void pressAnyKey()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nPress any key to continue.");
        try {
            System.in.read();
            input.nextLine();
        } catch (Exception e) {e.printStackTrace();}
        
        input.close();
        clear();
	}
	
	
	/* Definición de la clase Libro */
	public class Libro
	{
		int id;			//4 bytes
		char[] titulo = new char[50];	//50 char max. 2 bytes / Char
		char[] autor = new char[30];;	//30 char max
		int anio;		//4 bytes
		boolean disp;	//1 byte
		
		public Libro (int i, String ti, String aut, int an, boolean d)
		{
			this.id = i;
			this.anio = an;
			
			if (ti.length() > 50)
				{ti = ti.substring(0, 50);}
			this.titulo = ti.toCharArray();
			
			if (aut.length() > 30)
				{aut = aut.substring(0, 30);}
			this.autor = aut.toCharArray();
		}
	}
	/* Tamaño total en bytes de una instancia de la clase Libro
	 * 		id		int			4 bytes
	 * 		titulo	char[50]	2 bytes*50
	 *		autor	char[30]	2 bytes*30
	 *		anio	int			4 bytes
	 *		disp	boolean		1 bytes
	 * 		4 + 2*50 + 2*30 + 4 + 1 = 169 bytes */
	public static int sizeOfLibro = 196;
	
	
	/* Método para encontrar el ID de un libro. Devuelve -1 si no lo encuentra. */
	public static int findID(RandomAccessFile file, int idToFind)
	{
		int posicion = 0, id;
		boolean found = false;
		
		try
		{
			posicion = 0;				//Empezando en el principio del fichero,
			
			do {
				file.seek(posicion);	//nos colocamos en posicion
				id = file.readInt();	//obtenemos el id de empleado
				
				if (idToFind==id)
				{
					found = true;		//si coincide con el id que buscamos
					break;				//se considera encontrado y termina el bucle 
				}
				posicion += 36; 		//cada empleado ocupa 36 bytes
				
			} while ( (!found) || (file.getFilePointer()!=file.length()) );
			
			if (found)	return posicion;
			else		return -1;
		}
		catch (IOException e)	{return -1;}
	}
	
	
	
	
	
	
	// El usuario introducirá la información necesaria para agregar un nuevo libro a la biblioteca.
	public static void anadirLibro()
	{
		//
	}
	
	
	
	
	// Se buscará un libro por su ID y se mostrarán sus detalles (si existe).
	public static void consultarLibro()
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile(recordfile, "rw");
			
			System.out.print("Introduce el id: ");
			int idToFind = input.nextInt();
			
			int posicion = findID(raf, idToFind);
			
			//Si la posicion existe
			if (posicion!=-1)
			{
				int id, year;
				char[] title = new char[50];
				char[] author = new char[30];
				boolean disp;
				
				//Lee los elementos
				id = raf.readInt();
				for (int i=0; i<title.length; i++)
				{
					title[i] = raf.readChar();
				}
				for (int i=0; i<author.length; i++)
				{
					author[i] = raf.readChar();
				}
				year = raf.readInt();
				disp = raf.readBoolean();
				
				//Y los imprime
				System.out.println("\n- "+id+") "+title.toString());
				System.out.println("    "+author.toString()+" ("+year+")");
				System.out.println("    "+(disp? "Disponible" : "No disponible")+".");
			}
			else {System.out.println("  El libro no existe.");}
			
			raf.close();
		}
		//Se lanza cuando no se ha introducido el argumento
		catch (ArrayIndexOutOfBoundsException e)	{System.out.println(" Se debe pasar 1 argumento.");}
		//Se lanza cuando la ruta de fichero por argumento no es valida
		catch (FileNotFoundException e)				{System.out.println(" No se encontró el archivo.");}
		//Es lanzado por BufferedReader.readLine()
		catch (IOException e)						{e.printStackTrace();}
	}
	
	
	
	
	// Permitir al usuario modificar el título, el autor o el año de publicación de un libro existente.
	public static void modificarLibro()
	{
		//
	}
	
	
	
	
	// Marcar un libro como no disponible, eliminándolo lógicamente (sin borrar el registro del fichero).
	public static void eliminarLibro()
	{
		//
	}
	
	
	
	
	// Mostrar en pantalla los libros que están disponibles para préstamo.
	public static void listarLibrosDisponibles()
	{
		//
	}
	
	
	
	
	
	
	// MAIN
	public static void main(String[] args)
	{
		recordfile = new File("libros.dat");
		input = new Scanner(System.in);
		int op = 0;
		
		do {
			System.out.println("----- Librería -----\n");
			System.out.println("1. Añadir un nuevo libro.");
			System.out.println("2. Consultar libro por ID.");
			System.out.println("3. Modificar los datos de un libro.");
			System.out.println("4. Eliminar un libro.");
			System.out.println("5. Listar todos los libros disponibles.");
			System.out.println("0. Salir");
			System.out.print("\nSelecciona una opcion: ");
			
			try
			{
				op = input.nextInt();
				
				if (op!=0)	{clear();}
				switch(op)
				{
					default: {System.out.println("Opción no válida");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1:	{anadirLibro();}	break;
					case 2:	{consultarLibro();}	break;
					case 3:	{modificarLibro();}	break;
					case 4:	{eliminarLibro();}	break;
					case 5:	{listarLibrosDisponibles();}	break;
				}
				if (op!=0)	{pressAnyKey();}
			}
			catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
		
		} while (op!=0);
	}
	
	
	
	
}