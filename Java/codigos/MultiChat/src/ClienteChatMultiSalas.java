import java.io.*;
import java.net.*;

public class ClienteChatMultiSalas {
    public static void main(String[] args) {
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
