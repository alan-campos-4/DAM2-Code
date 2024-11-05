import general.Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Exer15_17_FileAccess
{
	static Scanner input;
	static File fichero;
	static ObjectInputStream OIS;
	static ObjectOutputStream OOS;
	
	
	public static void main(String args[])
	{
		input = new Scanner(System.in);
		int op = 0;
		
		do {
			Base.createMenu(15, "Clase Pedidos", "Clase Agenda", "Clase GestorProductos");
			
			try
			{
				op = input.nextInt();
				
				if (op!=0)	{Base.clear();}
				switch(op)
				{
					default: {System.out.println("\nOpción no válida.");}	break;
					case 0:  {System.out.println("\n\nFin del programa.");}	break;
					case 1: case 15:	{Ejer15();}	break;
					case 2: case 16:	{Ejer16();}	break;
					case 3: case 17:	{Ejer17();}	break;
				}
				if (op!=0)	{Base.pressAnyKey();}
			}
			catch (InputMismatchException e)	{System.out.println("\nOpción no válida.");}
			
		} while (op!=0);
	}
	
	
	
	
	//Writes a given list of objects to a given file.
	public static void WriteListToFile(ArrayList<?> List, File f)
	{
		try
		{
			OOS = new ObjectOutputStream(new FileOutputStream(f));
			for (int i=0; i<List.size(); i++)
			{
				OOS.writeObject(List.get(i));
			}
			OOS.close();
		}
		catch (IOException e)			{e.printStackTrace();}
	}
	// Reads a given list of objects from a given file.
	@SuppressWarnings("unchecked")
	public static <T> void ReadListFromFile(ArrayList<T> List, File f)
	{
		try
		{
			Object obj;
			OIS = new ObjectInputStream(new FileInputStream(f));
			for (int i=0; i<List.size(); i++)
			{
				obj = ((T)OIS.readObject());
				Field[] fields = obj.getClass().getDeclaredFields();
				
				System.out.println(obj.getClass().getSimpleName());
		    	for (Field field : fields)
		    	{
		    		System.out.println("  "+field.getName()+":\t"+field.get(obj));
	    	    }
		    	System.out.println();
			}
			OIS.close();
		}
		catch (FileNotFoundException e)		{e.printStackTrace();}
		catch (IOException e)				{e.printStackTrace();} 
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		catch (IllegalAccessException e)	{e.printStackTrace();}
	}
	
	
	
	
	
	
	
	/*
	 * 15. Modifica el ejercicio 14 utilizando objetos para guardar y ver los pedidos.
	 */
	public static void Ejer15()
	{
		fichero = new File("FichData.dat");
		ArrayList<Pedido> Lista = new ArrayList<Pedido>();
		Lista.add(new Pedido("producto1", 14, 12.3));
		Lista.add(new Pedido("producto2", 15, 34.5));
		Lista.add(new Pedido("producto3", 13, 28.9));
		
		WriteListToFile(Lista, fichero);
		
		ReadListFromFile(Lista, fichero);
	}
	
	/* Clase */
	public static class Pedido implements Serializable
	{
		private static final long serialVersionUID = 1L;
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
		fichero = new File("agenda.dat");
		ArrayList<Agenda> Lista = new ArrayList<Agenda>();
		Lista.add(new Agenda("Ana", "Lopez", 1274));
		Lista.add(new Agenda("Pedro", "Sánchez", 3154));
		Lista.add(new Agenda("Felipe", "Pérez", 2828));
		
		WriteListToFile(Lista, fichero);
		
		ReadListFromFile(Lista, fichero);
	}
	
	/* Clase */
	public static class Agenda implements Serializable
	{
		private static final long serialVersionUID = 1L;
		String nombre;
		String apellidos;
		int telefono;
		
		public Agenda(String n, String a, int t)
		{
			this.nombre = n;
			this.apellidos = a;
			this.telefono = t;
		}
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
	public static void Ejer17()
	{
		GestorProductos GP = new GestorProductos("productos.dat");
		GP.addProduct(new Producto(1, "P1", 14, 12.3));
		GP.addProduct(new Producto(2, "P2", 15, 34.5));
		GP.addProduct(new Producto(3, "P3", 13, 28.9));
		GP.addProduct(new Producto(4, "P4", 17, 16.3));
		GP.almacenar();
		GP.mostrar();
	}
	
	/* Clases */
	public static class Producto implements Serializable
	{
		private static final long serialVersionUID = 1L;
		int codigo;
		String descripcion;
		int unidades;
		double precio;
		
		public Producto(int c, String d, int u, double p)
		{
			this.codigo = c;
			this.descripcion = d;
			this.unidades = u;
			this.precio = p;
		}
	}
	public static class GestorProductos
	{
		File fichProd;
		ArrayList<Producto> listProd;
		
		public GestorProductos(String fich)
		{
			fichProd = new File(fich);
			listProd = new ArrayList<Producto>();
		}
		public void addProduct(Producto p)
		{
			listProd.add(p);
		}
		public void almacenar()
		{
			WriteListToFile(listProd, fichProd);
		}
		public void mostrar()
		{
			ReadListFromFile(listProd, fichero);
		}
	}
	
	
	
	
	
	
	
	
}