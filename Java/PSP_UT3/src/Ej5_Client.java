import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej5_Client
{
	public static void main(String[] args)
	{
		// 1. Conectarse al servidor con un Socket (localhost, 5004).
		// 2. Leer el menú que envía el servidor (varias líneas).
		// 3. Introducir la opción por consola y enviarla al servidor.
		// 4. Recibir y mostrar los titulares.
		// 5. Cerrar la conexión o preguntar si se quiere más noticias.
		
		
		try(//Socket con el que se trabaja.
			Socket so = new Socket("127.0.0.1", 5004);
			//El stream de salida del socket, para enviar al servidor.
			PrintWriter out = new PrintWriter(so.getOutputStream(), true);
			//El stream de entrada del socket, para recibir del servidor.
			BufferedReader in = new BufferedReader(new InputStreamReader(so.getInputStream()));
			//Lector por consola dentro del cliente.
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
		{
            while (true)
            {
                //Recibe todas las categorías del servidor.
            	//Se utiliza el método isEmpty() porque si comprobamos si es nulo no el programa funciona.
                String linea;
                while (!(linea = in.readLine()).isEmpty())
                {
                    System.out.println(linea);
                }
                
                // Leer la opción del usuario desde la consola
                System.out.print("Elige una opción: ");
                String opcion = input.readLine();
                out.println(opcion);
                
                //Si el usuario selecciona "4", salimos del bucle
                if (opcion.equals("4"))	{break;}

                //Muestra las noticias enviadas por el servidor.
                while (!(linea = in.readLine()).isEmpty())
                {
                    System.out.println(linea);
                }
            }
		}
		catch (ConnectException e)		{System.err.println("Connection refused.");}
		catch (UnknownHostException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
	}
	
}

