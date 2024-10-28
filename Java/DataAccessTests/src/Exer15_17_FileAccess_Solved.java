import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.ObjectInputStream;
import java.util.Scanner;




public class Exer15_17_FileAccess_Solved
{
	static Scanner input;
	static File fichero;
	static ObjectInputStream OIS;
	static ObjectOutputStream OOS;
	
	public static void clear()
	{
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\n\n\n\n");
	}
	
	public static void pressAnyKey()
	{
		System.out.println("\nPress any key to continue.");
        try {
            System.in.read();
            input.nextLine();
        } catch (Exception e) {e.printStackTrace();}
	}
	
	
	
	
	
	
	/***** MAIN *****/
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		int op;
		
		do {
			
			System.out.println("\nEJERCICIOS\n");
			System.out.println(" 15. Clase Pedidos.");
			System.out.println(" 16. Clase Agenda.");
			System.out.println(" 17. Clase GestorProductos.");
			System.out.println(" 0.  Salir.");
			System.out.print("\nSelecciona una opción: ");
			op = input.nextInt();
			
			switch(op)
			{
				default:
				{
					System.out.println("\nOpción no válida.");
					pressAnyKey();
				}
				break;
				case 0:
				{
					System.out.println("\n\nFin del programa.");
				}
				break;
				case 1: case 15:
				{
					clear();
					Ejer15("FichData.dat");
					pressAnyKey();
					clear();
				}
				break;
				case 2: case 16:
				{
					clear();
					Ejer16();
					pressAnyKey();
					clear();
				}
				break;
				case 3: case 17:
				{
					clear();
					Ejer17("productos.dat");
					pressAnyKey();
					clear();
				}
				break;
			}
			
		} while (op!=0);
	}
	
	
	
	
	
	
	
	
	/*
	 * 15. Modifica el ejercicio 14 utilizando objetos para guardar y ver los pedidos.
	 */
	public static void Ejer15(String fich)
	{
		File fichero = new File("FichData.dat");
		ObjectInputStream OIS;
		ObjectOutputStream OOS;
		Pedido p, p1, p2, p3;
		
		//Escribir
		p1 = new Pedido("producto1", 14, 12.3);
		p2 = new Pedido("producto2", 15, 34.5);
		p3 = new Pedido("producto3", 13, 28.9);
		try {
			OOS = new ObjectOutputStream(new FileOutputStream(fichero));
			try
			{
			    OOS.writeObject(p1);
			    OOS.writeObject(p2);
			    OOS.writeObject(p3);
		    }
			catch (EOFException eo)		{eo.printStackTrace();}
			OOS.close();
		}
		catch (FileNotFoundException e)		{e.printStackTrace();} 
		catch (IOException e)				{e.printStackTrace();}
		
		//Leer
		try {
			OIS = new ObjectInputStream(new FileInputStream(fichero));
			try
			{
			    while (true)
			    {
			        p = ((Pedido)OIS.readObject()); 
			        System.out.println("Descripcion: " + p.descripcion);
			        System.out.println("Unidades: " + p.unidades);
			        System.out.println("POrecio: " + p.precio);
			    }
		    }
			catch (EOFException eo)		{eo.printStackTrace();}
			OIS.close();
		}
		catch (FileNotFoundException e)		{e.printStackTrace();} 
		catch (IOException e)				{e.printStackTrace();}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
	}
	
	/* Clase */
	public static class Pedido
	{
		String descripcion;
		int unidades;
		double precio;
		
		public Pedido(String d, int u, double p)
		{
			descripcion = d;
			unidades = u;
			precio = p;
		}
	}
	
	
	
	
	
	
	/*
	 * 16. 
	 * a) Tenemos una clase Agenda con nombre, apellidos y teléfono. 
	 * 	  Realizar un programa para almacenar datos de manera persistente en “agenda.dat”. 
	 *    Comprobar que se ha realizado bien, realizando una lectura de los mismos.
	 * b) Modificar el programa para que en las siguientes ejecuciones los datos se añadan al fichero 
	 *    (es decir, si existe el fichero no se sobreescribirá).
	 */
	public static void Ejer16()
	{
		Persona persona;
		File fichero;
		ObjectOutputStream dataOS;
		ObjectInputStream dataIS;
		
		//Escribir
		try
		{
			fichero = new File("FichPersona.dat");//declara el fichero
			if(!fichero.exists())
			{
				dataOS = new ObjectOutputStream (new FileOutputStream(fichero));
			}
			else
			{
				dataOS = new ObjectOutputStream2 (new FileOutputStream(fichero,true));	
			}
			String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés",
		                       "Julio","Antonio","María Jesús"};
			int edades[] = {14,15,13,15,16,12,16,14,13};
			System.out.println("GRABO LOS DATOS DE PERSONA.");
			
			for (int i=0; i<edades.length; i++)
			{ //recorro los arrays    
				persona = new Persona(nombres[i], edades[i]);
				dataOS.writeObject(persona);
				System.out.println("GRABO LOS DATOS DE PERSONA.");  
			}     
			dataOS.close();  //cerrar stream de salida
		}
		catch (IOException e)	{e.printStackTrace();}
		
		//Leer
		try
		{
			fichero = new File ("FichPersona.dat");
			dataIS = new ObjectInputStream(new FileInputStream(fichero));
			int i = 1;
			try
			{
				while (true)
				{
					persona = (Persona) dataIS.readObject();
					System.out.print(i + "=>");
					i++;
					System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(),persona.getEdad());
				}
			}
			catch (EOFException eo) 			{System.out.println("FIN DE LECTURA. Fin de Fichero");}
			catch (StreamCorruptedException x)	{System.out.println("FIN DE LECTURA. StreamCorruptedException");} 
			catch (ClassNotFoundException e)	{e.printStackTrace();}

			dataIS.close();
		}
		catch (IOException e) {e.printStackTrace();}

	}
	
	/* Clase */
	public static class Persona implements Serializable
	{
		private static final long serialVersionUID = 1L;
		String nombre;
		String apellidos;
		int telefono;
		int edad;
		
		public Persona()	{this.nombre=null;}
		public Persona(String nombre, int edad)
		{
			this.nombre=nombre;
			this.edad=edad;	
		}
		
		public void setNombre(String nom)	{nombre=nom;}
		public void setEdad(int ed)			{edad=ed;}
			
		public String getNombre()	{return nombre;}
		public int getEdad()		{return edad;}
	}
	
	
	
	
	
	
	/*
	 * 17. Programa para gestionar una lista de productos (código, descripción, unidades, precio) 
	 * que se venden en nuestra empresa. 
	 * Escribiremos la información de estos productos en un fichero “productos.dat”, 
	 * para almacenarlos de forma persistente.
	 * Se pide:
	 * a) Introducir el código necesario en el método almacenar de la clase GestorProductos 
	 *    para guardar la información de los productos en el fichero. 
	 *    Guardaremos esta información codificada en un fichero binario.
	 * b) Introducir el código en el método recuperar para cargar la información de este fichero.
	 * c) Modificar el código anterior parapara que en las siguientes ejecuciones los datos 
	 *    se añadan al fichero
	 *    (es decir, si existe el fichero no se sobreescribirá).
	 */
	public static void Ejer17(String fich)
	{
		GestorProductos gp = new GestorProductos();
		gp.EscribeFichero("productos.dat");
		gp.LeerFichero("productos.dat");
	}
	
	/* Clases */
	public static class Producto implements Serializable
	{
		private static final long serialVersionUID = 1L;
		public int id;
		public int codigo;
		public String descripcion;
		public int unidades;
		public double precio;
		
		public Producto(int id, String descripcion, int unidades, double precio)
		{ 
			this.id = id; 
			this.descripcion = descripcion;
			this.unidades=unidades;
			this.precio=precio;
		}
		
		public void setId(int id)				{this.id = id;}
		public void setDes(String descripcion)	{this.descripcion = descripcion;} 
		public void setUnidades(int unidades)	{this.unidades = unidades;}
		public void setPrecio(int precio)		{this.precio = precio;}
		
		public int getId()			{return this.id;}	
		public String getDes()		{return this.descripcion;}
		public int getUnidades()	{return this.unidades;}	
		public double getPrecio()	{return this.precio;}
	}
	public static class GestorProductos
	{
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		public GestorProductos()
		{
			
		}
		public void EscribeFichero(String fichero)
		{
			ois = null;
			Producto producto;
			File fich1 = new File(fichero);
			
			try
			{
				if(!fich1.exists())
					{ oos = new ObjectOutputStream(new FileOutputStream(fich1)); }
				else
					{ oos = new ObjectOutputStream2(new FileOutputStream(fich1,true)); }
				
				for (int i=1; i<5; i++)
				{
					producto = new Producto(i, "des"+i, i+3, i+10.0);
					oos.writeObject(producto);
				}
				oos.close();
			}
			catch(IOException e)	{e.printStackTrace();}
		}
		public void LeerFichero(String fichero)
		{
			ois = null;
		    Producto aux;
		    try
		    {
		        ois = new ObjectInputStream(new FileInputStream(fichero));
		        aux = (Producto)ois.readObject();
		        
		        // Mientras haya objetos
		        while (true)
		        {
		        	System.out.println(aux);
		        	aux = (Producto) ois.readObject();
		        }
		         
		    }
		    catch (EOFException e1)	{System.out.println ("Fin de fichero");}
		    catch (IOException e3)	{e3.getMessage();}
		    catch (Exception e2)	{e2.printStackTrace();}
		    finally 
		    {
		    	try {ois.close();} 
		    	catch (IOException e) {e.printStackTrace();}
		    }
		}
	}
	
	
	
	
	
	
	
	
}