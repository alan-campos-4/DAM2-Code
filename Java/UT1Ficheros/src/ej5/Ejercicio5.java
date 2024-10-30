package ej5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Ejercicio 5 – Filtros – 2 ptos
 * 
 * Escribe un programa que lea las últimas cotizaciones que aparecen en la página 
 * 		http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201 
 * y las guarde en un HashMap que contenga como clave el nombre de empresa y los datos fecha de hoy, 
 * el momento (hh:mm) y el valor de la cotización. 
 */

public class Ejercicio5
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		//Página web que vamos a examinar.
		String web="https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201";
		
		
		//Clase que representa la URL de la página que vamos a examinar.
		URL url = null;
		try
		{
			url = new URL(web);
		}
		catch (MalformedURLException e)	{e.printStackTrace();}
		
		
		//Intenta acceder al contenido de la página web (openStream) y leerlo (BufferedReader).
        try (var br = new BufferedReader(new InputStreamReader(url.openStream())))
        {
            String line;
            var sb = new StringBuilder();
            
            while ((line = br.readLine()) != null)
            {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            
            System.out.println(sb);
        }
        catch (IOException e)	{e.printStackTrace();}
	}
}
