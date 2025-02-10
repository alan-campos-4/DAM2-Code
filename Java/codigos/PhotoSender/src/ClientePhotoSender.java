import java.io.*;
import java.net.*;

public class ClientePhotoSender {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5005);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream out = socket.getOutputStream();
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            // Solicitar el nombre del archivo al usuario
            System.out.print("Ingrese el nombre del archivo que desea descargar: ");
            String nombreArchivo = consoleInput.readLine();
            out.write((nombreArchivo + "\n").getBytes());

            // Leer respuesta del servidor
            String respuesta = in.readLine();
            if (respuesta.startsWith("ERROR")) {
                System.out.println(respuesta); // Mostrar mensaje de error
            } else {
                // Leer el tamaño del archivo
                long tamanoArchivo = Long.parseLong(respuesta);
                System.out.println("Descargando archivo de " + tamanoArchivo + " bytes...");

                // Descargar el archivo
                try (FileOutputStream fos = new FileOutputStream("descargado_" + nombreArchivo);
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                    byte[] buffer = new byte[4096];
                    int bytesLeidos;
                    long bytesTotalesLeidos = 0;

                    while (bytesTotalesLeidos < tamanoArchivo &&
                            (bytesLeidos = socket.getInputStream().read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesLeidos);
                        bytesTotalesLeidos += bytesLeidos;
                    }
                    System.out.println("Archivo descargado como: descargado_" + nombreArchivo);
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
