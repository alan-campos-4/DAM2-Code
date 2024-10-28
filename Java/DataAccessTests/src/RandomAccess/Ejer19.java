package RandomAccess;
/*
 * 19. Inserción.
 * Crea un programa Java que inserte datos en el fichero aleatorio. 
 * El programa se ejecutará desde la línea de comandos y debe recibir 4 parámetros: 
 * 	identificador de empleado, apellido, departamento y salario. 
 * Antes de insertar se comprobará si el identificador existe, 
 * en ese caso se debe visualizar un mensaje indicándolo; si no existe se deberá insertar.
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Ejer19
{
	public static int argNum = 4;
	public static void main(String args[])
	{
		if (args.length == argNum)
		{
			try
			{
				File fichero = new File("AleatorioEmple.dat");
				RandomAccessFile file = new RandomAccessFile(fichero, "rw");
				
				String apellido;
				StringBuffer buffer = null;
				
				int posicion = Ejer18.findID(file, args[0]);
				
				if (posicion==-1)
				{
					apellido =	args[1];
					buffer = new StringBuffer(apellido);
					buffer.setLength(10);
					
					file.seek(file.length());
					file.writeInt(Integer.parseInt(args[0]));
					file.writeChars(buffer.toString());
					file.writeInt(Integer.parseInt(args[2]));
					file.writeDouble(Double.parseDouble(args[3]));
					System.out.println("  El empleado se ha guardado.");
				}
				else
					{System.out.println("  El id de empleado ya existe.");}
				
				file.close();
			}
			catch(FileNotFoundException e)	{System.out.println("  No se ha encontrado el archivo.");}
			catch(NumberFormatException e)	{System.out.println("  No se han podido guardar los valores.");}
			catch(EOFException e)			{System.out.println("  Final del fichero.");}
			catch(IOException e)			{System.out.println("  El fichero no se puede leer.");}
		}
		else
		{
			System.out.println("  Debes introducir "+argNum+" argumentos.");
		}
	}
}