package ej2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Ejercicio 2 – Ficheros de texto - Contar palabras – 1.5 ptos
 * 
 * a) Desarrolla un programa en Java que cuente el número total de palabras en un archivo de texto. 
 * El archivo se pasará como argumento en la línea de comandos. 
 * Se considera una "palabra" cualquier secuencia de caracteres que esté separada por espacios en blanco, 
 * saltos de línea o tabulaciones.
 * El programa debe:
 * 		1.	Utilizar las clases del paquete java.io para leer el archivo.
 * 		2.	Manejar errores relacionados con la lectura de archivos, 
 * 			un mensaje si el archivo no puede ser leído.
 * 		3.	Contar y mostrar el número total de palabras presentes en el archivo.
 * 		4.	Considerar los delimitadores estándar como espacios en blanco, 
 * 			saltos de línea y tabulaciones para separar palabras.
 * b) Modifica el programa para utilizar las clases del paquete java.nio
 */

public class Ejercicio2
{
	public static void pressAnyKey()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nPress any key to continue.");
        try {
            System.in.read();
            input.nextLine();
        } catch (Exception e) {e.printStackTrace();}
        
        input.close();
	}
	
	public static void main(String[] args)
	{
		try
		{
			int wordCount = 0;
			String line;
			String[] words;
			//Se utiliza BufferedReader	por su eficiencia en leer caracteres y líneas.
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
			
			//Mientras la línea que se lee no sea nula,
			while ((line = br.readLine()) != null)
			{
				//si la línea no está vacía,
	            if (!line.equals(""))
	            {
	            	//se añaden las palabras leídas a la cuenta.
	                words = line.split("\\s+"); 
	                wordCount += words.length;
	            }
	        }
			
			//Imprime por pantalla el número de palabras.
			System.out.println(" Este archivo contiene "+wordCount+" palabras.");
			br.close();
			
			pressAnyKey();
		}
		//Se lanza cuando no se ha introducido el argumento
		catch (ArrayIndexOutOfBoundsException e)	{System.out.println("  Se debe pasar 1 argumento.");}
		//Se lanza cuando la ruta de fichero por argumento no es valida
		catch (FileNotFoundException e)				{System.out.println("  No se encontró el archivo.");}
		//Lnzado por BufferedReader.readLine()
		catch (IOException e)						{e.printStackTrace();}
		
		System.out.println();
		
	}
}