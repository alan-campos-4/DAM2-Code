package ej2;
import java.io.*;

/*
 * Ejercicio 2 – Ficheros de texto - Contar palabras – 1.5 ptos
 * 
 * a) Desarrolla un programa en Java que cuente el número total de palabras en un archivo de texto. 
 * El archivo se pasará como argumento en la línea de comandos. 
 * Se considera una "palabra" cualquier secuencia de caracteres que esté separada por espacios en blanco, 
 * saltos de línea o tabulaciones.
 * El programa debe:
 * 		1.	Utilizar las clases del paquete java.io para leer el archivo.
 * 		2.	Manejar errores relacionados con la lectura de archivos, un mensaje si el archivo no puede ser leído.
 * 		3.	Contar y mostrar el número total de palabras presentes en el archivo.
 * 		4.	Considerar los delimitadores estándar como espacios en blanco, saltos de línea y tabulaciones para separar palabras.
 * b) Modifica el programa para utilizar las clases del paquete java.nio
 */

public class Ejercicio2
{
	public static void main(String[] args)
	{
		try
		{
			int wordCount = 0, charCount = 0;
			String line;
			String[] words;
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
			
			while ((line = br.readLine()) != null)
			{
	            if (!line.equals(""))
	            {
	                charCount += line.length(); 
	                words = line.split("\\s+"); 
	                wordCount += words.length;
	                //whiteSpaceCount += wordCount - 1; 
	                //String sentence[] = line.split("[!?.:]+"); 
	                //sentenceCount += sentence.length; 
	            }
	        }
			
			System.out.println("Este archivo contiene "+wordCount+" palabras. "+charCount);
			
//			int num1digit = 9;
//			int num2digit = 99 - num1digit;
//			int num3digit = 999 - num2digit - num1digit;
//			int num4digit = 9999 - num3digit - num2digit - num1digit;
//			
//			System.out.println("Cifras");
//			System.out.println("1: "+num1digit);
//			System.out.println("2: "+num2digit);
//			System.out.println("3: "+num3digit);
//			System.out.println("4: "+num4digit);
		}
		catch (FileNotFoundException e)	{System.out.println("No se encontró el archivo.");} 
		catch (IOException e) 			{e.printStackTrace();}
	}
}
