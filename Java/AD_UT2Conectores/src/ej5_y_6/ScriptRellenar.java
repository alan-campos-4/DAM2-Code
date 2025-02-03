package ej5_y_6;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScriptRellenar
{
	static Scanner input = new Scanner(System.in);
	
	
	public static String getDBName(int db)
	{
		if (db==1)		return "MySQL";
		else			return "SQLite";
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\nSelecciona una base de datos a rellenar:");
			System.out.println("1. MySQL.");
			System.out.println("2. SQLite.");
			System.out.println("0. Terminar el programa.");
			System.out.print(" -> ");
			
			int db = input.nextInt();
			
			if (db==0)
			{
				System.exit(0);
			}
			else if (db>=1 && db<=3)
			{
				System.out.println("\nEstás en la base de datos "+getDBName(db)+".");
				System.out.println("¿Qué quieres hacer?:");
				System.out.println("1. Insertar producto.");
				System.out.println("2. Insertar cliente.");
				System.out.println("0. Salir.");
				System.out.print(" -> ");
				
				int opt = input.nextInt();
				
				switch (opt)
				{
					case 1: agregarProducto(db);	break;
					case 2: agregarCliente(db);		break;
					default: System.out.println("Opción no válida."); break;
					case 0:	 System.exit(0);
				}
			}
			else {System.out.println("Opción no válida.");} 
		}
		catch (InputMismatchException e)	{System.out.println("Opción no válida.");}
	}
	
	
	
	
	public static void agregarProducto(int database)
	{
		System.out.println("\nIngresa los datos de un producto.");
		String desc;
		StringBuffer sb;
		int id, stock, minstock;
		double pvp;
		
		try
		{
			System.out.print("ID: ");				id = input.nextInt(); input.nextLine();
			System.out.print("Descripcion: ");		desc = input.nextLine();
			System.out.print("Stock actual: ");		stock = input.nextInt();
			System.out.print("Stock mínimo: ");		minstock = input.nextInt();
			System.out.print("Precio de venta: ");	pvp = input.nextDouble();
			sb = new StringBuffer(desc);
			sb.setLength(50);
			
			String sql = "insert into productos values ("+id+", \'"+sb.toString()+"\', "+stock+", "+minstock+", "+pvp+");";
			
			Functions.executeCommand(database, "productos", sql);
		}
		catch (InputMismatchException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}	
	}
	
	
	
	
	public static void agregarCliente(int database)
	{
		System.out.println("\nIngresa los datos de un cliente.");
		String name, direc, pob, tel, nif;
		StringBuffer sb1, sb2, sb3, sb4, sb5;
		int id;
		try
		{
			System.out.print("ID: ");			id = input.nextInt(); input.nextLine();
			System.out.print("Nombre: ");		name = input.nextLine();
			System.out.print("Dirección: ");	direc = input.nextLine();
			System.out.print("Población: ");	pob = input.nextLine();
			System.out.print("Teléfono: ");		tel = input.nextLine();
			System.out.print("NIF: ");			nif = input.nextLine();
			sb1 = new StringBuffer(name);
			sb2 = new StringBuffer(direc);
			sb3 = new StringBuffer(pob);
			sb4 = new StringBuffer(tel);
			sb5 = new StringBuffer(nif);
			sb1.setLength(50);
			sb2.setLength(50);
			sb3.setLength(50);
			sb4.setLength(20);
			sb5.setLength(10);
			
			String sql = "insert into clientes values ("+id+", \'"+sb1.toString()+"\', \'"+sb2.toString()+"\', "
				+"\'"+sb3.toString()+"\', \'"+sb4.toString()+"\', \'"+sb5.toString()+"\')";
			
			Functions.executeCommand(database, "clientes", sql);
		}
		catch (InputMismatchException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}
	}
	
	
	
	
}

