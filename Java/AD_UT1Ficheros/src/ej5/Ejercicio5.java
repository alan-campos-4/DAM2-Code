package ej5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;

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
	//Definición de clase Cotizacion para el HashMap
	public static class Cotizacion
	{
		double valor;
		String fecha;
		String hora;
		public Cotizacion (double v, String f, String h)
		{
			this.valor = v;
			this.fecha = f;
			this.hora = h;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		//Página web que vamos a examinar.
		String url = "https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201";
		//Hasmap para almacenar los datos.
		HashMap<String, Cotizacion> cotizacionesHM = new HashMap<>();
		
		//Definición y formateo de la fecha actual.
		LocalDate fecha = LocalDate.now();
		
		//Clase que representa la URL de la página que vamos a examinar.
		URL Url = null;
		try
		{
			Url = new URL(url);
		}
		catch (MalformedURLException e)	{e.printStackTrace();}		
		
		//Intenta acceder al contenido de la página web (openStream) y leerlo (BufferedReader).
        try (var br = new BufferedReader(new InputStreamReader(Url.openStream())))
        {
            String line, nombreEmpresa, cotizacion, hora;
            double cotValor;
            
            //Recorre toda la página
            while ((line = br.readLine()) != null)
            {
            	//Busca la primera columna de la tabla "listado_valores", llamada "primera"
            	if (line.contains("<td class=\"primera\">"))
            	{
            		//Divide la parte de la línea que almacena el nombre de forma que: 
            		//		... title="ACCIONA">ACCIONA</a></td>    ->    ACCIONA
            		nombreEmpresa = line.substring(line.lastIndexOf("\">")+2, line.lastIndexOf("</a"));
            		
                    //Avanza a la siguiente línea, que almacena la cotización,
            		line = br.readLine();
                    //la divide de forma que:	<td>199,500</td>  ->  199,500
                    //y sustituye la coma para que pueda ser convertida en double.
                    cotizacion = line.substring(line.lastIndexOf("<td>")+4, line.lastIndexOf("</td>"));
                    cotizacion = cotizacion.replace(',', '.');
                    cotValor = Double.parseDouble(cotizacion);
                    
                    //Sigue leyendo hasta que encuentra la línea que almacena la hora,
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    br.readLine();
                    line = br.readLine();
                    //la divide de forma que:	<td>13:31</td>  ->  13:31
                    hora = line.substring(line.lastIndexOf("<td>")+4, line.lastIndexOf("</td"));
                    
                    //Guarda los valores el HashMap.
                    cotizacionesHM.put(nombreEmpresa, new Cotizacion(cotValor, fecha.toString(), hora));
            	}
            }
        }
        catch (IOException e)		{e.printStackTrace();}
	}
}
