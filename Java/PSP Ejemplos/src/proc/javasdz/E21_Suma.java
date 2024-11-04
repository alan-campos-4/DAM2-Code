
package proc.javasdz;

import java.io.IOException;
import java.util.Scanner;

/**
 * Aplicación que suma dos números enteros que se suministran por el fichero
 * de entrada por defecto System.in
 * 
 * Devuelve el resutlado por el stream de salida System.out
 * 
 * @author santiago
 */
public class E21_Suma {

    public static void main(String[] args)  {
        try {
            Scanner sc = new Scanner(System.in);
            

            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int resu = num1+num2;
            
            System.out.print(resu);
            
            System.err.println("=======PROCESO HIJO ======");
            System.err.println("Suma "+num1+" + "+ num2 + " = "+resu);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
}
