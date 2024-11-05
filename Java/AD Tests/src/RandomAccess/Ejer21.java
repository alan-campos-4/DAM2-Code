package RandomAccess;
/*
 * 21. Borrado.
 * Crea un programa Java que al ejecutarlo desde la línea de comandos 
 * reciba un identificador de empleado y lo borre. 
 * Se hará un borrado lógico marcando el registro con la siguiente información: 
 *   el identificador será igual a -1, el apellido será igual al identificador que se borra, 
 *   y el departamento y salario serán 0.
 */
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Ejer21
{
	public static int argNum = 1;
	public static RandomAccessFile raf;
	
	public static int getPositionFromID(String arg) throws IOException, EOFException
	{
		int posicion = 0, id;
		boolean found = false;
		
		do {
			raf.seek(posicion);
			id = raf.readInt();	//obtengo id de empleado
			
			if(arg.equals(String.valueOf(id)))
			{
				found = true;
				break;
			}
			posicion += 36; //cada empleado ocupa 36 bytes
			
		} while ( (!found) || (raf.getFilePointer()!=raf.length()) );
		
		if (found)	return posicion;
		else		return -2;
	}
	
	public static void main(String args[])
	{
		if (args.length == argNum)
		{
			try
			{
				raf = new RandomAccessFile(new File("AleatorioEmple.dat"), "rw");
				
				int posicion = getPositionFromID(args[0]);
				
				if (posicion==-2)
				{
					raf.seek(posicion);
					int id = raf.readInt();
					raf.writeInt(-1);
					raf.writeChars(Integer.toString(id));
					raf.writeInt(0);
					raf.writeDouble(0);
					System.out.println("  El empleado se ha borrado.");
				}
				else
					{System.out.println("  El id de empleado no existe.");}
				
				raf.close();
			}
			catch(EOFException e)	{System.out.println("  Final del fichero.");}
			catch(IOException e)	{System.out.println("  El fichero no se puede leer.");}
		}
		else
			{System.out.println("  Debes introducir "+argNum+" argumento.");}
	}
}