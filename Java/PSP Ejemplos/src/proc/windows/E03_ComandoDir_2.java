/*
    Ej. 3.1
    Comunicación de procesos utilizando los streans de E/S.
    Se recuerda que todo proceso tiene
        - Fichero (Stream) de entrada 
        - Fichero (Stream) de salida
        - Fichero (Stream) de errores

    Documentación: https://docs.oracle.com/javase/7/docs/api/java/lang/ProcessBuilder.html

    Mas info: Cómo ejecutar un proceso del sistema con Java
    https://picodotdev.github.io/blog-bitix/2016/03/como-ejecutar-un-proceso-del-sistema-con-java/

    http://www.xyzws.com/Javafaq/how-to-run-external-programs-by-using-java-processbuilder-class/189

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio
   
 */
package proc.windows;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 * @author santiago
 */
public class E03_ComandoDir_2 {

    public static void main(String[] args) throws IOException {

        String[] command = {"CMD", "/C", "dir"};
        
        ProcessBuilder probuilder = new ProcessBuilder(command);
        
        // Seleccionamos directorio de trabajo del proceso
        probuilder.directory(new File("c:\\Windows\\system32"));

        Process process = probuilder.start();

        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);


        System.out.printf("La salida del proceso %s es:\n",
                Arrays.toString(command));
        
        
        copiaStream(System.out, br);
 
        //Wait to get exit value
        try {
            int exitValue = process.waitFor();
            System.out.println("\n\nExit Value is " + exitValue);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Copia el contenido completo de un stream de entrada en uno de salida
     * @param dest
     * @param orig
     * @throws IOException 
     */
    private static void copiaStream(PrintStream dest, BufferedReader orig) 
                                throws IOException {
        String line;
        while ((line = orig.readLine()) != null) {
            dest.println(line);
        }
    }    
}
