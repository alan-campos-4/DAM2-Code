/*
Este ejemplo debe ser ejecutado en el sistema operativo Linux

 Comunicación entre procesos.
Se invoca al comando cal para que devuelva el calendario del año
https://www.developer.com/java/data/understanding-java-process-and-java-processbuilder.html
 */
package proc.linux;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author profesor
 */
public class E10_Calendar {

    public static void main(String[] args) {

        System.out.println("*************Calendar for Year**********");
        try {
            ProcessBuilder pb = new ProcessBuilder("cal", "2022");
            final Process p = pb.start();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line;
            
            // Leemos los resultados generados por el proceso hijo
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("************************************");
    }

}
