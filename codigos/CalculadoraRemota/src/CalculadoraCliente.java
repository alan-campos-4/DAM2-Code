import java.io.*;
import java.net.*;

public class CalculadoraCliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5001);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor de calculadora.");
            System.out.println("Ingrese un comando en el formato: OPERACION OP1 OP2 (e.g., SUMA 4 5):");

            // Leer el comando desde la consola
            String comando = consoleInput.readLine();
            out.println(comando);

            // Leer y mostrar la respuesta del servidor
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException e) {
            System.err.println("Error del cliente: " + e.getMessage());
        }
    }
}
