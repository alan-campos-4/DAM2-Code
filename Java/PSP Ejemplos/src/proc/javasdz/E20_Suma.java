
package proc.javasdz;


/**
 * Aplicación que suma dos números enteros que se suministran en la linea de
 * comandos y devuelve el resultado como código de error de la aplicación
 * 
 * Ante cualquier error devuelve 0. Normalmente el código 0 indica que no 
 * ha habido error, aquí estamos utilizando este código de una forma un poco 
 * particular
 * 
 * @author santiago
 */
public class E20_Suma {

    public static void main(String[] args)  {
        try {
            String op1 = args[0];
            String op2 = args[1];
            int num1 = Integer.valueOf(op1);
            int num2 = Integer.valueOf(op2);
            int resu = num1+num2;
            System.out.println("=======PROCESO HIJO ======");
            System.out.println("Suma "+op1+" + "+ op2 + " = "+resu);
            System.exit(resu);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
}
