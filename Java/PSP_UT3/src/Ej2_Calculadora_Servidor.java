import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/***** EJERCICIO 2: Calculadora Remota *****
 PUNTOS CLAVE
	1. Comunicación de Comandos:
		o El cliente enviará una cadena con el formato:
		  OPERACION OPERANDO1 OPERANDO2
		  Ejemplos:
		  	 SUMA 4 5
		  	 RESTA 10 3
		  	 MULTIPLICA 7 2
		  	 DIVIDE 9 3
	2. Servidor:
		o Recibe la cadena y la parsea (divide) en varias partes usando, por ejemplo,
			String.split(" ").
		o Realiza la operación correspondiente:
			 SUMA -> op1 + op2
			 RESTA -> op1 - op2
			 etc.
		o Devuelve el resultado como cadena.
		o Debe pensar en casos especiales, por ejemplo, división entre cero.
	3. Cliente:
		o Pide la operación por consola o la tiene codificada.
		o Envía el texto al servidor, lee la respuesta y la muestra.
	4. Consideraciones:
		o Validar que se reciben 3 partes de la cadena (operación y dos números).
		o Manejar la conversión de String a double o int.
		o Controlar posibles excepciones como NumberFormatException.
		o Manejar la respuesta del servidor y errores (ej. “Error: división entre cero”).
		o Cerrar los recursos.
 PISTAS TEÓRICAS
		 El servidor seguirá usando un ServerSocket.
		 Para cada conexión (vía accept()), se tendrá un Socket.
		 Lectura: BufferedReader + readLine() para recibir el comando.
		 Escritura: PrintWriter + println() para enviar el resultado.
*/

public class Ej2_Calculadora_Servidor
{
	public static void main(String[] args)
	{
		// 1. Abrir un ServerSocket en un puerto (p.ej. 5001).
		// 2. Aceptar conexiones en un bucle.
		// 3. Leer el comando (p.ej. "SUMA 4 5").
		// 4. Separar la cadena y extraer la operación y operandos.
		// 5. Realizar la operación (suma, resta, etc.).
		// 6. Enviar el resultado al cliente.
		// 7. Manejar excepciones y cerrar flujos/sockets.
		
		try (ServerSocket SS2 = new ServerSocket(5001))
		{
			Socket S2;
			BufferedReader in;
			PrintWriter out;
			System.out.println("Listening to port "+SS2.getLocalPort()+"...");
			
			while (true)
			{
				S2 = SS2.accept();
				System.out.println("Client connected.");
				
				in = new BufferedReader(new InputStreamReader(S2.getInputStream()));
				out = new PrintWriter(S2.getOutputStream(), true);
				String command = in.readLine();
				String[] info = command.split(" ");
				
				if (info.length==3)
				{
					int n1 = Integer.parseInt(info[1]);
					int n2 = Integer.parseInt(info[2]);
					
					double result = 0.0;
					String op = info[0].replaceAll("","").replaceAll("\\s+","").trim();
					
					if (op.equals("SUMA"))
					{
						result = n1 + n2;
						System.out.println("El resultado es "+result+".");
					}
					else if (op.equals("RESTA"))
					{
						result = n1 - n2;
						System.out.println("El resultado es "+result+".");
					}
					else if (op.equals("MULTIPLICA"))
					{
						result = n1 * n2;
						System.out.println("El resultado es "+result+".");
					}
					else if (op.equals("DIVIDE"))
					{
						if (n2==0)	{throw new IllegalArgumentException();}
						else
						{
							result = (double)n1 / n2;
							System.out.println("El resultado es "+result+".");
						}
					}
					else {System.out.println("Error. Operación no válida."); break;}
				}
				else {System.out.println("Error. Número de parámetros incorrecto."); break;}
			}
			
			in.close();
			out.close();
			S2.close();
		}
		catch (IOException e)				{e.printStackTrace();}
		catch (NumberFormatException e)		{System.out.println("Error. Tipo de valor incorrecto.");}
		catch (IllegalArgumentException e)	{System.out.println("Error. División por cero.");}
	}
}

