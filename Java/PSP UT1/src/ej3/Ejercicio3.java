package ej3;
import java.io.IOException;


public class Ejercicio3
{
	public static void main(String[] args)
	{
		//
		/*
		 * Debes de realizar un programa en Java que ponga en funcionamiento 
		 * al menos 3 procesos (programas diferentes) en tu equipo. 
		 * 
		 * Dicho programa esperará a que cada uno de los procesos que ha arrancado 
		 * finalice para terminar. 
		 * 
		 * Tu programa mostrará los PID de los procesos que ha levantado (ejecutado). 
		 * Para ello harás uso del método ProcessHandle() de la clase Process.
		 * 
		 */
		
		
		String[] rutas = 
		{
			"\"C:\\Windows\\System32\\calc.exe\"",
			"\"C:\\Windows\\System32\\calc.exe\"",
			"\"C:\\Windows\\System32\\calc.exe\""
		};
		
		int n = rutas.length;
		ProcessBuilder[] pb = new ProcessBuilder[n];
		
		try
		{
			ProcessBuilder pb1 = new ProcessBuilder(rutas[0]);
			pb1.start();
		}
	    catch (IOException e)			{e.printStackTrace();}
		
		
	}
}
