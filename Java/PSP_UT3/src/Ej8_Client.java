import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ej8_Client
{
	// 1. Conectarse al servidor (localhost, 5007).
	// 2. Introducir/indicar la sala a la que unirse.
	// 3. Hilo que lee mensajes del servidor y los muestra.
	// 4. Bucle que lee la consola local y envía mensajes.
	// 5. Soportar comando "/cambiar SalaX" para cambiar de sala.
	
	public static void main(String[] args)
	{
		try (Socket socket = new Socket("localhost", 5007);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

			// Hilo para escuchar mensajes del servidor
			Thread hiloEscucha = new Thread(() -> {
				try {
					String mensaje;
					while ((mensaje = in.readLine()) != null) {
						System.out.println(mensaje);
					}
				} catch (IOException e) {
					System.err.println("Error al recibir mensajes: " + e.getMessage());
				}
			});
			hiloEscucha.start();

			// Leer mensajes del usuario y enviarlos al servidor
			String mensajeUsuario;
			while ((mensajeUsuario = consoleInput.readLine()) != null) {
				out.println(mensajeUsuario);
			}
		} catch (IOException e) {
			System.err.println("Error en el cliente: " + e.getMessage());
		}
	}
	
}

