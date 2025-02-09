import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/***** EJERCICIO 1: Servidor Echo "Saludo Exprés" *****
 PUNTOS CLAVE
	1. Componente Servidor:
		o Deberá utilizar la clase ServerSocket (de la librería java.net) para abrir un puerto y 
		  “ponerse a la escucha” (listen).
		o Cuando llega un cliente, se invoca el método accept(), que devuelve un objeto Socket.
		o Flujos de entrada y salida (InputStream y OutputStream) se obtienen directamente desde 
		  el objeto Socket. Esto permite la comunicación con el cliente.
		o Posteriormente, se pueden manipular estos flujos con InputStreamReader, BufferedReader, 
		PrintWriter o similar, para facilitar el trabajo con cadenas de texto.
	2. Componente Cliente:
		o Se conectará al servidor empleando la clase Socket de java.net, con la IP del servidor 
		  (por ejemplo, 127.0.0.1 si es local) y el puerto en que el servidor está escuchando.
		o Tras establecerse la conexión (creación del Socket), se podrá escribir y leer a través de los 
		  flujos de E/S con los métodos getOutputStream() y getInputStream().
	3. Intercambio de Mensajes:
		o El cliente enviará una cadena (p. ej. “Hola servidor”).
		o El servidor recibirá esa cadena, le añadirá “Hola, recibí tu mensaje: ” y la devolverá.
		o El cliente mostrará en pantalla la respuesta devuelta por el servidor.
	4. Consideraciones:
		o Cerrar adecuadamente los sockets y los flujos.
		o Manejar excepciones de tipo IOException, que son comunes en operaciones de red.
		o Utilizar un bucle en el servidor para permitir que escuche conexiones sucesivas 
		  (o continuar indefinidamente).
 PISTAS TEÓRICAS
		o ServerSocket serverSocket = new ServerSocket(5000); // Abre el puerto 5000 para escuchar.
		o Socket clientSocket = serverSocket.accept(); // Acepta una conexión y devuelve el socket del cliente.
		o Para manejar cadenas de texto, se puede emplear:
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		  Donde true en el PrintWriter habilita el auto-flush.
*/

public class Ej1_Server
{
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket en un puerto (p.ej. 5000).
		// 2. Bucle infinito que llama a accept() para recibir conexiones.
		// 3. Abrir flujos de E/S para leer del cliente y enviar respuesta.
		// 4. Imprimir mensaje en consola para ver qué llega.
		// 5. Enviar la respuesta con “Hola, recibí tu mensaje: <mensaje>”.
		// 6. Cerrar recursos.
		
		try (ServerSocket SS1 = new ServerSocket(5000);)
		{
			Socket S1;
			System.out.println("Listening to port "+SS1.getLocalPort()+"...");
			
			S1 = SS1.accept();
			System.out.println("Client connected.");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(S1.getInputStream()));
			PrintWriter out = new PrintWriter(S1.getOutputStream(), true);
			
			String message = in.readLine().replaceAll("","").replaceAll("\\s+","").trim();
			System.out.println("Client Message: "+message);
			
			out.println("Server Reply: Hola, recibí tu mensaje.");
			
			/*
			String line;
			while ((line=in.readLine())!=null)
				System.out.println("Client Message: "+line);
			out.println("Server Reply: Hola, recibí tu mensaje.");
			*/
			
			in.close();
			out.close();
			S1.close();
		}
		catch (SocketException e)		{System.out.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)			{e.printStackTrace();}
	}
}

