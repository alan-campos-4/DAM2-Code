import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej1_Client
{
	public static void main(String[] args)
	{
		// 1. Crear Socket apuntando a localhost y al puerto del servidor (p.ej. 5000).
		// 2. Obtener flujos de E/S para enviar un mensaje de prueba.
		// 3. Leer la respuesta del servidor.
		// 4. Imprimir por consola la respuesta.
		// 5. Cerrar recursos.
		
		//Todos los recursos dentro del paréntesis se cerrarán al final.
        try (//Socket con el que se trabaja.
    		Socket so = new Socket("127.0.0.1", 5000);
        	//El stream de salida del socket, para enviar al servidor.
            PrintWriter out = new PrintWriter(so.getOutputStream(), true);
        	//El stream de entrada del socket, para recibir del servidor.
            BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
        	//Lector de consola.
        	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)))
        {
        	System.out.print("Escribe tu mensaje: ");	//Muestra el mensaje dentro del cliente.
    		String userInput;
    		
    		if ((userInput = stdIn.readLine()) != null)	//Si la línea que se escribe por consola no esá vacía,
    		{
    		    out.println(userInput);				//Envía el mensaje al servidor.
    		    System.out.println(in.readLine());	//Recibe la respuesta del servidor.
    		}
        }
        catch (ConnectException e)		{System.err.println("Connection refused.");}
        catch (UnknownHostException e)	{e.printStackTrace();}
        catch (IOException e)			{e.printStackTrace();}
		
	}
}

