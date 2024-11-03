package ej3;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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
	public static int bytesToInt(byte[] bytes, int inicio, int fin)
	{
		int resultado = 0;
		for (int i = fin - 1; i >= inicio; i--)
		{
			resultado = (resultado << 8);
			resultado = resultado | (bytes[i] & 0xFF);
		}
		return resultado;
    }
	
	
	public static void main(String[] args)
	{
		try
		{
			File f = new File(args[0]);
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
			
			byte[] header = new byte[54];
			int width, height, size, comp;
			
			//Lee los toda la cabecera del bitmap
			for (int i=0; i<54; i++)
				{header[i] = (byte) dis.read();}
			
			//Si los dos primeros bytes son B y M
			if (header[0]=='B' && header[1]=='M')
			{
				System.out.println("Parece un BMP válido");
				
				//Dentro de la cabecera de un imagen BMP se guarda información del archivo:
				//  Bytes	Tipo de dato	Propiedad
				//  0 y 1	1 byte (char)	Tipo
				//  18-21	4 bytes (int)	Ancho en píxeles
				//  22-25	4 bytes (int)	Alto en píxeles
				//  30-33	4 bytes (int)	Compresión
				//  34-37	4 bytes (int)	Tamaño de imagen
				width = bytesToInt(header, 18, 21);
				height = bytesToInt(header, 22, 25);
				comp = bytesToInt(header, 30, 33);
				size = bytesToInt(header, 34, 37);
				System.out.println("Ancho:      "+width);
				System.out.println("Alto:       "+height);
				System.out.println("Tamaño:     "+size);
				System.out.println("Compresión: "+comp);
			}
			else {System.out.println("No es un BMP válido");}
			
			
			dis.close();	
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