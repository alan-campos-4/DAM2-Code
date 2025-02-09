import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5005);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			System.out.print("Introduzca el nombre de un archivo de imagen: ");
			String inputline = input.nextLine();
			DOS.writeUTF(inputline);
			//DOS.flush();
			
			InputStream in = So.getInputStream();
			FileOutputStream fos = new FileOutputStream("descargado_" + inputline);
			DOS.flush();
			
			fos.close();
			in.close();
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

