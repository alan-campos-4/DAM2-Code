package ej1;

import info.General;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SaludoExpressServidor
{
	public static String ServerMessage = "Hola, recibí tu mensaje.";
	
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket en un puerto (p.ej. 5000).
		// 2. Bucle infinito que llama a accept() para recibir conexiones.
		// 3. Abrir flujos de E/S para leer del cliente y enviar respuesta.
		// 4. Imprimir mensaje en consola para ver qué llega.
		// 5. Enviar la respuesta con “Hola, recibí tu mensaje: <mensaje>”.
		// 6. Cerrar recursos.
		
		try
		{
			Socket S1;
			ServerSocket SS1 = new ServerSocket(General.PortSaludo);
			General.listening(SS1.getLocalPort());
			
			S1 = SS1.accept();
			General.connected();
			BufferedReader in = new BufferedReader(new InputStreamReader(S1.getInputStream()));
			PrintWriter out = new PrintWriter(S1.getOutputStream(), true);
			
			String line;
			while ((line=in.readLine())!=null)
				System.out.println("Client Message: "+line);
			System.out.println("Server Reply: "+ServerMessage);
			
			in.close();
			out.close();
			S1.close();
			SS1.close();
		}
		catch (IOException e)	{e.printStackTrace();}
	}
}

