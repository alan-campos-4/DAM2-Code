import general.Base;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Exer09_14_Binaries
{
	static Scanner input;
	
	public static void main(String args[]) throws IOException
	{
		input = new Scanner(System.in);
		int op = 0;
		
		do {
			Base.createMenu(9, "Lee y guarda números enteros", "Lee y guarda un array de double", 
					"Lee contenido del fichero 9", "Muestra contenido del fichero 10", 
					"Copia una imagen en otro fichero", "Guardar pedidos");
			try
			{
				op = input.nextInt();
				
				if (op!=0)	{Base.clear();}
				switch(op)
				{
					default: {System.out.println("Opción no válida");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1:	case 9: 	{Ejer9();}	break;
					case 2:	case 10:	{Ejer10();}	break;
					case 3:	case 11:	{Ejer11();}	break;
					case 4:	case 12:	{Ejer12();}	break;
					case 5:	case 13:	{Ejer13();}	break;
					case 6:	case 14:	{Ejer14();}	break;
				}
				if (op!=0)	{Base.pressAnyKey();}
			}
			catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
		
		} while (op!=0);
	}
	
	
	
	
	/*
	 * 9. Programa que lee enteros por teclado y los escribe en el fichero binario “datos.dat”.
	 */
	public static void Ejer9()
	{
		System.out.println("Introduce números enteros. Introduce 0 para terminar.");
		int num = 0;
		
		try
		{
			File f = new File("datos.dat");
			BufferedOutputStream dout = new BufferedOutputStream(new FileOutputStream(f) );
			
			do {
				System.out.print(" -> ");
				num = input.nextInt();
				dout.write(num);
			} while (num!=0);
			
			dout.close();
		}
		catch (Exception e)	{System.out.println();}
	}
	
	
	
	
	/*
	 * 10. Programa Java que crea un array de elementos de tipo double y lee por teclado el valor de sus elementos. 
	 * A continuación escribe el contenido del array en un fichero. 
	 * Al principio del fichero se escriben dos enteros con los valores del número de filas y columnas del array.
	 */
	public static void Ejer10()
	{
		System.out.println("Introduce el tamaño de un array: ");
		int row, col;
		System.out.print(" - Filas: ");		row = input.nextInt();
		System.out.print(" - Columnas: ");	col = input.nextInt();
		
		double[][] arr = new double[row][col];
		
		System.out.println("Introduce los elementos del array: ");
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
				{arr[i][j] = input.nextDouble();}
		}
		
		try
		{
			File f = new File("array.dat");
			DataOutputStream bout = new DataOutputStream(new FileOutputStream(f, true));
			
			bout.writeInt(row);
			bout.writeInt(col);
			
			for (int i=0; i<row; i++)
			{
				for (int j=0; j<col; j++)
					{bout.writeDouble(arr[i][j]);}
			}
			
			bout.close();
		}
		catch (Exception e)	{System.out.println();}
	}

	
	
	
	/*
	 * 11. Programa que lee el contenido del fichero creado en el ejercicio 9. 
	 * Utilizaremos un bucle infinito para leer los datos. 
	 * Cuando se llega al final del fichero se lanza la excepción EOFException 
	 * que se utiliza para salir del bucle while.
	 */
	public static void Ejer11() throws IOException
	{
		FileInputStream fis = null;
		DataInputStream dis = null;
		try
		{
			fis = new FileInputStream("datos.dat");
			dis = new DataInputStream(fis);
			
			int x;
			while (true)
			{
				x = dis.readInt(); 
				System.out.print(x+" * "); 
			}
		}
		catch (EOFException e)	{System.out.println("Fin del archivo.");}
		catch (Exception e)		{e.printStackTrace();}
		
		fis.close();
		dis.close();
	}
	
	
	
	
	/*
	 * 12. Programa Java que lee el contenido del fichero creado en el ejercicio 10 y lo muestra por pantalla.
	 */
	public static void Ejer12()
	{
		FileInputStream fis = null;
        DataInputStream entrada = null;
        int rows, cols;
        try
        {
            fis = new FileInputStream("matriz.dat");
            entrada = new DataInputStream(fis);
            rows = entrada.readInt();
            cols = entrada.readInt();
            for (int i=0; i<rows; i++)
            {
                for (int j=0; j<cols; j++) 
                {
                    System.out.printf("%8.2f", entrada.readDouble());
                }
                System.out.println();
            }
        }
        catch (EOFException e)			{System.out.println("Fin de fichero");}
        catch (FileNotFoundException e)	{System.out.println(e.getMessage());} 
        catch (IOException e)			{System.out.println(e.getMessage());}
        finally
        {
            try
            {
                if (fis!=null)		{fis.close();}
                if (entrada!=null)	{entrada.close();}
            } 
            catch (IOException e) {System.out.println(e.getMessage());}
        }
	}
	
	
	
	
	/*
	 * 13. Programa que copie una imagen en otro fichero utilizando memoria intermedia.
	 */
	public static void Ejer13()
	{
		File origen = new File("imagen1.jpg");
        File destino =  new File("imagen2.jpg");
        if (origen.exists())
        {
            try
            {
                FileInputStream in = new FileInputStream(origen);
                FileOutputStream out = new FileOutputStream(destino);
                // Usamos un buffer para la copia
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0)
                {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
            catch (IOException ioe) {ioe.printStackTrace();}
        } 
        else {System.out.println("NO existe la imagen");}
	}
	
	
	
	
	/*
	 * 14. Un pedido tiene las siguientes características:
	 * 		La descripción, un objeto de la clase String.
	 * 		El número de unidades, un dato del tipo primitivo int
	 * 		El precio, un dato de tipo double.
	 * Realizar un programa que guarde al menos 3 pedidos en un fichero binario “pedidos.dat”
	 * y visualizar que los datos se han guardado correctamente. 
	 * (tendremos un array con las 3 descripciones, otro con 3 número de unidades y otro con tres precios).
	 */
	public static void Ejer14()
	{
		File fichero = new File("FichData.dat");
		DataOutputStream dataOS;
		try
		{
			dataOS = new DataOutputStream(new FileOutputStream(fichero));
		
			String descripcion[] = {"producto1", "producto2", "producto3"};
			int unidades[]  = {14, 15, 13};
			double precio[] = {12.3, 34.5, 28.9};
			for (int i=0; i<descripcion.length; i++)
			{
				dataOS.writeUTF(descripcion[i]);
				dataOS.writeInt(unidades[i]);  
				dataOS.writeDouble(precio[i]);
			}
			dataOS.close();
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	public static void Ejer14_1()
	{
		File fichero = new File("FichData.dat");
		DataInputStream dataIS;
		try {
			dataIS = new DataInputStream(new FileInputStream(fichero));
			String d;
			int u;
			double p;
			try
			{
			    while (true)
			    {
			        d = dataIS.readUTF(); 
			        u = dataIS.readInt(); 
			        p = dataIS.readDouble(); 
			        System.out.println("Descripcion: " + d + ", unidades: " + u+ ", precio: " + p);        
			    }
		    }
			catch (EOFException eo)		{eo.printStackTrace();}
			dataIS.close();
		}
		catch (FileNotFoundException e)	{e.printStackTrace();} 
		catch (IOException e)			{e.printStackTrace();}
   }
	
	
	
	
	
	
	
}