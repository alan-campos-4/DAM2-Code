package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServidor
{
	/* 
	//Posibles operaciones que se pueden realizar en la Calculadora Remota.
	public enum Operacion
	{
		SUMA,
		RESTA,
		MULTIPLICA,
		DIVIDE,
	}
	// Devuelve true si la operacion dada es válida.
	public static boolean operacionValida(String test)
	{
	    for (Operacion o : Operacion.values())
	    {
	        if (o.name().toString().toUpperCase().equals(test))	{return true;}
	    }
	    return false;
	}//*/
	
	
	
	public static void main(String[] args)
	{
		// 1. Abrir un ServerSocket en un puerto (p.ej. 5001).
		// 2. Aceptar conexiones en un bucle.
		// 3. Leer el comando (p.ej. "SUMA 4 5").
		// 4. Separar la cadena y extraer la operación y operandos.
		// 5. Realizar la operación (suma, resta, etc.).
		// 6. Enviar el resultado al cliente.
		// 7. Manejar excepciones y cerrar flujos/sockets.
		
		try
		{
			Socket S2;
			ServerSocket SS2 = new ServerSocket(5001);
			BufferedReader in;
			PrintWriter out = null;
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
					try
					{
						int n1 = Integer.parseInt(info[1]);
						int n2 = Integer.parseInt(info[2]);
						
						double result = 0.0;
						String op = info[0].replaceAll("","").replaceAll("\\s+","");
						System.out.println("-"+op);
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
						else {System.out.println("Error. Operación no válida.");}
					}
					catch (NumberFormatException e)		{System.out.println("Error. Tipo de valor incorrecto.");}
					catch (IllegalArgumentException e)	{System.out.println("Error. División por cero.");}
				}
				else {System.out.println("Error. Número de parámetros incorrecto.");}
				
				break;
			}
			
			in.close();
			out.close();
			S2.close();
			SS2.close();
		}
		catch (IOException e)	{e.printStackTrace();}
	}
}

