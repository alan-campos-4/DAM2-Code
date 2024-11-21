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
	        double sum = 0.0;
	        
	        //Por cada una de las líneas
	        while( (line = input.readLine()) != null )
	        {
	        	//Solo si la línea no es ni un directorio ni un comentario.
	        	if (!line.contains("<DIR>") && 
	        		!line.contains("archivos") && 
	        		!line.contains("dirs"))
	        	{
	        		//Si tienes más de una comilla la elimina
	        		if ( (line.length() - line.replace(",", "").length()) > 1 )
	        		{
	        			StringBuilder sb = new StringBuilder(line);
	        			sb.deleteCharAt(line.indexOf(','));
	        			line = sb.toString();
	        		}
	        		//Reemplaza la comilla con un punto para poder considerarse como double.
	        		line = line.replace(',', '.');
	        		//Pasa la línea como doble y lo añade a la suma total.
	        		sum += Double.parseDouble(line);
	        	}
	        }
	        System.out.println(sum);
		}
		//Lanzada por Double.parse() si no puede convertir.
		catch (NumberFormatException e)	{e.printStackTrace();}
		//Lanzado por BufferedReader.readLine().
		catch (IOException e)			{e.printStackTrace();}
	}
}