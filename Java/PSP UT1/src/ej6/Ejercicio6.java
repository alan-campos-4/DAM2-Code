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
	
	//Obtiene el tamaño que ocupan todos los ficheros de un directorio.
	public static double readSize(String direc) throws NumberFormatException, IOException
	{
		//Comando para leer el espacio de los ficheros.
		String[] c2	= {"cmd.exe", "/c", "dir "+direc+" | "
			+ "java .\\src\\Utilidades\\Columna.java 3 | java .\\src\\Utilidades\\Suma.java"};
		ProcessBuilder pb = new ProcessBuilder(c2);
        Process p = pb.start();
        
        //Lee la salida del comando.
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        //Devuelve la salia del comando.
        String line = reader.readLine();
		return Double.parseDouble(line);
	}
	
	//Obtiene todos los directorios existentes dentro de una ruta.
	public static ArrayList<String> getDirectories(String direc) throws IOException
	{
		//Obtiene todos los directorios dentro del directorio dado.
		String[] c	= {"cmd.exe", "/c", "dir "+direc+" | java .\\src\\Utilidades\\Columna.java 4 "};
		ProcessBuilder pb = new ProcessBuilder(c);
	    Process p = pb.start();
	    ArrayList<String> results = new ArrayList<String>();
	    
		try
		{
			//Lee la salida del comando.
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        
	        //Por cada una de las líneas
			String line;
	        while( (line = input.readLine()) != null )
	        {
	        	//Solo si la línea no es número ni fichero se añade a la lista de directorios.
	        	if (!Character.isDigit(line.charAt(0)) &&
	        		!line.contains("."))
	        	{
	        		results.add(line);
	        	}
	        }
		}
		//Lanzado por BufferedReader.readLine().
		catch (IOException e)	{e.printStackTrace();} 
		
		return results;
	}
	
	//Examina los ficheros y directorios de una ruta recursivamente y obtiene el espacio.
	public static double examinePath(String path)
	{
		double size = 0.0;
		try
		{
			//Lee el espacio de los ficheros y los directorios de la ruta.
			size = readSize(path);
			ArrayList<String> directories = getDirectories(path);
			
			//Si no tiene más directorios dentro finaliza la búsqueda.
			if (directories.isEmpty())	{System.out.println("Path "+path+" contains "+size+" bytes");}
			//Si tiene más directorios los examina recursivamente.
			else
			{
				for (String dir : directories)
					{size += examinePath(path+"\\"+dir);}
			}
		}
		//Lanzada por BufferedReader.readLine().
        catch (IOException e)			{e.printStackTrace();}
		
		return size;
	}
	
	
	public static void main(String[] args)
	{
		String ruta = "C:\\Windows";
		double espacio = examinePath(ruta);
		
		System.out.println("El tamaño de "+ruta+" es "+espacio+".");
	}
}
