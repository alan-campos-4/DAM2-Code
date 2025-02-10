import java.io.*;
import java.net.*;

public class SaludoExpresCliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("Conectado al servidor. Escribe un mensaje:");
            String mensaje = consoleInput.readLine();
            out.println(mensaje);
            System.out.println("Respuesta del servidor: " + in.readLine());
        } catch (IOException e) {
            System.err.println("Error del cliente: " + e.getMessage());
        }
    }
}
