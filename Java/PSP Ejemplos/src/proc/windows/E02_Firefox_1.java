/*
    Ej. 2.1
    Ejemplo sobre como lanzar un proceso en java utilizando la clase 
    ProccessBuilder con parámetros

    Para ejecutar esta clase seleccione el proyecto en la ventana de proyectos
    y en el menú contextual seleccione "Propiedades", luego en la opción 
    ejecutar seleccione esta clase como la de inicio
 */
package proc.windows;

/**
 *
 * @author santi
 */
public class E02_Firefox_1 {
    public static void main(String[] args) {
        ProcessBuilder pb;
        try {
            System.out.println("\nArrancando firefox");
            // Aquí podréis la ruta completa del programa a arrancer en el
            // equipo
            String rutaFirefox="C:\\Program Files\\Mozilla Firefox\\firefox";
            String pag1="http://huelva24.com/";
            
            pb = new ProcessBuilder(rutaFirefox, pag1);
            
            // Indicamos que arrancamos el proceso. Aun no se ha arrancado
            Process proceso=pb.start();
            
            
            
            // El padre espera que finalice el hijo
            int retorno = proceso.waitFor();
            System.out.println("\nValor retorno: "+retorno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("\n --- FIN  proceso padre ---");
        System.exit(-1);
    }     
}
