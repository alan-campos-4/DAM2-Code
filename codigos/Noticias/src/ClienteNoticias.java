import java.io.*;
import java.net.*;

public class ClienteNoticias {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5004);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            // Bucle para mantener la comunicación hasta que el cliente decida salir
            while (true) {
                // Leer el menú de categorías del servidor
                String linea;
                while (!(linea = in.readLine()).isEmpty()) {
                    System.out.println(linea);
                }

                // Leer la opción del usuario desde la consola
                System.out.print("Ingrese su opción: ");
                String opcion = consoleInput.readLine();
                out.println(opcion);

                // Si el usuario selecciona "4", salimos del bucle
                if ("4".equals(opcion)) {
                    System.out.println("Saliendo del servidor de noticias. ¡Hasta luego!");
                    break;
                }

                // Leer y mostrar las noticias enviadas por el servidor
                while (!(linea = in.readLine()).isEmpty()) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
