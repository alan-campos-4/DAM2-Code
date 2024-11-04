/*
    Utilidades para obtener la carpeta del proyecto y en la que
    se ejecuta una clase
 */
package proc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author santiago
 */
public class Carpeta {

    /**
     * Devuelve la carpeta actual desde la que se está ejecutando nuestra
     * aplicación Java
     * 
     * @return Ruta absoluta de la carpeta actual
     */
    public static String actual() {
        File miDir = new File(".");
        String ruta=miDir.getAbsolutePath();
        // Ruta sin \. final
        return ruta.substring(0, ruta.length()-2);
    }
    
    public static String clasesEnNetbeans() {
        return "build\\classes";
    }
    
    public static String rutaProyecto() {
        return System.getProperty("user.dir");
    }
    
    public static String rutaClasesNetbeans() {
        return actual()+"\\"+clasesEnNetbeans();
    }
    
    /**
     * Devuelve el nombre de un fichero con una marca temporal
     * @param nombre    Nombre del fichero
     * @param tipo      Tipo del fichero
     * @return 
     */
    public static String nombreFicheroAhora(String nombre, String tipo) {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        
        
        return nombre + "_" + formateador.format(ahora) + "." + tipo;
    }
}
