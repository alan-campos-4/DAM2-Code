package Utilidades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * El programa suma leerá números de su entrada estándar y escribirá como resultado 
 * en la salida estándar la suma de los mismos.
 */

public class Suma
{
	public static void main(String[] args)
	{
		try
		{
			//Lee el resultado del comando recibido por pipe.
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        double sum = 0.0, newline = 0.0;
	        //Por cada una de las líneas
	        while( (line = input.readLine()) != null )
	        {
	        	newline = Double.parseDouble(line);
	        	sum += newline;
	        }
	        System.out.println("Suma = "+sum);
		}
		//Lanzado por BufferedReader.readLine().
		catch (IOException e)	{e.printStackTrace();}
	}
}