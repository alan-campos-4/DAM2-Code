/*
    Ej. 2
    Ejemplo sobre como lanzar un proceso en java utilizando la clase 
    ProccessBuilder

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio
 */
package proc.windows;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class E02_Firefox {
    public static void main(String[] args) {
        ProcessBuilder pb;
        try {
            System.out.println("\nArrancando firefox");
            // Aquí podréis la ruta completa del programa a arrancer en el
            // equipo
            String rutaFirefox="C:\\Program Files\\Mozilla Firefox\\firefox";
            
            pb = new ProcessBuilder(rutaFirefox);
            
            // Indicamos que arrancamos el proceso. Aun no se ha arrancado
            Process proceso=pb.start();
            
            JOptionPane.showMessageDialog(null, "Pulse para finalizar proceso hijo");
            proceso.destroy();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("\n --- FIN  proceso padre ---");
        
        // Observad como netbeans nos avisa que nuestra aplicación devuelve
        // un código de error en la consola (un error es un valor distinto
        // de 0).
        System.exit(-1);
    }     
}
