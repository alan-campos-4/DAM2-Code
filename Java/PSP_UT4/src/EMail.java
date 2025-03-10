import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
1. Solicitar Credenciales al Usuario en la Línea de Comandos
El programa debe solicitar al usuario que introduzca su dirección de correo de Gmail y 
su contraseña de forma segura (preferiblemente sin que la contraseña se muestre en pantalla).

2. Leer la Lista de Destinatarios desde un Archivo
El programa debe leer los correos electrónicos almacenados en el archivo Clientes.txt, guardando 
cada uno en una lista de destinatarios.
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
El programa debe recorrer la lista de destinatarios y enviar el mensaje a cada uno de ellos 
utilizando JavaMail API.
	- Usa la clase MimeMessage para construir el correo.
	- Usa Transport.send() para enviarlo.
	- Incluye una copia oculta (BCC) al remitente para verificar el envío.
	- Muestra en la terminal si el correo fue enviado correctamente o si hubo un error
*/


public class EMail
{
	public static String userAddress, userPass;
	public final static String ficheroClientes =	"resources/Clientes.txt";
	public final static String ficheroMensaje =		"resources/Mensaje.txt";
	public final static String ficheroPropiedades =	"resources/Propiedades.txt";
	
	
	// Pedir al usuario que introduzca su dirección de correo y contraseña.
	public static void solicitarCredenciales()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce tu dirección de correo: ");
		userAddress = input.nextLine();
		System.out.println("Introduce tu contraseña: ");
		userPass = input.nextLine();
		
		input.close();
	}
	
	
	// Leer cada línea del archivo y guardarla en una lista.
	public static List<String> leerDestinatarios(String archivo) throws FileNotFoundException, IOException
	{
		List<String> list = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
		{
			String line;
			while ((line=br.readLine())!=null)
			{
				if (line.contains("@") && line.contains("."))
				{
					list.add(line);
					//System.out.println("Dirección encontrada: "+line);
				}
				else {System.err.println("Error. Dirección no válida: "+line);}
			}
		}
		return list;
	}
	
	
	// Leer todas las líneas del archivo y devolver el mensaje como una cadena de texto.
	public static String leerMensaje(String archivo) throws FileNotFoundException, IOException
	{
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
		{
			String line;
			while ((line=br.readLine())!=null)
			{
				sb.append(line+"\n");
			}
		}
		return sb.toString();
	}
	
	
	// Configurar los parámetros del servidor SMTP de Gmail.
	public static Properties configurarServidorSMTP() throws FileNotFoundException, IOException
	{
		Properties propiedadesSMTP = new Properties();
		try (FileReader fr = new FileReader(ficheroPropiedades))
		{
			propiedadesSMTP.load(fr);
			//System.out.println(propiedadesSMTP.toString());
		}
		return propiedadesSMTP;
	}
	
	
	// Crear y enviar el correo a cada destinatario de la lista.
	public static void enviarCorreo(String remitente, String clave, 
			List<String> destinatarios, String mensaje) 
					throws FileNotFoundException, IOException, MessagingException
	{	
		//Obtiene las propiedades del fichero y crea la sesion y el mensaje.
		Properties props = configurarServidorSMTP();
		Session session = Session.getInstance(props, new Authenticator()
		{
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(remitente, clave);
		    }
		});
		MimeMessage msg = new MimeMessage(session);
		
		//Guarda todos los destinatarios como array.
		Address[] recipients = new InternetAddress[destinatarios.size()];
		for (int i=0; i<destinatarios.size(); i++)
		{
			recipients[i] = new InternetAddress(destinatarios.get(i));
		}
		
		//Pasa los datos recibidos al mensaje.
		msg.setFrom(remitente);
		msg.setRecipients(Message.RecipientType.TO, recipients);
		msg.setSubject("JavaMail hello world example");
		msg.setSentDate(new Date());
		msg.setText("Hello, world!\n");
		
		//Envía el mensaje.
		Transport.send(msg, remitente, clave);
	}
	
	
	
	
	public static void main(String[] args)
	{
		solicitarCredenciales();
		
		List<String> listaDestinatarios;
		String mensaje;
		try
		{
			listaDestinatarios = leerDestinatarios(ficheroClientes);
			mensaje = leerMensaje(ficheroMensaje);
			
			enviarCorreo(userAddress, userPass, listaDestinatarios, mensaje);
		}
		catch (FileNotFoundException e)	{System.err.println("Error de archivo.\n"+e.getMessage());}
		catch (IOException e)			{e.printStackTrace();}
		catch (MessagingException e)	{e.printStackTrace();}
	}
	
	
}

