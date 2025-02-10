
import java.io.*;
import java.net.*;

public class SaludoExpresServidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado en el puerto 5000...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado...");
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    String mensaje = in.readLine();
                    System.out.println("Mensaje recibido: " + mensaje);
                    out.println("Hola, recibí tu mensaje: " + mensaje);
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error del servidor: " + e.getMessage());
        }
    }
}
