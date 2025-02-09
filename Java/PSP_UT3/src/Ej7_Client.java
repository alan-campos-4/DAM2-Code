import java.io.DataOutputStream;
import java.io.IOException;
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
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5006);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			System.out.print("Escribe un número (1-100): ");
			String command = input.nextLine();
			DOS.writeUTF(command);
			DOS.flush();
			
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
	
}

