import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ServidorCarreraVirtual {
    private static final int META = 50; // Distancia para ganar
    private static final Map<Integer, Integer> posiciones = new ConcurrentHashMap<>(); // ID -> Posición
    private static final List<PrintWriter> clientes = new CopyOnWriteArrayList<>();
    private static int contadorID = 1;

    public static void main(String[] args) {
        System.out.println("Servidor de la carrera iniciado en el puerto 5009...");
        try (ServerSocket serverSocket = new ServerSocket(5009)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo jugador conectado.");
                new Thread(new ManejadorJugador(cliente, contadorID++)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static class ManejadorJugador implements Runnable {
        private Socket cliente;
        private int idJugador;

        public ManejadorJugador(Socket cliente, int idJugador) {
            this.cliente = cliente;
            this.idJugador = idJugador;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                 PrintWriter out = new PrintWriter(cliente.getOutputStream(), true)) {

                // Registrar al jugador
                posiciones.put(idJugador, 0);
                clientes.add(out);

                out.println("Bienvenido a la carrera virtual.");
                out.println("Tu ID de jugador es: " + idJugador);
                out.println("La meta está a " + META + " metros.");
                broadcast("Jugador " + idJugador + " se ha unido a la carrera.");

                // Manejo de comandos del jugador
                String comando;
                while ((comando = in.readLine()) != null) {
                    if (comando.equalsIgnoreCase("MOVE FORWARD")) {
                        avanzar(out);
                        if (posiciones.get(idJugador) >= META) {
                            broadcast("¡Jugador " + idJugador + " ha ganado la carrera!");
                            resetearCarrera();
                            break;
                        }
                    } else {
                        out.println("Comando no válido. Usa: MOVE FORWARD");
                    }
                }
            } catch (IOException e) {
                System.err.println("Error con el jugador " + idJugador + ": " + e.getMessage());
            } finally {
                desconectarJugador();
            }
        }

        private void avanzar(PrintWriter out) {
            posiciones.put(idJugador, posiciones.get(idJugador) + 5); // Avanzar 5 metros
            out.println("Has avanzado. Tu posición actual: " + posiciones.get(idJugador) + " metros.");
            broadcastEstado();
        }

        private void broadcast(String mensaje) {
            for (PrintWriter cliente : clientes) {
                cliente.println(mensaje);
            }
        }

        private void broadcastEstado() {
            StringBuilder estado = new StringBuilder("Estado de la carrera:\n");
            for (Map.Entry<Integer, Integer> entry : posiciones.entrySet()) {
                estado.append("Jugador ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" metros.\n");
            }
            broadcast(estado.toString());
        }

        private void resetearCarrera() {
            posiciones.clear();
            broadcast("La carrera ha terminado. ¡Se reiniciará pronto!");
        }

        private void desconectarJugador() {
            try {
                clientes.removeIf(cliente -> cliente.equals(cliente));
                posiciones.remove(idJugador);
                broadcast("Jugador " + idJugador + " ha abandonado la carrera.");
                cliente.close();
            } catch (IOException e) {
                System.err.println("Error al desconectar al jugador " + idJugador + ": " + e.getMessage());
            }
        }
    }
}
