import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

/***** EJERCICIO 3: Juego de “Adivina el Número” *****
 PUNTOS CLAVE
	1. Servidor:
		o Crea un número aleatorio (por ejemplo, usando java.util.Random).
		o Espera conexiones de un cliente.
		o Cuando llega un intento (un número que manda el cliente), compara con el número secreto:
			 Si el intento es menor, responde “Mayor”.
			 Si el intento es mayor, responde “Menor”.
			 Si acierta, responde “¡Acertaste!” y podría finalizar la partida o reiniciarla.
		o A continuación, el servidor podría (opcionalmente) permitir un nuevo juego o cerrar la conexión.
	2. Cliente:
		o Se conecta, muestra un mensaje de bienvenida o instrucciones al usuario (por consola).
		o Solicita al usuario un número.
		o Envía ese número al servidor y lee la respuesta.
		o Continúa hasta que el servidor responda “¡Acertaste!” o hasta que decida dejar de jugar.
	3. Bucles de Comunicación:
		o Tanto servidor como cliente se mantendrán en un bucle leyendo y escribiendo 
		  (request-response) hasta que se alcance la condición de fin del juego.
		o Cerrar adecuadamente los recursos al terminar.
	4. Manejo de Errores:
		o El cliente podría enviar algo que no sea un número.
		  Se podría controlar con Integer.parseInt(...) rodeado de un try/catch.
		o El servidor o el cliente pueden desconectarse abruptamente, generando IOException.
		  Manejar esas excepciones con cuidado.
	5. Puntos Didácticos:
		o Uso de un while para controlar la persistencia de la partida.
		o Separación de lógica: el servidor contiene la “lógica del juego” (comparaciones) 
		  y el cliente la “interfaz de usuario” (pedir datos por consola y mostrar respuestas).
		o Introducir la idea de “código bloqueante”: accept(), readLine(), etc. pueden bloquear la ejecución 
		  si no hay conexiones o si no llega más texto.
 PISTAS TEÓRICAS
		 Random rand = new Random();
			int numeroSecreto = rand.nextInt(100) + 1; // Genera entero entre 1 y 100.
		 Lectura de cadenas: String entrada = in.readLine();
		 Conversión a número: int intento = Integer.parseInt(entrada);
		 Comparación y respuesta: out.println("Mayor"); o out.println("¡Acertaste!");
*/

public class Ej3_Server
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
		// 6. Cuando el cliente acierte o se acaben attempts (opcional), terminar la comunicación.
		// 7. Cerrar flujos y socket.
		
		//Crea el ServerSocket.
		try (ServerSocket SSo = new ServerSocket(5002))
		{
			Socket So;
			final int maxAttempts = 10;
			int attempts, secret;
			
			while (true)
			{
				//Recibe conexiones en el puerto.
				System.out.println("Listening to port "+SSo.getLocalPort()+"...");
				So = SSo.accept();
				System.out.println("Client connected.");
				//Genera el número aleatorio y resetea los intentos si recibe otro cliente.
				secret = rand.nextInt(0, 99)+1;
				attempts = 0;
				
				try (//El stream de entrada del socket, para recibir del cliente.
					BufferedReader in = new BufferedReader(new InputStreamReader(So.getInputStream()));
					//El stream de salida del socket, para enviar al cliente.
					PrintWriter out = new PrintWriter(So.getOutputStream(), true);)
				{
					//Mientras no la línea recibida del cliente no sea nula,
					String line;
					while ((line = in.readLine()) != null)
					{
						//Obtiene el número y lo compara.
						int guess = Integer.parseInt(line);
						
						if (guess < secret)
							{out.println("Mayor.");}
						else if (guess > secret)
							{out.println("Menor.");}
						else
						{
							out.println("¡Acertaste!");
							break;
						}
						attempts++;
						
						//Muestra si le quedan intentos o si se han acabado.
						if (maxAttempts-attempts<=1)
						{
							out.println("Se han acabado los intentos.");
							break;
						}
						else {out.println("Te quedan "+(maxAttempts-attempts)+" intentos.");}
                    }
				}
				//Lanzada si el mensaje recibido del cliente no es un entero.
				catch (NumberFormatException e)	{System.err.println("Error. Tipo de valor incorrecto.");}
				So.close();
			}
		}
		catch (SocketException e)	{System.err.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)		{e.printStackTrace();}
		
	}
}

