/*  Ej. 1.1
    Ejemplo sobre como lanzar un proceso en java utilizando la clase 
    Runtime
    
    https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html

    El padre espera por el hijo 10 seg y luego lo mata

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio

    Ver https://www.developer.com/java/data/understanding-java-process-and-java-processbuilder.html
 */
package proc.windows;


import java.util.concurrent.TimeUnit;

/**
 *
 * @author santiago
 */
public class E01_Notepad_1 {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("notepad");
            process.waitFor(10, TimeUnit.SECONDS);
            process.destroy();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}
