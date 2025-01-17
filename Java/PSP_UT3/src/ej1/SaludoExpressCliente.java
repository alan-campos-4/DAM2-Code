package ej1;

import info.General;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SaludoExpressCliente
{
	public static String ClientMessage = "Hola servidor.";
	
	public static void main(String[] args)
	{
		// 1. Crear Socket apuntando a localhost y al puerto del servidor (p.ej. 5000).
		// 2. Obtener flujos de E/S para enviar un mensaje de prueba.
		// 3. Leer la respuesta del servidor.
		// 4. Imprimir por consola la respuesta.
		// 5. Cerrar recursos.
		
		try
		{
			Socket So = new Socket(General.Host, General.PortSaludo);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			DOS.writeUTF(ClientMessage);
			DOS.flush();
			
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

