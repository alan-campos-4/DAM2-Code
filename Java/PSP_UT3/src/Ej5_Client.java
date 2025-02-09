import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej5_Client
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con un Socket (localhost, 5004).
		// 2. Leer el menú que envía el servidor (varias líneas).
		// 3. Introducir la opción por consola y enviarla al servidor.
		// 4. Recibir y mostrar los titulares.
		// 5. Cerrar la conexión o preguntar si se quiere más noticias.
		
		
		//Todos los recursos dentro del paréntesis se cerrarán al final.
		try (//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5004);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));) 
		{
			String line, userInput = " ";
			
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			
			do
			{
				System.out.println(" -> ");
				userInput = input.nextLine();
				
			    out.println(userInput);					//Envía la elección al servidor.
			    
			    while ((line = in.readLine()) != null)	//Muestra todos los titulares.
					{System.out.println(line);}
			}
		    while (userInput!=null);
		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
		
	}
}

