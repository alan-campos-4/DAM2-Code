package ej2;

import info.General;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServidor
{
	/* Posibles operaciones que se pueden realizar en la Calculadora Remota. */
	public enum Operacion
	{
		SUMA,
		RESTA,
		MULTIPLICA,
		DIVIDE,
	}
	/* Devuelve true si la operacion dada es válida. */
	public static boolean operacionValida(String test)
	{
	    for (Operacion o : Operacion.values())
	    {
	        if (o.name().equals(test))	{return true;}
	    }
	    return false;
	}
	
	
	
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
			ServerSocket SS2 = new ServerSocket(General.PortCalculadora);
			BufferedReader in;
			PrintWriter out;
			General.listening(SS2.getLocalPort());
			
			while (true)
			{
				S2 = SS2.accept();
				General.connected();
				
				in = new BufferedReader(new InputStreamReader(S2.getInputStream()));
				String command = in.readLine();
				String[] info = command.split(" ");
				if (info.length==3)
				{
					try
					{
						int n1 = Integer.parseInt(info[1]);
						int n2 = Integer.parseInt(info[2]);
						
						if (operacionValida(info[0]))
						{
							double result = 0;
							Operacion op = Operacion.valueOf(info[0]);
							switch(op)
							{
								case SUMA:			{result = n1 + n2;}	break;
								case RESTA:			{result = n1 - n2;}	break;
								case MULTIPLICA:	{result = n1 * n2;}	break;
								case DIVIDE:
								{
									if (n2==0)
										{throw new IllegalArgumentException("Error. División por cero.");}
									else
										{result = (double)n1 / n2;}
								}
								break;
							}
							
							out = new PrintWriter(S2.getOutputStream(), true);
							System.out.println("El resultado es "+result+".");
						}
					}
					catch (NumberFormatException e) {System.out.println("Error. Tipo de valor incorrecto.");}
				}
				else {System.out.println("Error. Número de parámetros incorrecto.");}
				
				break;
			}
			
			in.close();
			//out.close();
			S2.close();
			SS2.close();
		}
		catch (IOException e)	{e.printStackTrace();}
	}
}

