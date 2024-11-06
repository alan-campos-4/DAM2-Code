package Utilidades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * El programa “Columna” leerá su entrada estándar línea a línea procesando 
 * la cadena leída de tal forma que utilizando como caracteres separadores 
 * el espacio y el tabulador identificará las columnas que tiene cada línea, 
 * pudiendo extraer una columna seleccionada y mostrándola por su salida estándar. 
 * 
 * Como puedes apreciar, se crearán columnas utilizando como separados 
 * uno o más caracteres de espacio o tabulador (\t). 
 * Si la columna no solicitada no existe para la línea procesada 
 * entonces se dejará vacía la línea de salida. 
 * Nota: Para resolver este problema puede ser interesante utilizar expresiones regulares, 
 * pues simplifican la solución.
 */

public class Columna
{
	/* 
	 * Cuando se ejecuta en el Símbolo de Sistema de Windows, el comando dir tiene este formato:
	 * ***
	 *  El volumen de la unidad C no tiene etiqueta.
	 *  El número de serie del volumen es: 1E93-F5D8
	 *  
	 *  Directorio de C:\Windows
	 * 
	 * 04/11/2024  11:40    <DIR>          .
	 * 07/10/2024  11:57    <DIR>          AppReadiness
	 * 22/10/2024  09:15    <DIR>          assembly
	 * 09/10/2024  12:58           122.880 bfsvc.exe
	 * 27/09/2024  11:17             2.667 DtcInstall.log
	 *               21 archivos      8.509.923 bytes
	 *               78 dirs  299.814.277.120 bytes libres
	 * 
	 * ***
	 * Este programa ha sido diseñado recopilar el tamaño de cada archivo en el directorio,
	 * ignorando las filas vacías o que contengan información innecesaria.
	 * */
	public static void main(String[] args)
	{
		int index = 0;
		
		try
		{
			index = Integer.parseInt(args[0])-1;
		}
		//Lanzado si el parámetro no se puede convertir a entero.
		catch (NumberFormatException e)				{System.out.println("  Argumento no válido.");}
		//Lanzado si no se pasa un parámetro por línea.
		catch (ArrayIndexOutOfBoundsException e)	{System.out.println("  Debes introducir 1 argumento.");}
		finally
		{
			try
			{
				//Lee el comando recibido por pipe.
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				String[] res;
		        String line = null;
		        int linecount = 0;
		        //Por cada una de las líneas
		        while( (line = input.readLine()) != null )
		        {
		        	//Salta las líneas innecesarias
		        	if (!line.equals("") && linecount>4)
		        	{
		        		//Divide la línea en columnas por espacios o tabuladores
		        		res = line.split("\\s+|\t");
		        		try
		        		{
		        			//Se asegura que la columna es un número, si no es una carpeta.
		        			Double.parseDouble(res[index]);
		        			//Escribe el espacio del archivo.
		        			System.out.println(res[index]);
		        		}
		        		//Si no es un número o no se encuentra la columna pasa a la siguiente línea.
		        		catch (ArrayIndexOutOfBoundsException e)	{}
		        		catch (NumberFormatException e)				{}
		        	}
		            linecount++;
		        }
			}
			//Lanzado por BufferedReader.readLine().
			catch (IOException e)	{e.printStackTrace();} 
		}
	}
}
