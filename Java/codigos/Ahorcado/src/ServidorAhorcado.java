import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorAhorcado {
    private static final List<String> PALABRAS = Arrays.asList("PROGRAMACION", "INTERFAZ", "SOCKET", "JAVA");
    private static final int INTENTOS_MAXIMOS = 6;

    public static void main(String[] args) {
        System.out.println("Servidor del Ahorcado iniciado en el puerto 5006...");
        try (ServerSocket serverSocket = new ServerSocket(5006)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado.");
                manejarCliente(cliente);
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static void manejarCliente(Socket cliente) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter out = new PrintWriter(cliente.getOutputStream(), true)) {

            // Seleccionar palabra secreta
            String palabraSecreta = PALABRAS.get(new Random().nextInt(PALABRAS.size()));
            char[] progreso = new char[palabraSecreta.length()];
            Arrays.fill(progreso, '_');
            int intentosRestantes = INTENTOS_MAXIMOS;
            Set<Character> letrasUsadas = new HashSet<>();

            // Enviar mensaje inicial
            out.println("¡Bienvenido al Ahorcado!");
            out.println("Adivina la palabra: " + String.valueOf(progreso));
            out.println("Intentos restantes: " + intentosRestantes);

            while (intentosRestantes > 0) {
                // Leer letra del cliente
                String entrada = in.readLine();
                if (entrada == null || entrada.length() != 1) {
                    out.println("Por favor, envía una sola letra.");
                    out.println("Progreso actual: " + String.valueOf(progreso));
                    continue;
                }

                char letra = entrada.toUpperCase().charAt(0);

                if (letrasUsadas.contains(letra)) {
                    out.println("Ya usaste la letra '" + letra + "'. Intenta con otra.");
                    out.println("Progreso actual: " + String.valueOf(progreso));
                    continue;
                }

                letrasUsadas.add(letra);

                // Actualizar el estado del juego
                boolean acierto = false;
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        progreso[i] = letra;
                        acierto = true;
                    }
                }

                if (acierto) {
                    out.println("¡Acierto!");
                } else {
                    intentosRestantes--;
                    out.println("¡Fallaste! Intentos restantes: " + intentosRestantes);
                }

                // Verificar si el jugador ha ganado o perdido
                if (String.valueOf(progreso).equals(palabraSecreta)) {
                    out.println("¡Felicidades, has adivinado la palabra: " + palabraSecreta + "!");
                    break;
                }

                if (intentosRestantes == 0) {
                    out.println("¡Se acabaron los intentos! La palabra era: " + palabraSecreta);
                    break;
                }

                // Enviar progreso actual al cliente
                out.println("Progreso actual: " + String.valueOf(progreso));
            }
        } catch (IOException e) {
            System.err.println("Error al procesar al cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();
                System.out.println("Cliente desconectado.");
            } catch (IOException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
