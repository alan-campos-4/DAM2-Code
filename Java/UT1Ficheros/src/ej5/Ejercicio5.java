package ej5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
	public static class Cotizacion
	{
		double valor;
		String fecha;
		
		public Cotizacion (double v, String fh)
		{
			this.valor = v;
			this.fecha = fh;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		//Página web que vamos a examinar.
		String url = "https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201";
		//Hasmap para almacenar los datos.
		HashMap<String, Cotizacion> cotizacionesHM = new HashMap<>();
		
		//Definición y formateo de la fecha y hora actual.
		
		
		
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
            String line;
            String nombreEmpresa, cotizacion, horaa = "";
            double cotValor;
            var sb = new StringBuilder();
            
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
                    while ((line = br.readLine()) != null)
                    {
                    	if (line.contains("<td>") && line.contains(":"))	{break;}
                    }
                    //la divide de forma que:	<td>13:31</td>  ->  13:31
                    //y la convierte en 
                    horaa = line.substring(line.lastIndexOf("<td>")+4, line.lastIndexOf("</td"));
                    //DateTimeFormatter parser = DateTimeFormatter.ofPattern("hh:mm");
                    //LocalTime localTime = LocalTime.parse(line, parser);
                    
                    //Guarda los valores el HashMap.
                    //cotizacionesHM.put(nombreEmpresa, new Cotizacion(cotValor, fecha, localTime));
                    
                    sb.append(nombreEmpresa+" | "+cotizacion+" | "+horaa+" | ");
                    sb.append(System.lineSeparator());
            	}
            }
            
            System.out.println(sb);
        }
        catch (IOException e)		{e.printStackTrace();}
	}
}
