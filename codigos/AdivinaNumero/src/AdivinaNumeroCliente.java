import java.io.*;
import java.net.*;

public class AdivinaNumeroCliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5002);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor del juego.");
            System.out.println("Adivina el número entre 1 y 100.");

            String respuesta;
            do {
                System.out.print("Introduce tu intento: ");
                String intento = consoleInput.readLine();
                out.println(intento); // Enviar intento al servidor
                respuesta = in.readLine(); // Leer respuesta del servidor
                System.out.println("Respuesta del servidor: " + respuesta);
            } while (!"¡Acertaste!".equals(respuesta));

        } catch (IOException e) {
            System.err.println("Error del cliente: " + e.getMessage());
        }
    }
}
