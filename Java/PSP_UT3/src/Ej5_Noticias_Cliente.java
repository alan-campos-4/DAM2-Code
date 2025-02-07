import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej5_Noticias_Cliente
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con un Socket (localhost, 5004).
		// 2. Leer el menú que envía el servidor (varias líneas).
		// 3. Introducir la opción por consola y enviarla al servidor.
		// 4. Recibir y mostrar los titulares.
		// 5. Cerrar la conexión o preguntar si se quiere más noticias.
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5004);
			
			DataInputStream DIS = new DataInputStream(So.getInputStream());
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			DIS.read();
			System.out.print("Elige una opción: ");
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

