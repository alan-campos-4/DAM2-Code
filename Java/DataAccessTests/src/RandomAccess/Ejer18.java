/*
 * 18. Consulta
 * Crea un programa que consulte los datos de un empleado del fichero aleatorio.
 * El programa se ejecutará desde la línea de comandos y debe recibir un identificador de empleado.
 * Si el empleado existe se visualizarán los datos, si no existe se visualizará un mensaje indicándolo.
 */
package RandomAccess;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Ejer18
{	
	public static int findID(RandomAccessFile file, String arg)
	{
		int posicion = 0, id;
		boolean found = false;
		
		try
		{
			do {
				file.seek(posicion);
				id = file.readInt();	//obtengo id de empleado
				
				if(arg.equals(String.valueOf(id)))
				{
					found = true;
					break;
				}
				posicion += 36; //cada empleado ocupa 36 bytes
				
			} while ( (!found) || (file.getFilePointer()!=file.length()) );
			
			if (found)	return posicion;
			else		return -1;
		}
		catch (IOException e)	{return -1;}
	}
	
	public static int argNum = 1;
	public static void main(String[] args)
	{
		if (args.length == argNum)
		{
			try
			{
				File fichero = new File("AleatorioEmple.dat");
				RandomAccessFile raf = new RandomAccessFile(fichero, "r");
				
				int posicion = findID(raf, args[0]);
				
				raf.close();
				
				if (posicion!=-1)
					{System.out.println("  El empleado está en la posicion "+posicion+".");}
				else
					{System.out.println("  El empleado no existe.");}
			}
			catch(FileNotFoundException e)	{System.out.println("  No se ha encontrado el archivo.");}
			catch(EOFException e)			{System.out.println("  Final del fichero.");}
			catch(IOException e)			{System.out.println("  El fichero no se puede leer.");}
		}
		else
		{
			System.out.println("  Debes introducir "+argNum+" argumentos.");
		}
	}
}
