package ej4W;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ejercicio4_Windows
{
	/*
	 * Se desea que implementes la aplicación “Servicios” que utilizando el comando “tasklist” 
	 * (sin parámetros, o en otro caso no se considerará), 
	 * devolverá el nombre y datos de los servicios (sólo servicios) 
	 * que están corriendo en nuestro sistema operativo (Windows)
	 * 
	 * El programa no debería utilizar / crear ficheros intermedios con las clases de java, 
	 * que no sean las que proporciona la gestión de procesos.
	 */
	
	public static void main(String[] args)
	{
		//El comando a ejecutar: todos los servicios que están corriendo en nuestro sistema.
		String[] command = {"cmd.exe", "/c", "tasklist /fi \"STATUS eq running\""};
        try
        {
        	//Construye el proceso a partir del comando y lo ejecuta.
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();
            
            //Lee la salida del comando ejecutado.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            //Lee cada línea del resultado y lo guarda en el StringBuilder.
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                output.append(line).append("\n");
            }
            
            //Muestra el resultado del comando.
            System.out.println(output.toString());
        }
		//Lanzada por BufferedReader.readLine().
        catch (IOException e)			{e.printStackTrace();}
	}
}
