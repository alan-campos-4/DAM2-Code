import java.io.*;
import java.net.*;

public class ChatSimpleCliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5003);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor de chat.");
            System.out.println("Escribe tus mensajes. Para salir, usa Ctrl+C.");

            // Hilo para escuchar mensajes del servidor
            Thread hiloEscucha = new Thread(() -> {
                try {
                    String mensajeServidor;
                    while ((mensajeServidor = in.readLine()) != null) {
                        System.out.println(mensajeServidor);
                    }
                } catch (IOException e) {
                    System.err.println("Error al recibir mensajes: " + e.getMessage());
                }
            });
            hiloEscucha.start();

            // Enviar mensajes al servidor
            String mensajeUsuario;
            while ((mensajeUsuario = consoleInput.readLine()) != null) {
                out.println(mensajeUsuario);
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
