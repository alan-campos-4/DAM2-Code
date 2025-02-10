import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ServidorColaTurnos {
    private static final AtomicInteger turnoActual = new AtomicInteger(1);
    private static final AtomicInteger ultimoTurnoAsignado = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("Servidor de turnos iniciado en el puerto 5008...");
        try (ServerSocket serverSocket = new ServerSocket(5008)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static class ManejadorCliente implements Runnable {
        private Socket cliente;

        public ManejadorCliente(Socket cliente) {
            this.cliente = cliente;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                 PrintWriter out = new PrintWriter(cliente.getOutputStream(), true)) {

                // Asignar un turno al cliente
                int miTurno = ultimoTurnoAsignado.incrementAndGet();
                out.println("Tu turno es: " + miTurno);
                System.out.println("Turno asignado al cliente: " + miTurno);

                // Esperar hasta que sea el turno actual
                while (turnoActual.get() != miTurno) {
                    out.println("Por favor, espera... Turno actual: " + turnoActual.get());
                    Thread.sleep(2000); // Notificar cada 2 segundos
                }

                // Notificar que es su turno
                out.println("¡Es tu turno!");
                System.out.println("Atendiendo al cliente con turno: " + miTurno);

                // Simular atención (esperar unos segundos)
                Thread.sleep(5000);

                // Avanzar al siguiente turno
                turnoActual.incrementAndGet();
                out.println("Turno completado. Gracias por esperar.");

            } catch (IOException | InterruptedException e) {
                System.err.println("Error al procesar al cliente: " + e.getMessage());
            } finally {
                try {
                    cliente.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
                System.out.println("Cliente desconectado.");
            }
        }
    }
}
