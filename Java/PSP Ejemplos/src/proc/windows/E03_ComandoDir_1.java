/*
    Ej. 3
    Comunicación de procesos utilizando los streans de E/S.
    Se recuerda que todo proceso tiene
        - Fichero (Stream) de entrada 
        - Fichero (Stream) de salida
        - Fichero (Stream) de errores

    Documentación: https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html

    Mas info: Cómo ejecutar un proceso del sistema con Java
    https://picodotdev.github.io/blog-bitix/2016/03/como-ejecutar-un-proceso-del-sistema-con-java/

    http://javatutorialhq.com/java/lang/processbuilder/

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio
 */
package proc.windows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author santiago
 */
public class E03_ComandoDir_1 {

    public static void main(String[] args) {
        try {
            // Lanzamos el comando cmd /c dir c:\\windows

            // Lo siguiente no funciona pues "dir" no es un programa, sino un
            // comando del interprete de comandos "cmd"
            // ProcessBuilder pb = new ProcessBuilder("dir", "c:\\windows");
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir", "c:\\windows");

            final Process p = pb.start();

            // Recogeremos lo que devuelva el proceso, que en este caso será
            // la lista de archivos
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            p.getInputStream()));

            // Guardamos lo que devuelve el proceso en un fichero del disco
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(new File("c:/temp/dir.txt")));

            copiaStream(bw, br);
            
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Copia el contenido completo de un stream de entrada en uno de salida
     * @param dest
     * @param orig
     * @throws IOException 
     */
    private static void copiaStream(BufferedWriter dest, BufferedReader orig) 
                                throws IOException {
        String line;
        while ((line = orig.readLine()) != null) {
            dest.write(line);
            
            
            // Escribimos en la consola de salida por comodidad, para
            // ver resultados intermedios
            System.out.println(line);
        }
    }
}
