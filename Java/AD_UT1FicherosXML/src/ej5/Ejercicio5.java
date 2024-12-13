package ej5;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;


/* 
 * Ejercicio 5 – Fichero de objetos a XML – 1 pto
 * 
 * Escribe un programa para leer los datos de las cotizaciones grabadas mediante serialización 
 * en el ejercicio nº 5 de la práctica anterior y grabarlas en un documento cotizaciones.xml 
 * con el siguiente formato para cada empresa.
 * 	<Empresas>
 * 		<empresa>
 * 			<nombre>nombre</nombre>
 * 			<fecha>fecha</fecha>
 * 			<hora>hora</hora>
 * 			<cotizacion>cotizacion</cotizacion>
 * 		</empresa>
 * 		…
 * 	<Empresas>
 */


public class Ejercicio5
{
	public static File ficheroXML;
	public static ArrayList<Cotizacion> cotizaciones;
	
	/* Definición de clase Cotizacion */
	public static class Cotizacion
	{
		String nomEmpresa;
		double valor;
		String fecha;
		String hora;
		
		public Cotizacion (String n, double v, String f, String h)
		{
			this.nomEmpresa = n;
			this.valor = v;
			this.fecha = f;
			this.hora = h;
		}
		public String toString()
		{
			return " - "+nomEmpresa+"\n    Valor: "+valor+"\n    Fecha: "+fecha+" "+hora;
		}
	}
	
	
	/* Recorre la página web y obtiene los datos de las cotizaciones */
	//@SuppressWarnings("deprecation")
	public static void leerCotizaciones()
	{
		//Página web que vamos a examinar.
		String url = "https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201";
		
		//Variables para la lectura y escritura.
		String line, nombreEmpresa, cotizacion, hora;
		//Definición y formateo de la fecha actual.
		LocalDate fecha = LocalDate.now();	
		
		//Intenta acceder al contenido de la página web (openStream) y leerlo (BufferedReader).
		try
		{
			//Clase URL que representa la página web a la que accedemos.
			URI builder = URI.create(url);
			URL Url = builder.toURL();
			
        	//Accede al contenido de la página web.
        	BufferedReader br = new BufferedReader(new InputStreamReader(Url.openStream()));
        	//Guarda las entradas en el fichero.
        	DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroXML));
            
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
                    
                    //Guarda los valores como objeto.
                    Cotizacion c = new Cotizacion(nombreEmpresa, Double.parseDouble(cotizacion), fecha.toString(), hora);
                    System.out.println(c.toString());
            	}
            }
            dos.close();
            br.close();
            System.out.println("Cotizaciones guardadas");
        }
		//Lanzada por BufferedReader.readLine
        catch (IOException e)		{e.printStackTrace();}
	}
	
	
	/* Guarda todas las cotizaciones en el fichero XML */
	public static void guardarXML()
	{
		//
	}
	
	
	
	
	/* Función Main */
	public static void main(String[] args)
	{
		cotizaciones = new ArrayList<>();
		ficheroXML = new File("src/peliculas.xml");
		leerCotizaciones();
		guardarXML();
	}
	
	
	
	
}
