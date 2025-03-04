import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/*
• Implementar una aplicación en Java que:
	o Se conecte a una URL indicada desde la línea de comandos.
	o Descargue el contenido HTML del recurso.
	o Guarde el contenido en un fichero especificado.
• Analizar y gestionar los códigos de respuesta HTTP, comprendiendo su significado:
	o 200 (OK): Descarga exitosa.
	o 301/302 (Redirección): La URL solicitada ha sido movida.
	o 404 (No encontrado): El recurso no existe.
• Automatizar la ejecución mediante la creación de un script (.bat en Windows) que permita 
  ejecutar la aplicación con múltiples URLs.
• Comparar y analizar el contenido descargado versus lo que se visualiza en un navegador, 
  utilizando herramientas de desarrollo web para investigar posibles discrepancias.
*/

public class DescargaURL
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		if (args.length==2)
		{
			try
			{
				//Crea una nueva conexion a la dirección pasada por parámetro.
				URL url = new URL(args[0]);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(5000);	// 5 segundos para conectarse
				connection.setReadTimeout(5000);	// 5 segundos para leer datos
				
				//Obtiene el código de respuesta de la conexión.
				int responseCode = connection.getResponseCode();
				
				//Recorre la conexión y guarda su contenido en un StringBuilder.
				String line;
				StringBuilder content = new StringBuilder();
				try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
				{
					while ((line = in.readLine()) != null)
					{
						content.append(line).append("\n");
					}
					System.out.println("Contenido leído.");
				}
				
				//Guarda el contenido en un fichero con el nombre pasado por parámetro.
				try (PrintWriter out = new PrintWriter(new FileWriter(args[1])))
				{
					out.println(content.toString());
					System.out.println("Contenido guardado a fichero.");
				}
				
				//Devuelve el código de respuesta para que se muestre en el script.
				System.exit(responseCode);
			}
			//Lanzada si no se puede obtener el codigo de respuesta de la conexion.
			catch (FileNotFoundException e)	{System.exit(404);}
			//Lanzada si la direccion dada no se encuentra.
			catch (UnknownHostException e)	{System.err.println(e.getMessage());}
			//Lanzada si la direccion dada está mal formada.
			catch (MalformedURLException e)	{System.err.println(e.getMessage());}
			catch (IOException e)			{System.err.println(e.getMessage());}
		}
		else {System.err.println("Error. Número de parámetros incorrecto.");}
	}

}
