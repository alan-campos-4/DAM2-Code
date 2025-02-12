import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
		
		
		try (//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5005);
			//El stream de salida del socket, para enviar al servidor.
			OutputStream out = so.getOutputStream();
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
			//Lector de consola.
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.print("Introduzca el nombre del archivo: ");

			//Lee el nombre del archivo y lo envía al servidor.
			String filepath = input.readLine();
			out.write((filepath + "\n").getBytes());
			
			//Recibe la respuesta del servidor.
			String serverReply = in.readLine();
			
			//Leer el tamaño del archivo.
			long filesize = Long.parseLong(serverReply);
			
			//Descarga el archivo, usando el stream de salida al archivo nuevo.
			try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("descargado_"+filepath)))
			{
				byte[] buffer = new byte[4096];
				int bytesLeidos;
				int bytesTotalesLeidos = 0;
				
				//Escribe los bytes leidos al BOS mientras no llegue al final.
				while ((bytesTotalesLeidos<filesize) && (bytesLeidos=so.getInputStream().read(buffer)) != -1)
				{
					bos.write(buffer, 0, bytesLeidos);
					bytesTotalesLeidos += bytesLeidos;
				}
				System.out.println("Archivo descargado como: descargado_" + filepath);
			}

		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

