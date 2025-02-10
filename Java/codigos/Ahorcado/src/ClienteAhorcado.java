import java.io.*;
import java.net.*;

public class ClienteAhorcado {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5006);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            // Leer mensaje de bienvenida y estado inicial del juego
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);

                // Si el juego termina, salir del bucle
                if (linea.startsWith("¡Felicidades") || linea.startsWith("¡Se acabaron")) {
                    break;
                }

                // Si el servidor solicita una letra, pedirla al usuario
                if (linea.startsWith("Progreso actual:") || linea.startsWith("Adivina la palabra")) {
                    System.out.print("Introduce una letra: ");
                    String letra = consoleInput.readLine();
                    out.println(letra);
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
