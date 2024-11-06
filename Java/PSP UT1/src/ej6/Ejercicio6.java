package ej6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ejercicio6
{
	/*
	 * Imagina que deseamos conocer el tamaño de varias carpetas de nuestro sistema. 
	 * Como podríamos, utilizando las herramientas del ejercicio anterior conseguir 
	 * que se calculase concurrentemente, a la vez, no una detrás de otra, el tamaño total de las mismas. 
	 * Estudia el problema e intenta solventarlo con un ejemplo.
	 */
	
	public static void main(String[] args)
	{
		//Tamaño de los ficheros de la carpeta.
		String[] c1 = {"cmd.exe", "/c", "dir C:\\Windows | java .\\src\\Utilidades\\Columna.java 3"};
		
		//Todos los comandos a ejecutar
		ArrayList<String[]> Commands = new ArrayList<>();
		Commands.add(c1);
		
		//Por cada comando
        for (String[] command : Commands)
        {
			try
	        {
				//Construye el proceso a partir del comando y lo empieza
	            ProcessBuilder pb = new ProcessBuilder(command);
	            Process process = pb.start();
	            
	            //Construye un BufferedReader para leer el comando pasa por pipe.
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            
	            //Lee cada línea del resultado y lo guarda en el StringBuilder.
	            StringBuilder output = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null)
	            {
	                output.append(line).append("\n");
	            }
	            
	            //Muestra el resultado del comando.
	            System.out.println("Comando ejecutado con codido de salida ");
	            System.out.println("\n"+output.toString());
	            System.out.println("\n\n");
	        }
			//Lanzada por BufferedReader.readLine().
	        catch (IOException e)			{e.printStackTrace();}
        }
	}
}