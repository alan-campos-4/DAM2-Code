import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


/***** EJERCICIO 8: Chat Multi-Salas *****
Objetivo:
Ampliar el concepto de chat para soportar múltiples salas o canales de conversación. 
Cada cliente elige a qué sala unirse y solo recibe los mensajes de esa sala.

1. Servidor:
	o Escucha en un puerto con ServerSocket.
	o Acepta conexiones, crea un hilo por cliente (multi-threading).
	o Mantiene una estructura de datos (por ejemplo, un Map<String, List<PrintWriter>>) 
	   donde la clave es el nombre de la sala (ej. “Matemáticas”, “Historia”, “Inglés”) 
	   y el valor es la lista de clientes (sus PrintWriter) que están en esa sala.
	o Cuando un cliente envía un mensaje, el servidor lo reenvía solo a los miembros de la misma sala.
	o El servidor podría permitir cambiar de sala con un comando especial (ej. /cambiar SalaX).
2. Cliente:
	o Tras conectarse, el servidor le solicita (o el cliente introduce por su cuenta) a qué sala unirse.
	o El cliente puede escribir mensajes que se difunden solo en la sala actual.
	o Puede haber un comando especial para cambiar de sala (por ejemplo “/cambiar Ingles”).
	o Mantener un hilo que reciba los mensajes del servidor y un bucle que envíe los del usuario.
3. Pistas Teóricas:
	o Sincronizar el acceso a la estructura compartida (el Map) si varios hilos añaden o quitan clientes
	  simultáneamente.
	o Añadir un método broadcast(String sala, String mensaje) que recorra la lista de PrintWriter 
	  de esa sala y envíe el mensaje.
	o Incluir métodos para unirse a una sala (añadir el PrintWriter a la lista) y salir de la sala anterior 
	  (removerlo).
4. Sugerencias didácticas:
	o Manejar notificaciones: “Un usuario se ha unido a la sala X”, “Un usuario ha salido de la sala X”.
	o Dividir la aplicación en más de una clase: ServidorChatMultiSalas, ManejadorCliente, etc.
	o Explorar un interfaz de consola vs. interfaz gráfica (Swing, JavaFX, etc.) para la experiencia de chat.
*/

public class Ej8_Server
{
	private static final Map<String, List<PrintWriter>> salas = new ConcurrentHashMap<>();

	public static void main(String[] args)
	{
		try (ServerSocket serverSocket = new ServerSocket(5007))
		{
			while (true)
			{
				System.out.println("Listening to port " + serverSocket.getLocalPort() + "...");
				Socket socket = serverSocket.accept();
				System.out.println("Client connected.");
				
				new Thread(new ManejadorCliente(socket)).start();
			}
		}
		catch (SocketException e)	{System.err.println("Error. Se ha perdido la conexión con el socket.");} 
		catch (IOException e)		{e.printStackTrace();}
	}
	
	// Clase para manejar la comunicación con cada cliente
	private static class ManejadorCliente implements Runnable
	{
		private Socket cliente;
		private PrintWriter out;
		private String salaActual;

		public ManejadorCliente(Socket cliente) {this.cliente = cliente;}

		@Override
		public void run()
		{
			try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter out = new PrintWriter(cliente.getOutputStream(), true))
			{
				this.out = out;

				// Pedir al cliente que elija una sala
				out.println("Bienvenido al chat multi-salas.");
				out.println("Elija una sala para unirse\n (por ejemplo: Matemáticas, Historia, Inglés):");
				salaActual = in.readLine();
				if (salaActual == null || salaActual.trim().isEmpty())
				{
					salaActual = "General";
				}

				// Unir al cliente a la sala
				unirASala(salaActual);
				broadcast(salaActual, "Un usuario se ha unido a la sala.");

				// Leer mensajes del cliente
				String mensaje;
				while ((mensaje = in.readLine()) != null)
				{
					if (mensaje.startsWith("/cambiar"))
					{
						// Cambiar de sala
						String nuevaSala = mensaje.split(" ", 2)[1].trim();
						cambiarDeSala(nuevaSala);
					}
					else
					{
						// Enviar mensaje a la sala actual
						broadcast(salaActual, mensaje);
					}
				}
				salirDeSala();
				cliente.close();
				System.out.println("Cliente desconectado.");
				
			} catch (IOException e) {e.printStackTrace();}
		}

		// Unir a un cliente a una sala
		private void unirASala(String sala)
		{
			salas.putIfAbsent(sala, new CopyOnWriteArrayList<>());
			salas.get(sala).add(out);
			salaActual = sala;
			out.println("Te has unido a la sala: " + sala);
		}

		// Cambiar de sala
		private void cambiarDeSala(String nuevaSala)
		{
			salirDeSala();
			unirASala(nuevaSala);
			out.println("Has cambiado a la sala: " + nuevaSala);
		}

		// Salir de la sala actual
		private void salirDeSala()
		{
			if (salaActual != null && salas.containsKey(salaActual))
			{
				salas.get(salaActual).remove(out);
				broadcast(salaActual, "Un usuario ha salido de la sala.");
			}
		}

		// Enviar mensaje a todos los usuarios de una sala
		private void broadcast(String sala, String mensaje)
		{
			if (salas.containsKey(sala))
			{
				for (PrintWriter cliente : salas.get(sala))
					{cliente.println("[" + sala + "] " + mensaje);}
			}
		}
	}
}
