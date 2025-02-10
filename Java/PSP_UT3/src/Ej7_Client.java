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
		
		//Todos los recursos dentro del paréntesis se cerrarán al final.
		try (//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5006);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));)
		{
			String userInput = " ", serverReply, attempts;
			
			//Si la línea que se escribe por consola no esá vacía,
			while (userInput != null)
			{
				System.out.print("Escribe un número (1-100): "); //Muestra el mensaje dentro del cliente.
				
				userInput = input.nextLine();		//Lee el número por consola.
				out.println(userInput);				//Envía el mensaje al servidor.
				
				serverReply = in.readLine();		//Recibe la respuesta del servidor y la muestra.
				System.out.println(serverReply);	
				
				//Termina el bucle si el resultado lo indica.
				if (serverReply.equals("¡Acertaste!") || serverReply.equals("Se han acabado los intentos."))
					{break;}
				
				//Si recibe los intentos restantes, los muestra.
				if ((attempts = in.readLine()) != null)
					{System.out.println(attempts); }
			}
		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
	
}

