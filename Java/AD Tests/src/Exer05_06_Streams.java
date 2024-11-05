import general.Base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Exer05_06_Streams
{
	static Scanner input;
	
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		int op = 0;
		
		do {
			Base.createMenu(5, "Mostrar contenido de un fichero", "Mostrar números en un fichero", 
					"Mostrar números primos en un fichero", "Copia de ficheros");
			try
			{
				op = input.nextInt();
				
				if (op!=0)	{Base.clear();}
				switch(op)
				{
					default: {System.out.println("Opción no válida");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1:	case 5:	{Ejer5();}	break;
					case 2:	case 6:	{Ejer6();}	break;
					case 3:	case 7:	{Ejer7();}	break;
					case 4:	case 8:	{Ejer8();}	break;
				}
				if (op!=0)	{Base.pressAnyKey();}
			}
			catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
		
		} while (op!=0);
	}
	
	
	
	
	/* Mostrar el contenido de fichero con el flujo BufferedReader*/
	public static void mostrarFicheroBuffer(String directory)
	{
		String line, header="", footer="";
		header = "----- "+new File(directory).getName()+" -----";
		for (int i=0; i<header.length(); i++) {footer += "-";}
		
		try
		{
			System.out.println(header);
			
			BufferedReader reader = new BufferedReader(new FileReader(directory));
			while((line = reader.readLine())!=null)
				{System.out.println(line);}
			reader.close();
			
			System.out.println(footer);
		}
		catch (FileNotFoundException fn)	{System.out.println("Fichero no encontrado");}
		catch (IOException io)				{System.out.println("Error de E/S");}
	}
	/* Mostrar el contenido de un fichero con el flujo FileReader */
	public static void mostrarFicheroFile(String directory)
	{
		String header="", footer="";
		header = "----- "+new File(directory).getName()+" -----";
		for (int i=0; i<header.length(); i++) {footer += "-";}
		
		try
		{
			System.out.println(header);
			
			FileReader fi = new FileReader("naturales.txt");
			int i;
			while ((i = fi.read())!=-1)
				{System.out.println(i);}
			fi.close();
			
			System.out.println(footer);
		}
		catch (FileNotFoundException fn)	{System.out.println("Fichero no encontrado");}
		catch (IOException io)				{System.out.println("Error de E/S");}
	}
	
	
	
	
	/*
	 * 5. Crea un fichero con un editor de textos y realiza un programa que visualice su contenido. 
	 * Modifica el programa para que acepte cualquier fichero que se envíe desde la línea de comandos.
	 */
	public static void Ejer5()
	{
		String dir;
		do 
		{
			System.out.print("Introduce un fichero: ");
			dir = input.next();
			
			mostrarFicheroBuffer(dir);
		}
		while (dir.equals(" "));
	}
	
	
	
	
	/*
	 * 6. Escribe un programa que escriba los 100 primeros números naturales en un archivo 
	 * numNaturales.txt. Después visualiza el contenido del archivo.
	 */
	public static void Ejer6()
	{
		String dir = "numNaturales.txt";
		try 
		{
			FileWriter fo = new FileWriter(dir);
			for (int i=1; i<=100; i++)
				{fo.write(i);}
			fo.close();
			
			mostrarFicheroFile(dir);
		}
		catch (IOException ex)	{System.out.println(ex.getMessage());}
	}
	
	
	
	
	/* 
	 * 7. Realiza un programa que escriba los primeros 20 números primos en un fichero de nombre 
	 * numprimos.txt. Después visualiza el contenido del archivo. 
	 * Se creará el método EsPrimo().
	 */
	public static void Ejer7()
	{
		String dir = "numprimos.txt";
		try 
		{
			FileWriter fo = new FileWriter(dir);
			for (int i=1; i<=20; i++)
			{
				if (esPrimo(i))
					{fo.write(i);}
			}
			fo.close();
			
			mostrarFicheroFile(dir);
		} 
		catch (IOException ex)	{System.out.println(ex.getMessage());}
	}
	public static boolean esPrimo(int num)
	{
		int contador = 2;
		boolean primo=true;
		
		if (num%2==0 && num!=2)
			{primo=false;}
		else
		{
			while ((primo) && (contador!=num))
			{
				if (num%contador==0)	{primo = false;}
				contador++;
			}
		}
		return primo;
	}
	
	
	
	/* 
	 * 8. Escribir un método que reciba por parámetro dos rutas correspondientes a un archivo 
	 * de origen y otro de destino y que copie el archivo origen en la ubicación destino. 
	 * La ruta destino puede consistir en un directorio o un archivo. 
	 * En el primer caso, el archivo se copiará al directorio especificado manteniendo su nombre. 
	 * En el segundo, se tomará como nombre del archivo copia el que especifique su ruta.
	 * */
	public static void Ejer8()
	{
		File in =  new File("..\\Ejercicio7\\numprimos.txt");
		File out = new File("C:\\Users\\arantza");
		
		try
		{
			if(!in.isFile())
			{
				System.out.println("El origen no es un fichero.");
				System.exit(1);
			}
			FileReader fr = new FileReader(in);
			
			// Condicion:	La ruta de origen NO es un fichero.
			// Implica:		Que el programa finaliza pues no hay nada que copiar.
			
			int i;
			if (out.isDirectory())
			{
				FileWriter fcopia = new FileWriter(out.getAbsolutePath()+"\\"+in.getName());
				while ((i=fr.read())!=-1)
				{
					fcopia.write(i);
				}
				fcopia.close();
			}
			else 
			{
				if (out.exists())
				{
					System.out.println("Fichero existe. No reemplazar");
				}
				else 
				{
					FileWriter fw = new FileWriter(out); 
					while ((i=fr.read())!=-1)
					{
						fw.write(i);
					}
					fw.close();}
			}
			fr.close();
		} 
		catch (IOException ex)	{System.out.println(ex.getMessage());}
	}
	
	
	
	
	
	
}