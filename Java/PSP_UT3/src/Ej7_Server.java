import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/***** EJERCICIO 7: Juego “Ahorcado” *****
Objetivo:
Crear una aplicación de red en Java que implemente el clásico juego del Ahorcado. 
El servidor mantiene la lógica de la palabra secreta y la gestión de intentos, 
mientras que el cliente se encarga de interactuar con el usuario.

Puntos clave
1. Lógica del juego:
	o El servidor genera o almacena una palabra secreta. Por ejemplo, puede ser “PROGRAMACION”, “INTERFAZ”,
	  “SOCKET”, etc. Se podría escoger aleatoriamente de una lista de palabras.
	o Se establecen un número de intentos máximos (por ejemplo, 6). 
	  Si el cliente agota los intentos sin adivinar la palabra, pierde.
	o Tras cada letter enviada por el cliente, el servidor responde con el estado actual de la palabra 
	  (p. ej. “P _ O G _ A M A C I O N”) o con algún indicador de fallos.
2. Servidor:
	o De nuevo, el servidor arranca un ServerSocket y espera conexiones (accept()).
	o Al entrar un cliente, se abre un Socket y se inician los flujos (InputStream, OutputStream).
	o La lógica:
		 Se envía un mensaje inicial con los intentos permitidos o la longitud de la palabra.
		 Se mantienen variables internas para saber cuántas letters acierta el cliente y 
		  cuántos intentos le quedan.
		 Cada vez que el servidor recibe una letter, actualiza el “estado” y responde, 
		  por ejemplo, con “¡Acierto!” o “¡Fallaste!” + estado parcial de la palabra.
3. Cliente:
	o Se conecta al servidor por Socket.
	o Lee y muestra la situación del juego (los guiones, los aciertos, cuántos intentos quedan).
	o Permite al usuario introducir letters (una a la vez) y las envía al servidor.
	o Cuando recibe la respuesta “¡Acertaste!” o “Se acabaron tus intentos, la palabra era: ...”, 
	  finaliza el juego.
4. Pistas Teóricas:
	o Uso de Random (si se elige la palabra al azar).
	o Bucles de lectura de línea (in.readLine()) y de escritura (out.println()).
	o Un posible estado interno: un array de caracteres (char[] progress), donde se reemplazan 
	  los guiones _ por la letter adivinada.
	o Control de mayúsculas/minúsculas para comparar correctamente.
5. Sugerencias didácticas:
	o Trabajar con control de errores en caso de que el cliente envíe más de una letter.
	o Permitir “abandonar” introduciendo un comando especial.
	o Posiblemente, un servidor con varios clientes a la vez: cada cliente juega su propia partida 
	  (manejo multi-hilo).

*/

public class Ej7_Server
{
	// 1. Crear un ServerSocket (puerto 5006, por ejemplo).
	// 2. Bucle infinito que acepte conexiones.
	// 3. Para cada cliente:
	//		a) Generar o escoger la palabra secreta.
	//		b) Enviar el número de intentos máximos.
	//		c) Leer letter por letter que el cliente envía.
	//		d) Actualizar el estado (guiones o letters descubiertas).
	// 		e) Responder con "Acierto", "Fallaste", etc., más el estado actual.
	// 		f) Si agota intentos o completa la palabra, acabar la partida o reiniciar.
	// 4. Cerrar los recursos al terminar la partida.

	private static final List<String> PALABRAS = Arrays.asList("PROGRAMACION", "INTERFAZ", "SOCKET", "JAVA");

	private static final int MAX_TRIES = 6;
	
	private static String secretWord;
	private static char[] progress;
	
	private static boolean secretWordContains(char letter)
	{
		boolean correct = false;
		for (int i = 0; i < secretWord.length(); i++)
		{
			if (secretWord.charAt(i) == letter)
			{
				progress[i] = letter;
				correct = true;
			}
		}
		return correct;
	}

	public static void main(String[] args)
	{
		try (ServerSocket serverSocket = new ServerSocket(5006))
		{
			while (true)
			{
				System.out.println("Listening to port "+serverSocket.getLocalPort()+"...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                
				try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
				{
					// Seleccionar palabra secreta
					String palabraSecreta = PALABRAS.get(new Random().nextInt(PALABRAS.size()));
		            char[] progreso = new char[palabraSecreta.length()];
		            Arrays.fill(progreso, '_');
		            int intentosRestantes = MAX_TRIES;
		            Set<Character> letrasUsadas = new HashSet<>();
		            
					// Enviar mensaje inicial
					out.println("¡Bienvenido al Ahorcado!");
					out.println("Adivina la palabra: " + String.valueOf(progreso));
					out.println("Intentos restantes: " + intentosRestantes);
					
					while (intentosRestantes > 0)
					{
						// Leer letra del cliente
						String entrada = in.readLine();
						if (entrada == null || entrada.length() != 1)
						{
							out.println("Por favor, envía una sola letra.");
							out.println("Progreso actual: " + String.valueOf(progreso));
							continue;
						}
						
						char letra = entrada.toUpperCase().charAt(0);
						
						if (letrasUsadas.contains(letra))
						{
							out.println("Ya usaste la letra '" + letra + "'. Intenta con otra.");
							out.println("Progreso actual: " + String.valueOf(progreso));
							continue;
						}
						
						letrasUsadas.add(letra);
						
						if (secretWordContains(letra))
						{
							out.println("¡Acierto!");
						}
						else
						{
							intentosRestantes--;
							out.println("¡Fallaste! Intentos restantes: " + intentosRestantes);
						}
						
						// Verificar si el jugador ha ganado o perdido
						if (String.valueOf(progreso).equals(palabraSecreta))
						{
							out.println("¡Felicidades, has adivinado la palabra: " + palabraSecreta + "!");
							break;
						}
						
						if (intentosRestantes == 0)
						{
							out.println("¡Se acabaron los intentos! La palabra era: " + palabraSecreta);
							break;
						}
						
						// Enviar progreso actual al cliente
						out.println("Progreso actual: " + String.valueOf(progreso));
					}
				}
			}
		}
		catch (SocketException e)	{System.err.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)		{e.printStackTrace();}
	}

//		catch (NumberFormatException e)	{System.out.println("Error. Tipo de valor incorrecto.");}
//		catch (SocketException e)		{System.out.println("Error. Se ha perdido la conexión con el socket.");}
//		catch (IOException e)			{e.printStackTrace();}
		

	
}

