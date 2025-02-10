import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ServidorChatMultiSalas {
    // Estructura para almacenar salas y sus clientes
    private static final Map<String, List<PrintWriter>> salas = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Servidor de chat multi-salas iniciado en el puerto 5007...");
        try (ServerSocket serverSocket = new ServerSocket(5007)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    // Clase para manejar la comunicación con cada cliente
    private static class ManejadorCliente implements Runnable {
        private Socket cliente;
        private PrintWriter out;
        private String salaActual;

        public ManejadorCliente(Socket cliente) {
            this.cliente = cliente;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                 PrintWriter out = new PrintWriter(cliente.getOutputStream(), true)) {
                this.out = out;

                // Pedir al cliente que elija una sala
                out.println("Bienvenido al chat multi-salas.");
                out.println("Elija una sala para unirse (por ejemplo: Matemáticas, Historia, Inglés):");
                salaActual = in.readLine();
                if (salaActual == null || salaActual.trim().isEmpty()) {
                    salaActual = "General";
                }

                // Unir al cliente a la sala
                unirASala(salaActual);
                broadcast(salaActual, "Un usuario se ha unido a la sala.");

                // Leer mensajes del cliente
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    if (mensaje.startsWith("/cambiar")) {
                        // Cambiar de sala
                        String nuevaSala = mensaje.split(" ", 2)[1].trim();
                        cambiarDeSala(nuevaSala);
                    } else {
                        // Enviar mensaje a la sala actual
                        broadcast(salaActual, mensaje);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error con el cliente: " + e.getMessage());
            } finally {
                salirDeSala();
                try {
                    cliente.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
                System.out.println("Cliente desconectado.");
            }
        }

        // Unir a un cliente a una sala
        private void unirASala(String sala) {
            salas.putIfAbsent(sala, new CopyOnWriteArrayList<>());
            salas.get(sala).add(out);
            salaActual = sala;
            out.println("Te has unido a la sala: " + sala);
        }

        // Cambiar de sala
        private void cambiarDeSala(String nuevaSala) {
            salirDeSala();
            unirASala(nuevaSala);
            out.println("Has cambiado a la sala: " + nuevaSala);
        }

        // Salir de la sala actual
        private void salirDeSala() {
            if (salaActual != null && salas.containsKey(salaActual)) {
                salas.get(salaActual).remove(out);
                broadcast(salaActual, "Un usuario ha salido de la sala.");
            }
        }

        // Enviar mensaje a todos los usuarios de una sala
        private void broadcast(String sala, String mensaje) {
            if (salas.containsKey(sala)) {
                for (PrintWriter cliente : salas.get(sala)) {
                    cliente.println("[" + sala + "] " + mensaje);
                }
            }
        }
    }
}
