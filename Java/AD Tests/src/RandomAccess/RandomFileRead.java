package RandomAccess;
import java.io.*;


public class RandomFileRead
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			File fichero = new File("src/RandomAccess/AleatorioEmple.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "r"); //declara el fichero de acceso aleatorio
			
			int id, dep, posicion = 0;
			double salario;
			char apellido[] = new char[10], aux;
			
			do {
				
				file.seek(posicion);	//nos posicionamos al principio
				id = file.readInt();	//obtengo id de empleado
				for (int i=0; i<10; i++)
				{
					aux = file.readChar();
					apellido[i] = aux;
				}
				
				String apellidos = new String(apellido);
				dep = file.readInt();			//obtengo dep
				salario = file.readDouble();	//obtengo salario
				
				if (id > 0)
				{
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
						id, apellidos, dep, salario);
				}
				posicion = posicion + 36;	//me posiciono para el sig empleado, cada empleado ocupa 36 bytes
				
			} while(file.getFilePointer() != file.length());
			
			file.close();
		}
		catch(FileNotFoundException e)	{System.out.println("  No se ha encontrado el archivo.");}
	}
}