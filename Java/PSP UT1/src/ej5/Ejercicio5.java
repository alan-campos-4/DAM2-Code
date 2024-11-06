package ej5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class Ejercicio5
{
	public static void main(String[] args)
	{
		String[] command = {"cmd.exe", "/c", "dir C:\\Windows"};
        try
        {
            ProcessBuilder processBuilder = new ProcessBuilder(command); // Split command into arguments
            processBuilder.redirectErrorStream(true);
            Process process = Runtime.getRuntime().exec(command);
            
            // Capture output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                output.append(line).append("\n");
            }
            
            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);
            System.out.println("\n"+output.toString());
        }
        catch (IOException | InterruptedException e)	{e.printStackTrace();}
	}
}