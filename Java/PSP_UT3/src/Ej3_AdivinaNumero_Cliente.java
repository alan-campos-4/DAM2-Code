import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ej3_AdivinaNumero_Cliente
{
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor (puerto 5002, localhost).
		// 2. Leer mensaje de bienvenida o instrucciones del servidor (opcional).
		// 3. En un bucle:
		// 		a) Pedir al usuario un número.
		// 		b) Enviarlo al servidor.
		// 		c) Leer la respuesta ("Mayor", "Menor", "¡Acertaste!").
		// 		d) Mostrar en pantalla.
		// e) Si es "¡Acertaste!", salir del bucle.
		// 4. Cerrar recursos.
		
		try
		{
			Socket So = new Socket("127.0.0.1", 5002);
			
			DataOutputStream DOS = new DataOutputStream(So.getOutputStream());
			
			System.out.println("Escribe un número (1-100):");
			String command = input.nextLine();
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

