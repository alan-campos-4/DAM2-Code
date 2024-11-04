package ej3;
import java.io.IOException;


public class Ejercicio3
{
	public static void main(String[] args) throws IOException
	{
		String[] rutas = 
		{
			"C:\\Windows\\System32\\calc.exe",
			"C:\\Windows\\System32\\Taskmgr.exe",
			"C:\\Windows\\System32\\notepad.exe"
		};
		
		ProcessBuilder pb = new ProcessBuilder(rutas[2]);
		Process p = pb.start();
		Thread newT = new Thread((Runnable) p);
		newT.start();
		
	}
}