import general.Base;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Exer01_04_File
{
	static Scanner input;
	
	public static void main(String[] args)
	{
		input = new Scanner(System.in);
		int op = 0;
		
		do {
			Base.createMenu(1, "Mostrar contenido de un directorio", "Mostrar información de un fichero", 
					"Crear nuevo directorio", "Listar el contenido de directorios");
			
			try
			{
				op = input.nextInt();
				
				if (op!=0)	{Base.clear();}
				switch(op)
				{
					default: {System.out.println("\nOpción no válida.");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1:	{Ejer1();}	break;
					case 2:	{Ejer2(args[0]);}	break;
					case 3:	{Ejer3();}	break;
					case 4:	{Ejer4();}	break;
				}
				if (op!=0)	{Base.pressAnyKey();}
			}
			catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
			
		} while (op!=0);
	}
	
	
	
	
	/*
	 * 1. Realiza un programa que muestre los ficheros y/o directorios de un directorio 
	 * que se pasará al programa desde la línea de comandos al ejecutarlo. 
	 * Se visualizará cuántos archivos hay en total, el nombre de cada archivo y si es fichero o directorio.
	 */
	public static void Ejer1()
	{
		//
	}

	
	
	
	/*
	 * 2. Realiza un programa que muestre información sobre un fichero o directorio que pasa como parámetro.
	 */
	public static void Ejer2(String arg)
	{
		System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
		File f = new File(arg);  
		
		if(f.exists())
		{
			System.out.println("Nombre del fichero  : "+f.getName());
			System.out.println("Ruta                : "+f.getPath());
			System.out.println("Ruta absoluta       : "+f.getAbsolutePath());
			System.out.println("Se puede leer       : "+f.canRead());
			System.out.println("Se puede escribir   : "+f.canWrite());
			System.out.println("Tamaño              : "+f.length());
			System.out.println("Es un directorio    : "+f.isDirectory()); 
			System.out.println("Es un fichero       : "+f.isFile());
			System.out.println("Nombre del directorio padre: "+f.getParent());
		}
		else {System.out.println("el fichero no existe ");}
	}

	
	
	
	/*
	 * 3. Realiza un programa que cree un directorio de nombre “NUEVODIR” en el actual. 
	 * A continuación crea dos ficheros vacíos en dicho directorio y renombra uno de ellos y borra otro.
	 */
	public static void Ejer3()
	{
		File d = new File("NUEVODIR");
		File f1 = new File(d,"Fichero1.txt");
		File f2 = new File(d,"Fichero2.txt");
		d.mkdir();
		try
		{
			if (f1.createNewFile())
				System.out.println("FICHERO1 creado correctamente...");
		    else
		    	System.out.println("No se ha podido crear FICHERO1...");
			
			if (f2.createNewFile())
				System.out.println("FICHERO2 creado correctamente...");
		    else
		    	System.out.println("No se ha podido crear FICHERO2...");
		}
		catch (IOException ioe)	{ioe.printStackTrace();}  
		
		f1.renameTo(new File(d,"FICHERO1NUEVO"));
		
		try
		{
			File f3 = new File("NUEVODIR/FICHERO3.TXT");
			f3.createNewFile();
		}
		catch (IOException ioe)	{ioe.printStackTrace();}  
		
		if (f2.delete())
			System.out.println("FICHERO borrado...");
		else
			System.out.println("FICHERO no se puede borrar...");
	}

	
	
	
	/*
	 * 4. Listar el contenido de los directorios de forma recursiva. 
	 * Es decir, cada vez que nos encontremos un directorio dentro del directorio que estamos listando, 
	 * entraremos en él y listaremos su contenido.
	 * Así de forma recursiva sobre todos los directorios.
	 */
	public static void Ejer4()
	{
		String sDirectorio = "C:\\Users\\arantza\\eclipse-workspace";
		File directorio = new File(sDirectorio);
		
		listarDirectorio(directorio);	
	}
	public static void listarDirectorio(File f)
	{
		File[] ficheros = f.listFiles();
				
		for (int x=0;x<ficheros.length;x++)
		{
			System.out.println(ficheros[x].getName());
			
			if (ficheros[x].isDirectory())
			{
				listarDirectorio(ficheros[x]);
			}
		}
	}
	
	
	
	
	
	
}