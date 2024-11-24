package ej6;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Ejercicio 6 – Filtros – 2 ptos
 * 
 * Escribe un programa que lea las últimas cotizaciones que aparecen en la página 
 * 		http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201
 * y las guarde en un fichero de objetos (se guardará: el nombre de la empresa, 
 * la fecha de hoy (del sistema), la hora y el valor de la cotización). 
 * Crear la clase Cotización con los métodos: 
 * 		GrabarCotización (se hará desde la URL), 
 * 		LeerCotización (se mostrará todo el contenido del fichero) y 
 * 		VerCotización (día, hora).
 * Cada vez que se ejecute el programa se añadirán las nuevas cotizaciones al fichero.
 */

public class Ejercicio6
{
	public static class Cotizacion
	{
		//Archivo donde se guardarán las cotizaciones.
		File fichero;
		//URL de la página.
		String url = "https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201";
		
		public Cotizacion()
		{
			//Crea el fichero si no existe.
			fichero = new File("src/ej6/cotizaciones.dat");
		}
		
		//Guarda las nuevas cotizaciones al fichero.
		public void GrabarCotización()
		{
			//Variables para la lectura y escritura.
			String line, nombreEmpresa, cotizacion, hora;
			//Definición y formateo de la fecha actual.
			LocalDate fecha = LocalDate.now();
			
			try
			{
				//Clase URL que representa la página web a la que accedemos.
				//	creada a partir de URI porque el constructor URl está obsoleto 
				//	y fuerza (@SuppressWarnings("deprecation")).
				URI builder = URI.create(url);
				URL Url = builder.toURL();
				
	        	//Accede al contenido de la página web.
	        	BufferedReader br = new BufferedReader(new InputStreamReader(Url.openStream()));
	        	//Guarda las entradas en el fichero.
	        	DataOutputStream bw = new DataOutputStream(new FileOutputStream(fichero));
	            
	            //Recorre toda la página
	            while ((line = br.readLine()) != null)
	            {
	            	//Busca la primera columna de la tabla "listado_valores", llamada "primera"
	            	if (line.contains("<td class=\"primera\">"))
	            	{
	            		//Divide la parte de la línea que almacena el nombre de forma que: 
	            		//		... title="ACCIONA">ACCIONA</a></td>    ->    ACCIONA
	            		nombreEmpresa = line.substring(line.lastIndexOf("\">")+2, line.lastIndexOf("</a"));
	            		
	                    //Avanza a la siguiente línea, que almacena la cotización,
	            		line = br.readLine();
	                    //la divide de forma que:	<td>199,500</td>  ->  199,500
	                    //y sustituye la coma para que pueda ser convertida en double.
	                    cotizacion = line.substring(line.lastIndexOf("<td>")+4, line.lastIndexOf("</td>"));
	                    cotizacion = cotizacion.replace(',', '.');
	                    
	                    //Sigue leyendo hasta que encuentra la línea que almacena la hora,
	                    br.readLine();
	                    br.readLine();
	                    br.readLine();
	                    br.readLine();
	                    br.readLine();
	                    br.readLine();
	                    br.readLine();
	                    line = br.readLine();
	                    //la divide de forma que:	<td>13:31</td>  ->  13:31
	                    hora = line.substring(line.lastIndexOf("<td>")+4, line.lastIndexOf("</td"));
	                    
	                    //Guarda la cotización en el fichero
	                    bw.writeUTF(nombreEmpresa);
	                    bw.writeDouble(Double.parseDouble(cotizacion));
	                    bw.writeUTF(fecha.toString());
	                    bw.writeUTF(hora);
	            	}
	            }
	            bw.close();
	            br.close();
	            System.out.println("Cotizaciones guardadas");
	        }
	        //Lanzada por BufferedReader.readLine
			catch (IOException e)		{e.printStackTrace();}
		}
		
		//Muestra el contenido del fichero.
		public void LeerCotización()
		{
			try
			{
				String line;
				DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
				//Recorre el fichero y muestra la información de cada cotización.
				while ((line = dis.readUTF()) != null)
				{
					System.out.println("\nEmpresa: "+line);
				    System.out.println("  Cotización: "+dis.readDouble());
				    System.out.println("  Fecha:      "+dis.readUTF());
				    System.out.println("  Hora:       "+dis.readUTF());
				}
				dis.close();
			}
			//Lanzado al llegar al final del fichero.
			catch (EOFException e)			{System.out.println("\nFin del fichero.");}
			//Lanzado por FileInputSteam.
			catch (FileNotFoundException e)	{System.out.println("\tNo se encontró el fichero.");}
			//Lanzada por BufferedReader.readLine().
			catch (IOException e) 			{e.printStackTrace();}
		}
		
		//Busca una cotización por fecha y hora.
		public void VerCotización(String dateToFind, String timeToFind)
		{
			try
			{
				boolean found = false;
				double valor;
				String line, fecha, hora;
				DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
				while ((line = dis.readUTF()) != null && !found)
				{
					valor = dis.readDouble();
					fecha = dis.readUTF();
					hora = dis.readUTF();
					if (fecha.equals(dateToFind) && hora.equals(timeToFind))
					{
						found = true;
						System.out.println("\nEmpresa: "+line);
					    System.out.println("  Cotización: "+valor);
					    System.out.println("  Fecha:      "+fecha);
					    System.out.println("  Hora:       "+hora);
					}
				}
				if (!found)	{System.out.println("No se encontró la cotizacion.");}
				
				dis.close();
			}
			//Lanzado al llegar al final del fichero.
			catch (EOFException e)			{System.out.println("\nFin del fichero.");}
			//Lanzado por FileInputSteam
			catch (FileNotFoundException e)	{System.out.println("\tNo se encontró el fichero.");}
			//Lanzada por BufferedReader.readLine
			catch (IOException e) 			{e.printStackTrace();}
		}
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		try (Scanner input = new Scanner(System.in))
		{
			int op = 1;
			String fechaIn, horaIn;
			Cotizacion c = new Cotizacion();
			//Añade las cotizaciones cada vez que se ejecuta.
			c.GrabarCotización();
			
			try {
				do {
					//Permite realizar más acciones después de grabarla.
					System.out.println("\n¿Quieres realizar una consula?");
					System.out.println("1. Leer el fichero");
					System.out.println("2. Buscar cotizacion");
					System.out.println("0. Salir");
					System.out.print("Selecciona una opcion: ");
					op = input.nextInt();
					
					switch (op)
					{
						default:{System.out.print("Valor no válido.");}			break;
						case 0: {System.out.print("\n\nFin del programa.");}	break;
						case 1: {c.LeerCotización();}	break;
						case 2: 
						{
							System.out.print("Introduce el día: ");
							fechaIn = input.next();
							System.out.print("Introduce la hora: ");
							horaIn = input.next();
							
							if ((fechaIn.equals("Hoy")) || fechaIn.equals("hoy"))
							{
								fechaIn = LocalDate.now().toString();
							}
							
							c.VerCotización(fechaIn, horaIn);
						}
						break;
					}
				} while (op!=0);
			} catch (InputMismatchException e)	{System.out.print("Valor no válido."); op=0;}
		}
	}
	
	
	
	
}