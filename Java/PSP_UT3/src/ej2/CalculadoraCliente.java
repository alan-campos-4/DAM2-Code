package ej2;

import info.General;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CalculadoraCliente
{
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con Socket (localhost, 5001).
		// 2. Leer (por consola) la operación a realizar, p.ej. "SUMA 4 5".
		// 3. Enviarla al servidor.
		// 4. Leer la respuesta (resultado) y mostrarlo.
		// 5. Cerrar los recursos.
		
		try
		{
			Socket So = new Socket(General.Host, General.PortCalculadora);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			System.out.print("Escribe el comando: ");
			String command = General.input.nextLine();
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

