import java.io.*;
import java.net.*;

public class ClienteCarreraVirtual {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5009);
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

            // Enviar comandos al servidor
            String comandoUsuario;
            while ((comandoUsuario = consoleInput.readLine()) != null) {
                out.println(comandoUsuario);
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
