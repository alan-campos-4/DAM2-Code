/*
Este ejemplo debe ser ejecutado en el sistema operativo Linux

Mas info: Cómo ejecutar un proceso del sistema con Java
https://picodotdev.github.io/blog-bitix/2016/03/como-ejecutar-un-proceso-del-sistema-con-java/

http://javatutorialhq.com/java/lang/processbuilder/


 */
package proc.linux;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import proc.Carpeta;

/**
 *
 * @author santiago
 */
public class E11_Comando_ls {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ls", "-al", "/");
            final Process p = pb.start();
            
            // Donde guardaremos la salida del proceso. Sera nuestro buffer de
            // entrada
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            p.getInputStream()));
            
            // Guardaremos además el resultado en un fichero
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(new File("/tmp/" + Carpeta.nombreFicheroAhora("ls", "log"))));
           
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                // Escribimos en la consola de salida por comodidad, para
                // ver resultados intermedios
                System.out.println(line);
            }
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
