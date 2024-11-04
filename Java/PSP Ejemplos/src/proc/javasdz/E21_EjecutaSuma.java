package proc.javasdz;

/*
    Ejemplo de comunicación entre procesos utilizando el código de error
    que devuelve el proceso hijo

    Ejemplo de comunicación entre dos programas hechos en java
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import proc.Carpeta;


/**
 *
 * @author santiago
 */
public class E21_EjecutaSuma {

    final static String CLASE_EJECUTAR="E21_Suma";
    final static String FICH_ENTRADA="c:\\temp\\parametros.txt";
    
    public static void main(String[] args) {
        try {

            escribeParametrosEntrada(11,12);
            ejecuta(new File(FICH_ENTRADA));
            
            System.out.println("Finalizado programa principal");
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void escribeParametrosEntrada(int... num) throws IOException {
        FileWriter writer = new FileWriter(FICH_ENTRADA);
        
        for(int i=0; i<num.length; i++) {
            writer.write(Integer.toString(num[i]));
            writer.write("\n");
        }
        writer.close();
    }
    
    /**
     * ejecuta la clase Java Suma pasandole los parametros n1 y n2
     * @param n1
     * @param n2
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void ejecuta(File input) throws IOException,
            InterruptedException {
        
        // Tenemos que ejecutar java en la carpeta en la que se encuentran
        // las clases. En otro caso tendremos error
        String[] command = {
            "java", 
            "-classpath", 
            "\""+Carpeta.rutaClasesNetbeans()+"\"", 
            "proc.javasdz."+CLASE_EJECUTAR
        };
        
        System.out.println("Ejecutando ... \n" + String.join(" ", command));
        ProcessBuilder pb = new ProcessBuilder(command);
        // Redirigimos entrada de proceso al fichero creado
        pb.redirectInput(input);
        
        System.out.println("\nDirectorio trabajo: " + Carpeta.rutaClasesNetbeans());
        pb.directory(new File(Carpeta.rutaClasesNetbeans()));
        
        System.out.println("Comando lanzado");
        Process process = pb.start();
        System.out.println("Esperando resultado ...");
        process.waitFor();
        System.out.println("Ejecutada aplicación. ");
        
        // Observad como mostramos a posteri el valor devuelto por el hijo
        // Podríamos utilizar esto para pasar resultados a otro proceso
        System.out.println("SALIDA:\n" + output(process.getInputStream()));            
        System.out.println("ERRORES System.err:\n" + output(process.getErrorStream()));
    }
    
    /**
     * Copia en la salida estandar el buffer de salida del proceso hijo
     * @param inputStream
     * @return
     * @throws IOException 
     */
    private static String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }    
}
