package ej3;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Ejercicio 3 – Ficheros binarios – 1.5 ptos.
 * 
 * Crea un programa que lea los primeros 54 bytes de un fichero BMP (su cabecera) 
 * que se pasa como argumento y compruebe si los dos primeros bytes de esos 54 
 * corresponden a las letras B y M.
 * Si lo son, escribirá el mensaje “Parece un BMP válido”, 
 * si no es así, mostrará el mensaje "No es un BMP válido”.  
 * Si es un BMP, mostrará el ancho y el alto de la imagen, 
 * si está comprimido o no, y el tamaño de la imagen.
 * 
 * Hacer un programa que muestre información sobre una imagen (enviada como argumento) 
 * en formato GIF (se deberá localizar en Internet los detalles sobre dicho formato): 
 * versión, ancho de la imagen (en píxeles), alto de la imagen y cantidad de colores.
 */

public class Ejercicio3 
{
	public static void main(String[] args)
	{
		try
		{
			DataInputStream raf = new DataInputStream(new FileInputStream(new File(args[0])));
			
			char letra;
			
			//raf.seek(0);
			letra = raf.readChar();
			
			if (letra=='B')
			{
				//raf.seek(26);
				letra = raf.readChar();
				
				if (letra=='M')
				{
					System.out.println(" No es un BMP válido");
				}
				else {System.out.println(" No es un BMP válido");}
			}
			else {System.out.println(" No es un BMP válido");}
			
			raf.close();
				
		}
		//Se lanza cuando no se ha introducido el argumento
		catch (ArrayIndexOutOfBoundsException e)	{System.out.println(" Se debe pasar 1 argumento.");}
		//Se lanza cuando la ruta de fichero por argumento no es valida
		catch (FileNotFoundException e)				{System.out.println(" No se encontró el archivo.");}
		//Es lanzado por BufferedReader.readLine()
		catch (IOException e)						{e.printStackTrace();}
				
		
		System.out.println();
	}
}