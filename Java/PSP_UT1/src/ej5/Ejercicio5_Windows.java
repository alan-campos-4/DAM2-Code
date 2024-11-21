package ej5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * El comando dir o ls -al en sus correspondientes sistemas operativos 
 * devuelven el tamaño de los archivos en su resultado.
 * Deseamos obtener información de la carpeta “Windows” o la carpeta “/usr/bin”. 
 * Para este propósito vamos a realizar un programa que combinando 
 * la funcionalidad de los comandos anteriores y los programas auxiliares antes descritos nos indique: 
 * 
 *  1. Tamaño de los ficheros de la carpeta. Sería equivalente a: 
 *  	dir \windows | java Columna 3  
 *  	ls -al /usr/bin | java Columna 5 
 *  
 *  2.  Tamaño de la carpeta. Sería equivalente a: 
 *  	dir \windows | java Columna 3 | java Suma 
 *  	ls -al /usr/bin | java Columna 5 | java Suma
 *  
 *  3.  Tamaño del fichero mayor. Sería equivalente a  
 *  	dir \windows | java Columna 3 | java Mayor 
 *  	ls -al /usr/bin | java Columna 5 | java Mayor
 */

public class Ejercicio5_Windows
{
	public static void main(String[] args)
	{
		//Tamaño de los ficheros de la carpeta.
		String[] c1 = {"cmd.exe", "/c", "dir C:\\Windows | java .\\src\\Utilidades\\Columna.java 3"};
		
		//Tamaño de la carpeta.
		String[] c2	= {"cmd.exe", "/c", "dir C:\\Windows | java .\\src\\Utilidades\\Columna.java 3 | java .\\src\\Utilidades\\Suma.java"};
		
		//Tamaño del fichero mayor.
		String[] c3 = {"cmd.exe", "/c", "dir C:\\Windows | java .\\src\\Utilidades\\Columna.java 3 | java .\\src\\Utilidades\\Mayor.java"};
		
		//Todos los comandos a ejecutar
		ArrayList<String[]> Commands = new ArrayList<>();
		Commands.add(c1);
		Commands.add(c2);
		Commands.add(c3);
		
		//Por cada comando
        for (String[] command : Commands)
        {
			try
	        {
				//Construye el proceso a partir del comando y lo ejecuta.
	            ProcessBuilder pb = new ProcessBuilder(command);
	            Process process = pb.start();
	            
	            //Lee la salida del comando.
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