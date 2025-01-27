import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej4_ChatSimple_Cliente
{
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
			
			System.out.print("Escribe un número (1-100): ");
			//String command = input.nextLine();
			//DOS.writeUTF(command);
			DOS.flush();
			
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

