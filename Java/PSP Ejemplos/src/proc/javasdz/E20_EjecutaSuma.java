package proc.javasdz;

/*
    Ejemplo de comunicación entre procesos utilizando el código de error
    que devuelve el proceso hijo

    Ejemplo de comunicación entre dos programas hechos en java
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import proc.Carpeta;


/**
 *
 * @author santiago
 */
public class E20_EjecutaSuma {

    final String CLASE_EJECUTAR="E20_Suma";
    
    public static void main(String[] args) {
        try {
        System.out.println("RUTA: " + System.getProperty("user.dir"));
        E20_EjecutaSuma prog = new E20_EjecutaSuma();

        
        prog.ProcSuma(5, 10);
        prog.ProcSuma(15, 20);

        System.out.println("Finalizado programa principal");
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ejecuta la clase Java Suma pasandole los parametros n1 y n2
     * @param n1
     * @param n2
     * @throws IOException
     * @throws InterruptedException 
     */
    public void ProcSuma(int n1, int n2) throws IOException,
            InterruptedException {
        
        // Tenemos que ejecutar java en la carpeta en la que se encuentran
        // las clases. En otro caso tendremos error
        String[] command = {
            "java", 
            "-classpath", 
            "\""+Carpeta.rutaClasesNetbeans()+"\"", 
            "proc.javasdz."+CLASE_EJECUTAR, 
            String.valueOf(n1),
            String.valueOf(n2)
        };
        
        System.out.println("Ejecutando ... \n" + String.join(" ", command));
        ProcessBuilder pb = new ProcessBuilder(command);
        
        System.out.println("\nDirectorio trabajo: " + Carpeta.rutaClasesNetbeans());
        pb.directory(new File(Carpeta.rutaClasesNetbeans()));
        
        System.out.println("Comando lanzado");
        Process process = pb.start();
        System.out.println("Esperando resultado ...");
        int errCode = process.waitFor();
        System.out.println("Ejecutada aplicación. Código error (valor devuelto) = " + errCode);
        
        // Observad como mostramos a posteri el valor devuelto por el hijo
        // Podríamos utilizar esto para pasar resultados a otro proceso
        System.out.println("SALIDA:\n" + output(process.getInputStream()));            
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
