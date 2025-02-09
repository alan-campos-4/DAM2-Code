import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/***** EJERCICIO 4: Chat Simple de Una Sola Sala *****
Objetivo:
Crear un chat en el que varios clientes puedan conectarse a un servidor y comunicarse en una única sala. 
Cuando un cliente envía un mensaje, el servidor lo retransmite a todos los clientes conectados.

	1. Servidor de Chat:
		o Utiliza un ServerSocket para escuchar en un puerto determinado (p. ej., 5003).
		o Al recibir una conexión (vía accept()), crea un hilo (o Thread) para atender a ese cliente.
		  De esta forma, el servidor podrá gestionar múltiples clientes concurrentemente.
		o Se necesita una lista compartida (o estructura de datos similar) para almacenar los flujos
		  de salida (PrintWriter) de cada cliente.
		o Cuando un cliente envía un mensaje, el servidor lo leerá y lo transmitirá a todos los
		  clientes utilizando esa lista. Este proceso se conoce como difusión (broadcast).
		o Es esencial sincronizar los accesos a la lista compartida (por ejemplo, utilizando
		  synchronized o estructuras seguras para hilos como CopyOnWriteArrayList) para evitar
		  problemas de concurrencia.
	2. Cliente de Chat:
		o Se conecta mediante un Socket al mismo puerto del servidor (p. ej., new Socket("localhost", 5003)).
		o Tiene dos responsabilidades principales:
			1. Enviar mensajes al servidor: leer desde la consola local y enviar 
			   (usando OutputStream o un PrintWriter).
			2. Recibir mensajes del servidor: el servidor reenvía los mensajes de todos los
			   usuarios, por lo que el cliente debe escuchar y mostrar en pantalla esos mensajes.
		o Para lograr la recepción de mensajes en tiempo real, conviene usar un hilo adicional que lea
		  de manera continua del InputStream asociado al socket y muestre por consola lo que reciba.
	3. Consideraciones:
		o El servidor puede anunciar que un nuevo cliente se ha conectado o que un cliente se ha
		  desconectado, para mejorar la experiencia de chat.
		o Si un cliente envía “/salir” (o cualquier comando para salir), se podría cerrar el socket de
		  ese cliente y remover su PrintWriter de la lista.
		o Manejo de excepciones (IOException) al momento de leer/escribir.
		o Cerrar los recursos (socket, flujos) de forma ordenada.
	4. Pistas Teóricas:
		o ServerSocket serverSocket = new ServerSocket(5003);
		o Socket clientSocket = serverSocket.accept(); // Bloquea hasta que un cliente se conecte.
		o Para gestionar hilos: Thread t = new Thread(new Runnable() { ... });
		o Uso de una colección global (por ejemplo static List<PrintWriter> listaClientes
		  = ...;) que almacena los flujos de salida a cada cliente.
		o Acciones de difusión:
				synchronized(listaClientes) {
					for (PrintWriter pw : listaClientes) {
						pw.println(mensaje);
					}
				}
 */

public class Ej4_Server
{
	// Estructura para almacenar PrintWriters de clientes, por ejemplo:
	private static List<PrintWriter> listaClientes;
	
	
	// Método (opcional) para enviar un mensaje a todos los clientes (broadcast).
	private static void broadcast(String mensaje)
	{
		//
	}
	
	public static Socket S4;
	
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket en un puerto, p.ej. 5003.
		// 2. Bucle infinito aceptando conexiones (accept()).
		// 3. Por cada conexión, crear un Thread para manejar la comunicación con ese  cliente.
		//		- En el Runnable, leer en un bucle los mensajes del cliente.
		//		- Hacer broadcast a los demás.
		// 4. Manejar cierre de conexiones y remover el PrintWriter del cliente de la lista.
		
		try (ServerSocket SS4 = new ServerSocket(5003))
		{
			while (true)
			{
				System.out.println("Listening to port "+SS4.getLocalPort()+"...");
				S4 = SS4.accept();
				System.out.println("Client connected.");
				
				//in = new BufferedReader(new InputStreamReader(S4.getInputStream()));
				//out = new PrintWriter(S4.getOutputStream(), true);
				
				broadcast("...");
				
				Thread t = new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						String line;
						try 
						{
							BufferedReader in = new BufferedReader(new InputStreamReader(S4.getInputStream()));
							line = in.readLine().replaceAll("","").replaceAll("\\s+","").trim();
							System.out.println(line);
							
							System.out.println("Esperando...");
						}
						catch (IOException e) {e.printStackTrace();} 
						//catch (InterruptedException e) {e.printStackTrace();}
					}
				});
				t.start();
			}
			
			//in.close();
			//out.close();
			//S4.close();
		}
		catch (NumberFormatException e)	{System.out.println("Error. Tipo de valor incorrecto.");}
		catch (SocketException e)		{System.out.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)			{e.printStackTrace();}
	}
}

