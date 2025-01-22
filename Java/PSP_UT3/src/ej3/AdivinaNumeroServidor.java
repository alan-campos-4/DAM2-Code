package ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class AdivinaNumeroServidor
{
	static Random rand = new Random();
	
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket (p.ej. puerto 5002).
		// 2. Esperar a que un cliente se conecte (accept()).
		// 3. Generar un número aleatorio 1-100.
		// 4. Leer el intento del cliente en un bucle.
		// 5. Comparar el intento con el número secreto:
		//		- "Mayor" si intento < secreto
		//		- "Menor" si intento > secreto
		//		- "¡Acertaste!" si intento == secreto
		// 6. Cuando el cliente acierte o se acaben intentos (opcional), terminar la comunicación.
		// 7. Cerrar flujos y socket.
		
		try
		{
			Socket S3;
			ServerSocket SS3 = new ServerSocket(5002);
			System.out.println("Listening to port "+SS3.getLocalPort()+"...");
			
			S3 = SS3.accept();
			System.out.println("Client connected.");
			
			int secret = rand.nextInt(0, 99)+1;
			int intentos = 0;
			int maxIntentos = 10;
			
			BufferedReader in = new BufferedReader(new InputStreamReader(S3.getInputStream()));
			PrintWriter out = new PrintWriter(S3.getOutputStream(), true);
			
			while (intentos < maxIntentos)
			{
				try
				{
					int guessNum = Integer.parseInt(in.readLine());
					
					if (guessNum > secret)
					{
						System.out.println("Mayor");
					}
					if (guessNum < secret)
					{
						System.out.println("Menor");
					}
					else
					{
						System.out.println("¡Acertaste!");
						break;
					}
					intentos++;
				}
				catch (NumberFormatException e)	{System.out.println("Error. Tipo de número no válido.");}
			}
			
			in.close();
			out.close();
			S3.close();
			SS3.close();
		}
		catch (IOException e)	{e.printStackTrace();}
	}
}

