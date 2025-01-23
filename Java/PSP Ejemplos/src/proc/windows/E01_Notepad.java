/*  Ej. 1
    Ejemplo sobre como lanzar un proceso en java utilizando la clase 
    Runtime
    
    https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio

 */
package proc.windows;

import java.io.IOException;

/**
 *

 */
public class E01_Notepad {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            // Se crea y lanza el proceso Bloc de Notas
            // Se encuentra el programa pues está en el PATH del S.O.
            @SuppressWarnings("deprecation")
			Process process = runtime.exec("notepad");
            
            // Si quitáis el comentario de la siguientes líneas, el padre
            // finalizaría al hijo antes de finalizar despues de 10 seg.
            
            // Quita los comentarios siguientes
            Thread.sleep(10000); // Espero 10 seg.
            process.destroy();
            
        } catch (IOException ex) {
            System.err.println("Excepción en operación");
            ex.printStackTrace();
            System.exit(-1);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 
        // Observad la consola del entorno, y mirar el mensaje
        // El proceso hijo sigue vivo aunque finalice el padre
        System.out.println("\n --- FIN  proceso padre ---");
    }    
}
