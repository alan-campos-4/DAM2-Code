/*
    Ej. 4
    Comunicación de procesos utilizando los streans de E/S.
    Se recuerda que todo proceso tiene
        - Fichero (Stream) de entrada 
        - Fichero (Stream) de salida
        - Fichero (Stream) de errores

    Documentación: https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html

    http://tamanmohamed.blogspot.com/2012/06/jdk7-processbuilder-and-how-redirecting.html

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio
   
 */
package proc.windows;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;
import proc.Carpeta;

/**
 *
 * @author santiago
 */
public class E04_RedireccionEyS {

    public static void main(String[] args) {

        try {
            // Deberá ejecutar el programa 2 veces para que aparezca algo en 
            // el fichero de errores
            
            // El fichero con los comandos de entrada se encuentra en la carpeta
            // raiz del proyecto
            File commands = new File(Carpeta.rutaProyecto() + "\\comandos.txt");
            File output = new File("C:/temp/ProcessLog.txt");
            File errors = new File("C:/temp/ErrorLog.txt");

            ProcessBuilder pbCmd = new ProcessBuilder("cmd");
            
            pbCmd.redirectOutput(Redirect.to(output));
            pbCmd.redirectError(Redirect.appendTo(errors));
            pbCmd.redirectInput(Redirect.from(commands));
            
            Process pDir = pbCmd.start();

            // Él padre espera la finalización del hijo (no haria falta)
            pDir.waitFor();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("\n--- FINALIZADO PADRE ---");
    }

}
