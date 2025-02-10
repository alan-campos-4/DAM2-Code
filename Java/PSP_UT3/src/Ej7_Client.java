import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej7_Client
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con un Socket (localhost, 5006).
		// 2. Esperar y mostrar mensajes de bienvenida (intentos disponibles).
		// 3. En bucle, solicitar al usuario una letra.
		// 4. Enviar la letra al servidor, leer respuesta:
		//		- "Acierto", "Fallaste", mostrar guiones
		//		- "¡Acertaste!" o "Se acabaron los intentos" -> terminar juego
		// 5. Cerrar recursos.
		
		
		try (//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5006);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
		{
			// Leer mensaje de bienvenida y estado inicial del juego
            String linea;
            while ((linea = in.readLine()) != null)
            {
                System.out.println(linea);
                
                // Si el juego termina, salir del bucle
                if (linea.startsWith("¡Felicidades") || linea.startsWith("¡Se acabaron"))
                {
                    break;
                }
                
                // Si el servidor solicita una letra, pedirla al usuario
                //if (linea.startsWith("Progreso actual:") || linea.startsWith("Adivina la palabra"))
                {
                    System.out.print("Introduce una letra: ");
                    String letra = input.readLine();
                    out.println(letra);
                }
            }
		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
	
}

