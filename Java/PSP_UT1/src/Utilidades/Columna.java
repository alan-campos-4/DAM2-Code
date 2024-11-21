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
		        			System.out.println(res[index]);
		        		}
		        		//Si no se encuentra la columna pasa a la siguiente línea.
		        		catch (ArrayIndexOutOfBoundsException e)	{}
		        	}
		            linecount++;
		        }
			}
			//Lanzado por BufferedReader.readLine().
			catch (IOException e)	{e.printStackTrace();} 
		}
	}
}