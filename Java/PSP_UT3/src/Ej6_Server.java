import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/***** EJERCICIO 6: Transmisión de Archivos Pequeños “Photo Sender” *****
Objetivo:
Desarrollar una aplicación para transferir archivos (por ejemplo, fotografías) desde un servidor a un
cliente. El cliente solicita un nombre de archivo, y el servidor lo envía en modo binario.

	1. Servidor de Archivos:
		o Continúa con el patrón de ServerSocket para escuchar.
		o El cliente envía el nombre del archivo que desea (p. ej., “foto1.jpg”).
		o El servidor busca ese archivo en su sistema de ficheros (por ejemplo, en la misma carpeta
		  donde se ejecuta o en otra ruta especificada).
		o Si el archivo existe, lo lee en binario (usando FileInputStream, BufferedInputStream)
		  y lo transmite al cliente a través del OutputStream.
		o Si no existe, podría enviar un mensaje de error o simplemente no enviar nada.
	2. Cliente de Archivos:
		o Se conecta con un Socket.
		o Pide al usuario el nombre del archivo que desea.
		o Envía ese nombre al servidor (como cadena).
		o Recibe los bytes del archivo y los escribe en un FileOutputStream local, para guardarlo
		  con un nombre (por ejemplo, “descargado_foto1.jpg”).
		o Mostrar mensajes para indicar que la descarga finalizó con éxito.
	3. Consideraciones:
		o Modo binario: a diferencia de los ejercicios anteriores (principalmente de texto), aquí se
		  transmiten bytes sin interpretación de caracteres.
		o Aun así, el paso de un nombre de archivo se puede hacer en modo texto (con
		  PrintWriter o BufferedWriter). Lo importante es que el contenido del archivo se
		  envíe en binario.
		o El tamaño del archivo puede desconocerse de antemano. El cliente debe leer en un bucle
		  hasta que se retorne -1 (indicando que no hay más bytes que recibir).
		o Cerrar flujos para evitar archivos corruptos.
	4. Pistas Teóricas:
		o Lectura del archivo en el servidor:
			FileInputStream fis = new FileInputStream(nombreArchivo);
			BufferedInputStream bis = new BufferedInputStream(fis);
		o Envío al cliente:
			OutputStream out = socket.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesLeidos;
			while ((bytesLeidos = bis.read(buffer)) != -1) {
				out.write(buffer, 0, bytesLeidos);
			}
		o Recepción en el cliente y guardado:
			InputStream in = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream("descargado_" + nombreArchivo);
			...
		o Comprobar la existencia del archivo en el servidor
			(new File(nombreArchivo).exists()).
 */

public class Ej6_Server
{
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket (puerto 5005).
		// 2. Aceptar conexiones (accept()).
		// 3. Leer (en modo texto) el nombre del archivo solicitado.
		// 4. Buscar el archivo en el sistema local.
		// 5. Si existe, abrir FileInputStream y enviar su contenido binario.
		// 6. Cerrar flujos y socket.
		
		try (ServerSocket SS6 = new ServerSocket(5005))
		{
			Socket S6;
			BufferedReader in;
			//PrintWriter out;
			System.out.println("Listening to port "+SS6.getLocalPort()+"...");
			
			while (true)
			{
				S6 = SS6.accept();
				System.out.println("Client connected.");
				
				in = new BufferedReader(new InputStreamReader(S6.getInputStream()));
				//out = new PrintWriter(S6.getOutputStream(), true);
				
				String filepath = in.readLine().replaceAll("","").replaceAll("\\s+","").trim();
				File file = new File(filepath);
				System.out.println(filepath);
				
				if (file.exists())
				{
					System.out.println("File "+filepath+" has been found.");
					
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					OutputStream out = S6.getOutputStream();
					
					System.out.println("Reading.");
					byte[] buffer = new byte[4096];
					int bytesLeidos;
					while ((bytesLeidos = bis.read(buffer)) != -1)
					{
						out.write(buffer, 0, bytesLeidos);
						System.out.println(bytesLeidos+" bytes read.");
					}
					bis.close();
				}
				else
				{
					System.out.println("The file doesn't exist.");
					break;
				}
			}
			
			in.close();
			//out.close();
			S6.close();
		}
		catch (NumberFormatException e)	{System.out.println("Error. Tipo de valor incorrecto.");}
		//catch (SocketException e)		{System.out.println("Error. Se ha perdido la conexión con el socket.");}
		catch (IOException e)			{e.printStackTrace();}
		
	}
}

