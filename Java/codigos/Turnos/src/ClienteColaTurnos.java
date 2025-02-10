import java.io.*;
import java.net.*;

public class ClienteColaTurnos {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5008);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Leer mensajes del servidor
            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println(mensaje);

                // Salir cuando el turno esté completado
                if (mensaje.startsWith("Turno completado")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
