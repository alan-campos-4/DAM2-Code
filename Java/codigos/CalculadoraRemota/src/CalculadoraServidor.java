import java.io.*;
import java.net.*;

public class CalculadoraServidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Servidor de calculadora iniciado en el puerto 5001...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado...");
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Leer el comando enviado por el cliente
                    String comando = in.readLine();
                    System.out.println("Comando recibido: " + comando);

                    // Dividir el comando en partes
                    String[] partes = comando.split(" ");
                    if (partes.length == 3) {
                        String operacion = partes[0];
                        double op1 = Double.parseDouble(partes[1]);
                        double op2 = Double.parseDouble(partes[2]);
                        double resultado;

                        // Realizar la operación
                        switch (operacion.toUpperCase()) {
                            case "SUMA":
                                resultado = op1 + op2;
                                break;
                            case "RESTA":
                                resultado = op1 - op2;
                                break;
                            case "MULTIPLICA":
                                resultado = op1 * op2;
                                break;
                            case "DIVIDE":
                                if (op2 != 0) {
                                    resultado = op1 / op2;
                                } else {
                                    out.println("Error: División entre cero.");
                                    continue;
                                }
                                break;
                            default:
                                out.println("Error: Operación no válida.");
                                continue;
                        }
                        out.println("Resultado: " + resultado);
                    } else {
                        out.println("Error: Formato de comando inválido. Use OPERACION OP1 OP2.");
                    }
                }
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error del servidor: " + e.getMessage());
        }
    }
}
