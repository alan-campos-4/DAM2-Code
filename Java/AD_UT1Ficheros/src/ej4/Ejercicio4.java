package ej4;

import java.io.EOFException;
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
 * 		  El usuario introducirá la información necesaria para agregar un nuevo libro a la biblioteca.
 * o	Consultar libro por ID:
 * 		  Se buscará un libro por su ID y se mostrarán sus detalles (si existe).
 * o	Modificar los datos de un libro: 
 * 		  Permitir al usuario modificar el título, el autor o el año de publicación de un libro existente.
 * o	Eliminar un libro: 
 * 		  Marcar un libro como no disponible, eliminándolo lógicamente (sin borrar el registro del fichero).
 * o	Listar todos los libros disponibles: 
 * 		  Mostrar en pantalla los libros que están disponibles para préstamo.

 */

public class Ejercicio4
{
	/***** MAIN *****/
	public static void main(String[] args)
	{
		int op;
		
		try
		{
			input = new Scanner(System.in);
			fichero = new File("src/ej4/biblioteca.dat");
			
			do {
				System.out.println("----- Librería -----\n");
				System.out.println("1. Añadir un nuevo libro.");
				System.out.println("2. Consultar libro por ID.");
				System.out.println("3. Modificar los datos de un libro.");
				System.out.println("4. Eliminar un libro.");
				System.out.println("5. Listar todos los libros disponibles.");
				System.out.println("0. Salir");
				System.out.print("\nSelecciona una opcion: ");
				
				op = input.nextInt();
				
				if (op!=0)	{clear();}
				switch(op)
				{
					default: {System.out.println("\nOpción no válida.");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1:	{anadirLibro();}	break;
					case 2:	{consultarLibro();}	break;
					case 3:	{modificarLibro();}	break;
					case 4:	{eliminarLibro();}	break;
					case 5:	{listarLibrosDisponibles();}	break;
				}
				if (op!=0)	{clear();}
				
			} while (op!=0);
			
			input.close();
		}
		//Puede ser lanzada si la opción introducida no es un entero.
		catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
		//Puede ser lanzada cada vez que se declara un nuevo fichero de acceso aleatorio.
		catch (FileNotFoundException e)		{System.out.println("\n  No se ha encontrado el fichero.");}
		//Puede ser lanzada cada vez que se ejecuta un método de el fichero de acceso aleatorio.
		catch (IOException e)				{e.printStackTrace();}
	}
	
	
	//Scanner para leer por línea.
	public static Scanner input;
	//Fichero donde se guardan los datos.
	public static File fichero;
	//Acceso aleatorio al fichero.
	public static RandomAccessFile RAF;
	
	//Tamaño máximo de la variable título de un Libro.
	public static final int TitleLength = 50;
	//Tamaño máximo de la variable autor de un Libro.
	public static final int AuthorLength = 30;
	//Tamaño total en bytes de una instancia de la clase Libro.
	public static final int sizeOfLibro = 169;
	/* 		id		int			4 bytes
	 * 		titulo	string(50)	2 bytes*50
	 *		autor	string(30)	2 bytes*30
	 *		año		int			4 bytes
	 *		disp	boolean		1 bytes
	 * 		4 + 2*50 + 2*30 + 4 + 1 = 169 bytes */
	
	
	
	
	
	/***** Funciones adicionales *****/
	
	/* Limpia el terminal. */
	public static void clear()
	{
		System.out.println("\n\n\n\n\n");
	}
	
	/* Devuelve la posición de un libro dentro del fichero si existe, y -1 si no existe. */
	public static int getPosicion(int idToFind) throws IOException
	{
		int id, posicion;
		
		try
		{
			//Empezando principio del fichero.
			posicion = 0;
			
			//Mientras no llegue al final
			do {
				//Busca en la posición.
				RAF.seek(posicion);
				//Lee el id del libro.
				id = RAF.readInt();
				
				//Si coincide devuelva la posición.
				if (id==idToFind)	{return posicion;}
				
				//Avanza al siguiente libro.
				posicion = posicion + sizeOfLibro;
				
			} while (RAF.getFilePointer()!=RAF.length());
		}
		//Lanzada si el lector llega al final del fichero.
		catch (EOFException e)	{return -1;}
		
		return -1;
	}
	
	/* Cuenta cuántos libros tiene el fichero y devuelve un ID para uno nuevo. */
	public static int getNewID() throws IOException
	{
		int idCount = 0, posicion;
		
		try
		{
			//Teniendo cero libros;
			idCount = 0;
			//Se coloca el principio del fichero.
			posicion = 0;
			
			//Mientras no llege al final
			do {
				//Busca en la posición.
				RAF.seek(posicion);	
				//Lee el id del libro.
				RAF.readInt();	
				//Incrementa el número de libros.
				idCount++;
				//Avanza al siguiente libro.
				posicion = posicion + sizeOfLibro;
				
			} while (RAF.getFilePointer()!=RAF.length());
		}
		//Lanzada si el lector llega al final del fichero.
		catch (EOFException e)	{}
		
		//Devuelve el número de libros + 1, ya que el nuevo será el siguiente.
		return idCount + 1;
	}
	
	/* Devuelve el titulo de un libro como string tras leerlo caracter a caracter. 
	 * Se debe llamar con el fichero de acceso aleatorio abierto.*/
	public static String readTitle() throws IOException
	{
		char titulo[] = new char[TitleLength];
		for (int i=0; i<TitleLength; i++)
		{
			titulo[i] = RAF.readChar();;
		}
		return new String(titulo);
	}
	
	/* Devuelve el autor de un libro como string tras leerlo caracter a caracter.
	 * Se debe llamar con el fichero de acceso aleatorio abierto. */
	public static String readAuthor() throws IOException
	{
		char autor[] = new char[AuthorLength];
		for (int i=0; i<AuthorLength; i++)
		{
			autor[i] = RAF.readChar();
		}
		return new String(autor);
	}
	
	
	
	
	
	/***** Funciones principales *****/
	
	/* El usuario introducirá la información necesaria para agregar un nuevo libro a la biblioteca. */
	public static void anadirLibro() throws IOException, FileNotFoundException
	{
		try
		{
			int id, anio;
			String titulo, autor;
			StringBuffer buffer1 = null, buffer2 = null;
			
			//Declara el fichero de acceso aleatorio con lectura y escritura.
			RAF = new RandomAccessFile(fichero, "rw");
			//Se coloca al final del fichero.
			RAF.seek(RAF.length());
			
			input.nextLine(); //Salta la línea para poder leer después del entero op.
			
			//Lee todos los datos por línea.
			id = getNewID();
			System.out.println("Este libro se añadirá con el ID "+id+".");
			System.out.print("Titulo: ");	titulo = input.nextLine();
			System.out.print("Autor: ");	autor = input.nextLine();
			System.out.print("Año: ");		anio = input.nextInt();
			
			//Pasa las cadenas a buffers para darles una longitud máxima.
			buffer1 = new StringBuffer(titulo);
			buffer2 = new StringBuffer(autor);
			buffer1.setLength(TitleLength);
			buffer2.setLength(AuthorLength);
			
			//Escrribe los datos en en fichero.
			RAF.writeInt(id);
			RAF.writeChars(buffer1.toString());
			RAF.writeChars(buffer2.toString());
			RAF.writeInt(anio);
			RAF.writeBoolean(true);
			
			//Confirma el guardado.
			System.out.println("\nLibro guardado.");
			//Cierra el acceso.
			RAF.close();
		}
		//Puede ser lanzada cuando el tipo de dato leído por el Scanner no es correcto.
		catch (InputMismatchException e)	{System.out.println("\n  Datos no válidos.");}
	}
	
	
	
	/* Se buscará un libro por su ID y se mostrarán sus detalles (si existe). */
	public static void consultarLibro() throws IOException, FileNotFoundException
	{
		int id, anio, posicion, idToFind;
		boolean disp;
		String tituloS, autorS;
		
		//Declara el fichero de acceso aleatorio con lectura.
		RAF = new RandomAccessFile(fichero, "r");
		
		//Preguntamos el ID a buscar.
		System.out.print("Introduce el ID: ");
		idToFind = input.nextInt();
		//Busca la posicion del libro basado en el ID.
		posicion = getPosicion(idToFind);
		
		//Si el libro existe,
		if (posicion!=-1)
		{
			//Se coloca en la posición. 
			RAF.seek(posicion);	
			
			//Lee el ID del libro.
			id = RAF.readInt();	
			//Lee el titulo y el autor.
			tituloS = readTitle();
			autorS = readAuthor();
			//Lee el año y la disponibilidad.
			anio = RAF.readInt();
			disp = RAF.readBoolean();
			
			//Muestra toda la información
			System.out.println(" ID: "+id);
			System.out.println("  Titulo: "+tituloS);
			System.out.println("  Autor:  "+autorS);
			System.out.println("  Año:    "+anio);
			System.out.println("  "+(disp ? "Disponible" : "No disponible")+"\n" );
		}
		//Si no existe lo indica.
		else {System.out.println("\n  El libro no existe.");}
		
		RAF.close();
		
	}
	
	
	
	/* Permitir al usuario modificar el título, el autor o el año de publicación de un libro existente.*/
	public static void modificarLibro() throws IOException, FileNotFoundException
	{
		int id, anio, posicion, idToFind;
		boolean disp;
		String tituloS, autorS;
		
		//Declara el fichero de acceso aleatorio con lectura y escritura.
		RAF = new RandomAccessFile(fichero, "rw");
		
		//Preguntamos el ID a buscar.
		System.out.print("Introduce el ID: ");
		idToFind = input.nextInt();
		//Busca la posicion del libro basado en el ID.
		posicion = getPosicion(idToFind);
		
		//Si el libro existe,
		if (posicion!=-1)
		{
			//Se coloca en la posición. 
			RAF.seek(posicion);
			
			//Lee el ID del libro.
			id = RAF.readInt();
			//Lee el titulo y el autor por caracter y los pasa a strings.
			tituloS = readTitle();
			autorS = readAuthor();
			//Lee el año y la disponibilidad.
			anio = RAF.readInt();
			disp = RAF.readBoolean();
			
			//Muestra toda la información
			System.out.println("Este libro es:");
			System.out.println("  ID: "+id);
			System.out.println("  Titulo: "+tituloS);
			System.out.println("  Autor:  "+autorS);
			System.out.println("  Año:    "+anio);
			System.out.println("  "+(disp ? "Disponible" : "No disponible")+"\n" );
			
			char opt;
			StringBuffer sb1 = null, sb2 = null;
			input.nextLine();  //Salta la línea para poder leer después del entero idToFind.
			
			try
			{
				//Pregunta y lee si quiere modificar el titulo guardado.
				System.out.print("Quieres modificar el título (s/n): ");
				opt = input.nextLine().charAt(0);
				if (opt=='S' || opt=='s')
				{
					System.out.print("Titulo: ");
					tituloS = input.nextLine();
				}
				//Pregunta y lee si quiere modificar el autor guardado.
				System.out.print("Quieres modificar el autor (s/n): ");
				opt = input.nextLine().charAt(0);
				if (opt=='S' || opt=='s')
				{
					System.out.print("Autor: ");
					autorS = input.nextLine();
				}
				//Pregunta y lee si quiere modificar el año guardado.
				System.out.print("Quieres modificar el el año de publicación (s/n): ");
				opt = input.nextLine().charAt(0);
				if (opt=='S' || opt=='s')
				{
					System.out.print("Año: ");
					anio = input.nextInt();
				}
				
				//Vuelva a la posicion para poder modificar los datos.
				RAF.seek(posicion);
				RAF.writeInt(id);
				//Escribe las variables al fichero.
				// Las que no se haya cambiado seguiran siendo las que se leyeron al principio.
				sb1 = new StringBuffer(tituloS);
				sb2 = new StringBuffer(autorS);
				sb1.setLength(TitleLength);
				sb2.setLength(AuthorLength);
				RAF.writeChars(sb1.toString());
				RAF.writeChars(sb2.toString());
				RAF.writeInt(anio);
			}
			//Puede ser lanzada cuando el tipo de dato leído por el Scanner no es correcto.
			catch (InputMismatchException e)	{System.out.println("\n  Datos no válidos.");}
		}
		//Si no existe lo indica.
		else {System.out.println("\n  El libro no existe.");}
		
		RAF.close();
	}
	
	
	
	/* Marcar un libro como no disponible, eliminándolo lógicamente (sin borrar el registro del fichero). */
	public static void eliminarLibro() throws IOException, FileNotFoundException
	{
		int idToFind, posicion;
		String tituloS, autorS;
		
		//Declara el fichero de acceso aleatorio con lectura y escritura.
		RAF = new RandomAccessFile(fichero, "rw");
		
		//Preguntamos el ID a buscar.
		System.out.print("Introduce el ID: ");
		idToFind = input.nextInt();
		
		//Busca la posicion del libro basado en el ID.
		posicion = getPosicion(idToFind);
		
		//Si el libro existe,
		if (posicion!=-1)
		{
			//Se coloca en la posición. 
			RAF.seek(posicion);	
			
			//Lee todas las variables hasta llegar a la disponibilidad.
			// Solo se guardan título y autor para indicar qué libro se ha borrado.
			RAF.readInt();
			tituloS = readTitle();
			autorS = readAuthor();
			RAF.readInt();
			
			//Modifica el valor de la disponibilidad.
			RAF.writeBoolean(false);
			
			//Muestra toda la información
			System.out.println("  "+tituloS+" de "+autorS+" se ha eliminado.");
		}
		//Si no existe lo indica.
		else {System.out.println("\n  El libro no existe.");}
		
		RAF.close();
	}
	
	
	
	
	/* Mostrar en pantalla los libros que están disponibles para préstamo. */
	public static void listarLibrosDisponibles() throws IOException, FileNotFoundException
	{
		try
		{
			int id, anio, posicion;
			boolean disp;
			String tituloS, autorS;
			
			//Declara el fichero de acceso aleatorio con lectura.
			RAF = new RandomAccessFile(fichero, "r");
			
			//Desde el principio.
			posicion = 0;
			do {
				//Busca en la posición.
				RAF.seek(posicion);	
				
				//Lee el id del libro.
				id = RAF.readInt();
				//Lee el titulo y el autor por.
				tituloS = readTitle();
				autorS = readAuthor();
				//Lee el año y la disponibilidad.
				anio = RAF.readInt();
				disp = RAF.readBoolean();
				
				//Si está disponible muestra la información.
				if (disp)
				{
					System.out.println(" ID: "+id);
					System.out.println("  Titulo: "+tituloS);
					System.out.println("  Autor:  "+autorS);
					System.out.println("  Año:    "+anio);
					System.out.println("\n");
				}
				
				//Avanza al siguiente libro.
				posicion = posicion + sizeOfLibro;
				
			} while (RAF.getFilePointer()!=RAF.length());
			
			RAF.close();
		}
		//Lanzada si el lector llega al final del fichero.
		catch (EOFException e)				{System.out.println("\n  Fin del fichero.");}
	}
	
	
	
	
	
	
}