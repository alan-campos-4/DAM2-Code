package ej4W;
import java.io.IOException;
import java.io.PrintStream;


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
		try
		{
			StringBuilder sb;
			ProcessBuilder pb = new ProcessBuilder("tasklist");
			Process p = pb.start();
			
			
		}
		catch (IOException e)	{e.printStackTrace();}
	}
}
