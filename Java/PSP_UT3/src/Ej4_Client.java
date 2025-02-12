import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej4_Client
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		try (//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5003);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
			//Lector de consola.
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
		{
            //Hilo que recibe todos los mensajes del servidor y los muestra aquí.
            Thread hiloEscucha = new Thread(() -> {
                try
                {
                    String message;
                    while ((message = in.readLine()) != null)
                    {
                        System.out.println(message);
                    }
                }
                catch (IOException e)	{e.printStackTrace();}
            });
            hiloEscucha.start();

            //Envia los mensajes escritos en consola al servidor.
            String userInput;
            while ((userInput = input.readLine()) != null)
            {
                out.println(userInput);
            }
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
}

