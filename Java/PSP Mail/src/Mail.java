import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/*
1. Solicitar Credenciales al Usuario en la Línea de Comandos
El programa debe solicitar al usuario que introduzca su dirección de correo de Gmail y su contraseña de
forma segura (preferiblemente sin que la contraseña se muestre en pantalla).

2. Leer la Lista de Destinatarios desde un Archivo
El programa debe leer los correos electrónicos almacenados en el archivo Clientes.txt, guardando cada
uno en una lista de destinatarios.
	- Usa BufferedReader para leer el archivo línea por línea.
	- Almacena las direcciones en una lista (ArrayList<String>).
	- Asegúrate de manejar posibles errores en la lectura del archivo

3. Leer el Mensaje desde un Archivo
El programa también debe leer el contenido del archivo Mensaje.txt, almacenando el mensaje en una
variable.
	- Usa StringBuilder para concatenar todas las líneas del archivo en una sola variable.
	- Asegúrate de manejar posibles excepciones en la lectura del archivo

4. Configurar los Parámetros de Gmail
Antes de enviar los correos, el programa debe configurar los parámetros del servidor SMTP de Gmail.
	- Usa la clase Properties para definir los ajustes del servidor SMTP.
	- Configura correctamente el host, el puerto, la autenticación y la seguridad SSL

5. Enviar Correos Electrónicos
El programa debe recorrer la lista de destinatarios y enviar el mensaje a cada uno de ellos utilizando JavaMail API.
	- Usa la clase MimeMessage para construir el correo.
	- Usa Transport.send() para enviarlo.
	- Incluye una copia oculta (BCC) al remitente para verificar el envío.
	- Muestra en la terminal si el correo fue enviado correctamente o si hubo un error
*/

public class Mail
{
	public static Scanner input;
	
	public static String userAddress, userPass;
	
	public static void solicitarCredenciales()
	{
		// Pedir al usuario que introduzca su dirección de correo.
		// Pedir al usuario que introduzca su contraseña.
		
		System.out.print("Introduce tu dirección de correo: ");
		userAddress = input.nextLine();
		System.out.print("Introduce tu contraseña: ");
		userPass = input.nextLine();
	}
	
	
	public static List<String> leerDestinatarios(String archivo)
	{
		// Leer cada línea del archivo y guardarla en una lista.
		List<String> list = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
		{
			String line;
			while ((line=br.readLine())!=null)
			{
				if (line.contains("@") && line.contains("."))
				{
					list.add(line);
					System.out.println("Dirección encontrada: "+line);
				}
				else {System.err.println("Error. Dirección no válida: "+line);}
			}
		}
		catch (FileNotFoundException e)	{System.err.println("Error. No se encontró el fichero.");}
		catch (IOException e)			{e.printStackTrace();}
		return list;
	}
	
	
	public static String leerMensaje(String archivo)
	{
		// Leer todas las líneas del archivo y devolver el mensaje como una cadena de texto.
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
		{
			String line;
			while ((line=br.readLine())!=null)
			{
				sb.append(line+"\n");
			}
		}
		catch (FileNotFoundException e)	{System.err.println("Error. No se encontró el fichero.");}
		catch (IOException e)			{e.printStackTrace();}
		return sb.toString();
	}
	
	
	public static Properties configurarServidorSMTP()
	{
		// Configurar los parámetros del servidor SMTP de Gmail.
		Properties propiedadesSMTP = null;
		return propiedadesSMTP;
	}
	
	
	public static void enviarCorreo(String remitente, String clave, List<String> destinatarios, String mensaje)
	{
		// Crear y enviar el correo a cada destinatario de la lista
		for (int i=0; i<destinatarios.size(); i++)
		{
			destinatarios.get(i);
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		input = new Scanner(System.in);
		
		solicitarCredenciales();
		List<String> listaDestinatarios = leerDestinatarios("src/Clientes.txt");
		String mensaje = leerMensaje("src/Mensaje.txt");
		
		enviarCorreo(userAddress, userPass, listaDestinatarios, mensaje);
		
		input.close();
	}
	
}
