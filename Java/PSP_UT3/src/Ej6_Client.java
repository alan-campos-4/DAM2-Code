import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej6_Client
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con Socket (localhost, 5005).
		// 2. Pedir al usuario el nombre del archivo y enviarlo.
		// 3. Recibir el contenido binario del archivo.
		// 4. Guardarlo en un FileOutputStream local.
		// 5. Cerrar flujos y socket.
		
		// Todos los recursos dentro del paréntesis se cerrarán al final.
		try(//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5005);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));)
		{
			String userInput;
			
			System.out.print("Introduzca un archivo de imagen: ");
			if ((userInput = input.nextLine())!=null)
			{
				out.println(userInput);
			}
			
		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

