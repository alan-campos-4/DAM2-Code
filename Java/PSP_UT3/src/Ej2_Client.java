import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej2_Client
{
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con Socket (localhost, 5001).
		// 2. Leer (por consola) la operación a realizar, p.ej. "SUMA 4 5".
		// 3. Enviarla al servidor.
		// 4. Leer la respuesta (resultado) y mostrarlo.
		// 5. Cerrar los recursos.
		
		//Todos los recursos dentro del paréntesis se cerrarán al final.
        try (//Socket con el que se trabaja.
    		Socket so = new Socket("127.0.0.1", 5001);
        	//El stream de salida del socket, para enviar al servidor.
            PrintWriter out = new PrintWriter(so.getOutputStream(), true);
        	//El stream de entrada del socket, para recibir del servidor.
            BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
        	//Lector de consola.
        	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));)
        {
        	System.out.print("Escribe el comando: ");	//Muestra el mensaje dentro del cliente.
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
        
		/*
		try
		{
			Socket So = new Socket("127.0.0.1", 5001);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			DataInputStream DIS = new DataInputStream(So.getInputStream());
			
			System.out.print("Escribe el comando: ");
			String command = input.nextLine();
			
			DOS.writeUTF(command);
			DOS.flush();
			
			DIS.readLine();
			
			DOS.close();
			So.close();
		}
		catch (ConnectException e)		{System.out.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
		*/
	}
}

