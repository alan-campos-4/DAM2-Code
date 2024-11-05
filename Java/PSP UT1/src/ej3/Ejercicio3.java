package ej3;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;


public class Ejercicio3
{
	/*
	 * Error en el programa:
	 * El proceso de la aplicación de calculadora "calc.exe" se considera terminado por este programa antes de que se cierre
	 * porque el proceso que se lanza no es el mismo que la aplicación
	 */
    public static void main(String[] args)
    {
    	ArrayList<String> commands = new ArrayList<String>();
    	commands.add("mspaint");
    	commands.add("Taskmgr");
    	commands.add("\"C:\\Windows\\System32\\calc.exe\"");
    	for (String command : commands)
    	{
    		try
    		{
    			//Iniciar el proceso.
    			Instant start = Instant.now();
    			
    			//Empieza el proceso.
    			Process process = new ProcessBuilder(command).start();
    			ProcessHandle processHandle = process.toHandle();
    			long pid = processHandle.pid();
    			
    			
    			System.out.println("\n\n----- " + command + " (" + pid + ") -----");
    			System.out.println("Proceso iniciado.");
    			
    			
    			//Esperar a que el proceso termine
                int exitCode = process.waitFor();
                
                //Termina el proceso y cuenta el tiempo pasado.
                Instant end = Instant.now();
                Duration timeElapsed = Duration.between(start, end);
                
                System.out.println("Proceso finalizado con código de salida: " + exitCode);
                System.out.println("Tiempo transcurrido: " + timeElapsed.toMillis() + " ms");
                
                //Verificar si se puede destruir el proceso 
                Optional<ProcessHandle> handle = ProcessHandle.of(pid);
                if (handle.isPresent() && handle.get().isAlive())
                {
                	System.out.println("Intentando destruir el proceso con PID: " + pid);
                	handle.get().destroy();
                }
                else {process.waitFor();}//{System.out.println("El proceso " + pid + " ya ha finalizado.");}
            }
    		catch (IOException | InterruptedException e) {e.printStackTrace();}
        }
    }
}