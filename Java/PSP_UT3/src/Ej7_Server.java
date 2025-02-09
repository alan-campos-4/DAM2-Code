import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.Scanner;

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
	o Tras cada letra enviada por el cliente, el servidor responde con el estado actual de la palabra 
	  (p. ej. “P _ O G _ A M A C I O N”) o con algún indicador de fallos.
2. Servidor:
	o De nuevo, el servidor arranca un ServerSocket y espera conexiones (accept()).
	o Al entrar un cliente, se abre un Socket y se inician los flujos (InputStream, OutputStream).
	o La lógica:
		 Se envía un mensaje inicial con los intentos permitidos o la longitud de la palabra.
		 Se mantienen variables internas para saber cuántas letras acierta el cliente y 
		  cuántos intentos le quedan.
		 Cada vez que el servidor recibe una letra, actualiza el “estado” y responde, 
		  por ejemplo, con “¡Acierto!” o “¡Fallaste!” + estado parcial de la palabra.
3. Cliente:
	o Se conecta al servidor por Socket.
	o Lee y muestra la situación del juego (los guiones, los aciertos, cuántos intentos quedan).
	o Permite al usuario introducir letras (una a la vez) y las envía al servidor.
	o Cuando recibe la respuesta “¡Acertaste!” o “Se acabaron tus intentos, la palabra era: ...”, 
	  finaliza el juego.
4. Pistas Teóricas:
	o Uso de Random (si se elige la palabra al azar).
	o Bucles de lectura de línea (in.readLine()) y de escritura (out.println()).
	o Un posible estado interno: un array de caracteres (char[] progreso), donde se reemplazan 
	  los guiones _ por la letra adivinada.
	o Control de mayúsculas/minúsculas para comparar correctamente.
5. Sugerencias didácticas:
	o Trabajar con control de errores en caso de que el cliente envíe más de una letra.
	o Permitir “abandonar” introduciendo un comando especial.
	o Posiblemente, un servidor con varios clientes a la vez: cada cliente juega su propia partida 
	  (manejo multi-hilo).

*/

public class Ej7_Server
{
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	
	public static String generateWord()
	{
		String[] possible = {"PROGRAMACION", "INTERFAZ", "SOCKET"};
		return possible[rand.nextInt(0, possible.length)];
	}
	
	public static void main(String[] args)
	{
		// 1. Crear un ServerSocket (puerto 5006, por ejemplo).
		// 2. Bucle infinito que acepte conexiones.
		// 3. Para cada cliente:
		//		a) Generar o escoger la palabra secreta.
		//		b) Enviar el número de intentos máximos.
		//		c) Leer letra por letra que el cliente envía.
		//		d) Actualizar el estado (guiones o letras descubiertas).
		// 		e) Responder con "Acierto", "Fallaste", etc., más el estado actual.
		// 		f) Si agota intentos o completa la palabra, acabar la partida o reiniciar.
		// 4. Cerrar los recursos al terminar la partida.
		
		try (ServerSocket SS7 = new ServerSocket(5006))
		{
			Socket S7;
			BufferedReader in;
			PrintWriter out;
			System.out.println("Listening to port "+SS7.getLocalPort()+"...");
			int intentos = 0;
			int maxIntentos = 10;
			
			while (true)
			{
				S7 = SS7.accept();
				System.out.println("Client connected.");
				
				in = new BufferedReader(new InputStreamReader(S7.getInputStream()));
				out = new PrintWriter(S7.getOutputStream(), true);
				
				String secretWord = generateWord();
				out.println("You have "+(maxIntentos-intentos)+" attempts left.");
				
				char playerGuess = in.readLine().replaceAll("","").replaceAll("\\s+","").trim().charAt(0);
				
				intentos++;
				
				if (intentos>=maxIntentos)
				{
					System.out.println("Se han acabado los intentos.");
					break;
				}
			}
			
			in.close();
			out.close();
			S7.close();
		}
		catch (NumberFormatException e)	{System.out.println("Error. Tipo de valor incorrecto.");}
		catch (SocketException e)		{System.out.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)			{e.printStackTrace();}
		
	}
	
}

