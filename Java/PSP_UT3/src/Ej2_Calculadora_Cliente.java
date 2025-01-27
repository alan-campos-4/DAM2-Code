import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej2_Calculadora_Cliente
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con Socket (localhost, 5001).
		// 2. Leer (por consola) la operación a realizar, p.ej. "SUMA 4 5".
		// 3. Enviarla al servidor.
		// 4. Leer la respuesta (resultado) y mostrarlo.
		// 5. Cerrar los recursos.
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5001);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			System.out.print("Escribe el comando: ");
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

