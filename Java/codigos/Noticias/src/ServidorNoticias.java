import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorNoticias {
    private static final Map<String, List<String>> noticias = new HashMap<>();

    public static void main(String[] args) {
        // Inicializar las noticias por categoría
        noticias.put("1", Arrays.asList("Gol de Messi en el minuto 90", "Final de la Copa del Rey este viernes"));
        noticias.put("2", Arrays.asList("Lanzamiento del nuevo iPhone", "Lanzamiento del Covid 2"));
        noticias.put("3", Arrays.asList("Estreno de la nueva película de Star Wars", "La Casa de Papel es una basura"));
        noticias.put("5", Arrays.asList("Estreno de la nueva película de Star Wars", "La Casa de Papel es una basura"));

        System.out.println("Servidor de noticias iniciado en el puerto 5004...");
        try (ServerSocket serverSocket = new ServerSocket(5004)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                manejarCliente(cliente);
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static void manejarCliente(Socket cliente) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter out = new PrintWriter(cliente.getOutputStream(), true)) {

            // Bucle para permitir que el cliente consulte varias veces
            while (true) {
                // Enviar menú de categorías
                out.println("Seleccione una categoría de noticias:");
                out.println("1) Deportes");
                out.println("2) Tecnología");
                out.println("3) Entretenimiento");
                out.println("4) Salir");
                out.println(); // Línea vacía para indicar el final del menú

                // Leer la opción del cliente
                String opcion = in.readLine();
                if (opcion == null) {
                    break; // Si el cliente se desconecta
                }

                System.out.println("Opción seleccionada por el cliente: " + opcion);

                // Responder según la opción elegida
                if (noticias.containsKey(opcion)) {
                    out.println("Titulares:");
                    for (String titular : noticias.get(opcion)) {
                        out.println("- " + titular);
                    }
                    out.println(); // Línea vacía para separar las respuestas
                } else if ("4".equals(opcion)) {
                    out.println("Gracias por usar el servidor de noticias. ¡Hasta luego!");
                    break;
                } else {
                    out.println("Opción no válida. Por favor, intente nuevamente.");
                }
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
