package RandomAccess;
import java.io.*;


public class RandomFileWrite
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			File fichero = new File("src/RandomAccess/AleatorioEmple.dat");
			if (fichero.exists()) {fichero.delete();}
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			
			String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY"};
			int dep[] = {10, 20, 10, 10, 30, 30, 20};
			Double salario[] = {1000.45, 2400.60, 3000.0, 1500.56,2200.0, 1435.87, 2000.0};
			
			StringBuffer buffer = null;
			int n = apellido.length;//numero de elementos del array
			for (int i=0; i<n; i++)
			{
				file.writeInt(i+1); //uso i+1 para identificar empleado
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(10);
				file.writeChars(buffer.toString());
				file.writeInt(dep[i]); //insertar departamento
				file.writeDouble(salario[i]);//insertar salario
			}
			file.close();
		}
		catch(FileNotFoundException e)	{System.out.println("  No se ha encontrado el archivo.");}
	}
}
