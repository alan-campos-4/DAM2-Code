import java.io.*;
import java.net.*;

public class ServidorPhotoSender {
    public static void main(String[] args) {
        System.out.println("Servidor de archivos iniciado en el puerto 5005...");
        try (ServerSocket serverSocket = new ServerSocket(5005)) {
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
             OutputStream out = cliente.getOutputStream()) {

            // Leer el nombre del archivo solicitado
            String nombreArchivo = in.readLine();
            System.out.println("Archivo solicitado: " + nombreArchivo);

            File archivo = new File(nombreArchivo);
            if (archivo.exists() && !archivo.isDirectory()) {
                // Enviar tamaño del archivo al cliente
                out.write((archivo.length() + "\n").getBytes());

                // Leer y enviar el archivo en formato binario
                try (FileInputStream fis = new FileInputStream(archivo);
                     BufferedInputStream bis = new BufferedInputStream(fis)) {
                    byte[] buffer = new byte[4096];
                    int bytesLeidos;
                    while ((bytesLeidos = bis.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesLeidos);
                    }
                }
                System.out.println("Archivo enviado correctamente.");
            } else {
                // Enviar mensaje de error si el archivo no existe
                out.write("ERROR: Archivo no encontrado\n".getBytes());
                System.out.println("El archivo solicitado no existe.");
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
