import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


public class FTP
{
	public static Scanner input = new Scanner(System.in);
	public static final String server = "ftp.dlptest.com";
	public static final String user = "dlpuser";
	public static final String password = "rNrKYTX9g7z3RgJRmxWuGHbeu";
	public static FTPClient ftp;
	public static FTPClientConfig config;
	
	
	public static void main(String[] args)
	{
		System.out.println(
				"==========================================\n" + 
				"          Cliente FTP en Java\n" + 
				"==========================================");
		
		System.out.println("Conectando con el servidor FTP...");
		
		ftp = new FTPClient();
		try
		{
			ftp.connect(server);
			ftp.login(user, password);
			System.out.print(ftp.getReplyString());
			
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode()))
			{
				ftp.disconnect();
				System.err.println("No se pudo conectar con el servidor.");
				System.exit(1);
			}
			else
			{
				System.out.println("Conexión establecida correctamente.");
				int op = 0;
				do
				{
					try {
						System.out.println("\n\nMenú de opciones:\n");
						System.out.println("1. Listar archivos y directorios.");
						System.out.println("2. Crear una carpeta.");
						System.out.println("3. Crear un archivo en el servidor.");
						System.out.println("4. Descargar un fichero.");
						System.out.println("5. Salir.");
						System.out.print("\nSeleccione una opción: ");
						op = input.nextInt();
						input.nextLine();
						
						switch (op)
						{
							case 1: {listarArchivos();}	break;
							case 2: {crearCarpeta();}	break;
							case 3: {crearArchivo();}	break;
							case 4: {descargarArchivo();}	break;
							case 5: {System.out.println("Cerrando conexión FTP...");}	break;
							default: {System.out.println("Opción no válida.");}	break;
						}
					}
					catch (InputMismatchException e) {System.out.println("Opción no válida.");}
				}
				while (op!=5);
			}
		}
		catch (IOException e) {e.printStackTrace();}
		finally
		{
			try
			{
				if (ftp.logout())
				{
					ftp.disconnect();
					System.out.println("Conexión cerrada.");
				}
			}
			catch (IOException e) {}
		}
	}
	
	
	
	
	//Recorre los elementos del servidor y los muestra por pantalla.
	public static void listarArchivos() throws IOException
	{
		//Obtiene todos los elementos como un array de strings.
		FTPFile[] files = ftp.listFiles();
		for (FTPFile file : files)
		{
			//Por cada elemento muestra si es directorio o fichero.
			if (file.isDirectory())
				{System.out.println("[DIR] " + file.getName());} 
			else
				{System.out.println("[FILE] " + file.getName());}
		}
	}
	
	
	
	
	//Crear la carpeta con nombre dado por consola en el servidor.
	public static void crearCarpeta() throws IOException
	{
		//Lee el nombre de la carpeta.
		System.out.print("Introduce la carpeta que quieras crear: "); 
		String path = input.nextLine();
		
		//Si no existe, intenta crearlo.
    	boolean created = ftp.makeDirectory(path);
    	if (created)
    	{
    		System.out.println("Se creó el directorio: "+path+".");
    	}
    	else {System.out.println("No se pudo crear el directorio.");}
	}
	
	
	
	
	//Sube un archivo dado del equipo local al servidor
	public static void crearArchivo() throws IOException
	{
		//Recibe el nombre del archivo por consola.
		System.out.print("Introduce el fichero que quieras crear: ");
		String localFile = input.nextLine();
		//Obtiene el nombre del fichero en el servidor.
		String remoteFile = getFileNameFromPath(localFile);
		
		try
		{
			FileInputStream inputStream = new FileInputStream(new File(localFile));
			boolean success = ftp.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (success)
            	{System.out.println("Se ha subido el archivo "+remoteFile+".");}
            else
            	{System.out.println("No se ha podido subir el fichero.");}
		}
		//Lanzada por el FileInputStream si no encuentra el archivo.
		catch (FileNotFoundException e) {System.out.println("El archivo no existe.");}
	}
	
	
	
	
	//Descarga un archivo dado del servidor al equipo local.
	public static void descargarArchivo() throws IOException
	{
		//Recibe el nombre del archivo por consola.
		System.out.print("Introduce el fichero que quieras descargar: ");
		String serverFile = input.nextLine();
		//Obtiene el nombre del fichero en el servidor.
		String downloadFile = getFileNameFromPath(serverFile);
		//Guarda el fichero en la carpeta de descargas del equipo local.
		downloadFile = "C:\\Users\\"+System.getProperty("user.name")+"\\Downloads\\"+downloadFile;
		
		try
		{
			FileOutputStream outputStream = new FileOutputStream(downloadFile);
			boolean success = ftp.retrieveFile(serverFile, outputStream);
			outputStream.close();
			if (success)
	        	{System.out.println("Se ha descargado el archivo en "+downloadFile+".");}
	        else
	        	{System.out.println("No se ha podido descargar el fichero.");}
		}
		//Lanzada por el FileOutpuStream si no encuentra el archivo.
		catch (FileNotFoundException e) {System.out.println("El archivo no existe.");}
	}
	
	
	
	//Recibe la ruta de un fichero y devuelve solo el nombre del fichero.
	public static String getFileNameFromPath(String path)
	{
		//Si contiene caracteres \, divide la cadena y devuelve el último elemento.
		int index = path.indexOf('\\');
		if (index!=-1)
		{
			String[] parts = path.split("\\\\");
			return parts[parts.length-1];
		}
		else return path;
	}
	
	
}

