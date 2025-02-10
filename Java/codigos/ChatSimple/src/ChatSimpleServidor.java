import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatSimpleServidor {
    private static List<PrintWriter> listaClientes = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        System.out.println("Servidor de chat iniciado en el puerto 5003...");
        try (ServerSocket serverSocket = new ServerSocket(5003)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                Thread hiloCliente = new Thread(new ManejadorCliente(cliente));
                hiloCliente.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static class ManejadorCliente implements Runnable {
        private Socket cliente;
        private PrintWriter out;

        public ManejadorCliente(Socket cliente) {
            this.cliente = cliente;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {
                out = new PrintWriter(cliente.getOutputStream(), true);
                listaClientes.add(out);

                out.println("¡Bienvenido al chat!");
                String mensaje;
                while ((mensaje = in.readLine()) != null) {
                    System.out.println("Mensaje recibido: " + mensaje);
                    broadcast("Cliente dice: " + mensaje);
                }
            } catch (IOException e) {
                System.err.println("Error con el cliente: " + e.getMessage());
            } finally {
                if (out != null) {
                    listaClientes.remove(out);
                }
                try {
                    cliente.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el cliente: " + e.getMessage());
                }
                System.out.println("Cliente desconectado.");
            }
        }

        private void broadcast(String mensaje) {
            for (PrintWriter cliente : listaClientes) {
                cliente.println(mensaje);
            }
        }
    }
}
