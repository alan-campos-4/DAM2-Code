import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

/*
---
*/

public class FTP
{
	public static final String server = "ftp.dlptest.com";
	public static final String user = "dlpuser";
	public static final String password = "rNrKYTX9g7z3RgJRmxWuGHbeu";
	
	public static void main(String[] args)
	{
		System.out.println(
				"==========================================\n" + 
				"          Cliente FTP en Java\n" + 
				"==========================================");
		
		System.out.println("Conectando con el servidor FTP...");
		
		FTPClient ftp = new FTPClient();
		FTPClientConfig config = new FTPClientConfig();
		// config.setXXX("); // change required options
		// for example config.setServerTimeZoneId("Pacific/Pitcairn")
		ftp.configure(config);
		boolean error = false;
		try
		{
			ftp.connect(server);
			System.out.println("Connected to " + server + ".");
			System.out.print(ftp.getReplyString());
			
			ftp.login(user, password);
			FTPListParseEngine engine = ftp.initiateListParsing("directory");
			
			System.out.println("Conexión establecida correctamente.");
			System.out.println("Menú de opciones:\n");
			System.out.println("1. Listar archivos y directorios.");
			System.out.println("2. Crear una carpeta.");
			System.out.println("3. Crear un archivo en el servidor.");
			System.out.println("4. Descargar un fichero.");
			System.out.println("5. Salir.");
			System.out.println("\nSeleccione una opción: ");
			
			while (engine.hasNext())
			{
				FTPFile[] files = engine.getNext(25); // "page size" you want
				// do whatever you want with these files, display them, etc.
				// expensive FTPFile objects not created until needed.
			}
			
			// After connection attempt, you should check the reply code to verify
			// success.
			int reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply))
			{
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			// ... // transfer files
			ftp.logout();
		} 
		catch (IOException e)
		{
			error = true;
			e.printStackTrace();
		}
		finally
		{
			if (ftp.isConnected())
			{
				try {
					ftp.disconnect();
				}
				catch (IOException e) {}
			}
			System.exit(error ? 1 : 0);
		}
	}
}
