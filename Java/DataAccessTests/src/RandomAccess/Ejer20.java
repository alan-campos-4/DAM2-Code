package RandomAccess;
/*
 * 20. Modificación.
 * Crea un programa Java que reciba desde la línea de comandos un identificador de empleado y un importe. 
 * Se debe realizar la modificación del salario. 
 * La modificación consistirá en sumar al salario del empleado el importe introducido. 
 * El programa debe visualizar el apellido, el salario antiguo y el nuevo. 
 * Si el identificador no existe se visualizará mensaje indicándolo.
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Ejer20
{
	public static int findID(RandomAccessFile file, String arg) throws IOException
	{
		int posicion = 0, id;
		boolean found = false;
		
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
	
	public static int argNum = 2;
	public static void main(String args[])
	{
		if (args.length == argNum)
		{
			try
			{
				File fichero = new File("AleatorioEmple.dat");
				RandomAccessFile file = new RandomAccessFile(fichero, "rw");
				
				double salario, nuevosalario;
				int id, dep;
				String apellido;
				
//				Scanner in = new Scanner(System.in);
//				System.out.print("Introduce ID a modificar: ");
//				args[0] = in.nextLine();
//				System.out.print("Introduce valor para modificar: ");
//				args[1] = in.nextLine();
				
				int posicion = findID(file, args[0]);
				
//				System.out.println("pos: "+posicion);
				
				if (posicion!=-1)
				{
					nuevosalario = 	Double.parseDouble(args[1]);
					
					file.seek(posicion);
					id =		file.readInt();
					apellido =	file.readUTF();
					dep =		file.readInt();
					salario =	file.readDouble();
					
					file.writeDouble(salario+nuevosalario);
					
					System.out.println("  Se ha modificado el empleado "+id+": "+
							salario+"->"+(salario+nuevosalario));
				}
				else
					{System.out.println("  El empleado no existe.");}
				
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
