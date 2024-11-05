package ej4W;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//		try
//		{
//			StringBuilder sb = new StringBuilder();
//			ProcessBuilder pb = new ProcessBuilder().command("tasklist /fi \"STATUS eq running\"");
//			Process p = pb.start();
//			
//			
//			sb.append(p);
//			System.out.println(sb);
//		}
//		catch (IOException e)	{e.printStackTrace();}
		
//		ProcessBuilder builder = new ProcessBuilder();
//		builder.command("cmd.exe", "/c", "dir");
//		
//		builder.directory(new File(System.getProperty("user.home")));
//		Process process;
//		try
//		{
//			process = builder.start();
//			int exitCode = process.waitFor();
//		}
//		catch (IOException e)			{e.printStackTrace();} 
//		catch (InterruptedException e)	{e.printStackTrace();}
		
		
		
		
//		try
//		{
//			//String command = "powershell.exe  your command";
//			//Getting the version
//			//String command = "powershell.exe $PSVersionTable.PSVersion";
//			String command = "powershell.exe tasklist /fi \"STATUS running\"";
//			
//			String[] commandList = {"powershell.exe", "-Command", "tasklist /FI STATUS eq RUNNING"};  
//
//	        ProcessBuilder pb = new ProcessBuilder(commandList);  
//
//	        Process p = pb.start();
//			
//			
//			// Executing the command
//			//Process powerShellProcess = Runtime.getRuntime().exec(command);
//			// Getting the results
//			p.getOutputStream().close();
//			String line;
//			System.out.println("Standard Output:");
//			BufferedReader stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while ((line = stdout.readLine()) != null)
//			{
//				System.out.println(line);
//			}
//			stdout.close();
//			System.out.println("Standard Error:");
//			BufferedReader stderr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//			while ((line = stderr.readLine()) != null)
//			{
//				System.out.println(line);
//			}
//			stderr.close();
//			System.out.println("Done");
//		}
//		catch (IOException e)	{e.printStackTrace();}
		
		
		
		//String command = "powershell.exe -Command tasklist /fi \"STATUS eq running\"";
		String[] command = {"powershell.exe", "-Command", "tasklist"}; // Sample PowerShell command
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
            System.out.println("Output: \n" + output.toString());
        }
        catch (IOException | InterruptedException e)	{e.printStackTrace();}
		
		
		
	}
}
