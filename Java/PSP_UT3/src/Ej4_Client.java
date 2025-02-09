import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej4_Client
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con un Socket (localhost, 5003).
		// 2. Preparar un hilo que reciba mensajes del servidor y los imprima en consola.
		// 3. En un bucle, leer mensajes de la consola local y enviarlos al servidor.
		// 4. Manejar cierre de la conexión al escribir un comando de salida.
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5003);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			while (true)
			{
				System.out.print("Escribe un mensaje: ");
				String message = input.nextLine();
				DOS.writeUTF(message);
				DOS.flush();
				
				if (message.equals("Salir")) break;
			}
			
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

