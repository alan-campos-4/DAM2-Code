
import java.io.*;
import java.net.*;
import java.util.Random;

public class AdivinaNumeroServidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5002)) {
            System.out.println("Servidor del juego iniciado en el puerto 5002...");
            Random rand = new Random();
            int numeroSecreto = rand.nextInt(100) + 1; // Número aleatorio entre 1 y 100
            System.out.println("Número secreto generado.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado...");
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String intento;
                    while ((intento = in.readLine()) != null) {
                        try {
                            int numero = Integer.parseInt(intento);
                            if (numero < numeroSecreto) {
                                out.println("Mayor");
                            } else if (numero > numeroSecreto) {
                                out.println("Menor");
                            } else {
                                out.println("¡Acertaste!");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            out.println("Error: Debes enviar un número.");
                        }
                    }
                }
                clientSocket.close();
                System.out.println("El cliente ha terminado.");
            }
        } catch (IOException e) {
            System.err.println("Error del servidor: " + e.getMessage());
        }
    }
}
