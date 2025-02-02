package ej5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScriptRellenar
{
	static Scanner input = new Scanner(System.in);
	
	
	public static String getDBName(int db)
	{
		if (db==1)		return "MySQL";
		else if (db==2)	return "Oracle";
		else			return "SQLite";
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\nSelecciona una base de datos a rellenar:");
			System.out.println("1. MySQL");
			System.out.println("2. Oracle");
			System.out.println("3. SQLite");
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
				System.out.println("3. ...");
				System.out.println("4. Salir.");
				System.out.print(" -> ");
				
				int opt = input.nextInt();
				
				if (opt==1)			{agregarProducto(db);}
				else if (opt==2)	{agregarCliente(db);}
				else if (opt==3)	{ } //ventas
				else {System.out.println("\nOpción no válida.");}
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
		Connection conn = null;
		Statement statement = null;
		
		try
		{
			System.out.println("ID: ");					id = input.nextInt(); input.nextLine();
			System.out.println("Descripcion: ");		desc = input.nextLine();
			System.out.println("Stock actual: ");		stock = input.nextInt();
			System.out.println("Stock mínimo: ");		minstock = input.nextInt();
			System.out.println("Precio de venta: ");	pvp = input.nextDouble();
			sb = new StringBuffer(desc);
			sb.setLength(50);
			
			if (database==1)
			{
				
			}
			if (database==2)
			{
				//
			}
			else
			{
				conn = DriverManager.getConnection("jdbc:sqlite:src/ej5/unidad2.db");
				statement = conn.createStatement();
				statement.executeUpdate("insert into productos values ("
					+id+",'"+sb.toString()+"', "+stock+", "+minstock+", "+pvp+")");
			}
			statement.close();
			conn.close();
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
		Connection conn = null;
		Statement statement = null;
		
		System.out.println("ID: ");
		System.out.println("Nombre: ");
		System.out.println("Dirección: ");
		System.out.println("Población: ");
		System.out.println("Teléfono: ");
		System.out.println("NIF: ");
		
		try
		{
			System.out.println("ID: ");			id = input.nextInt();
			System.out.println("Nombre: ");		name = input.nextLine();
			System.out.println("Dirección: ");	direc = input.nextLine();
			System.out.println("Población: ");	pob = input.nextLine();
			System.out.println("Teléfono: ");	tel = input.nextLine();
			System.out.println("NIF: ");		nif = input.nextLine();
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
			
			if (database==1)
			{
				
			}
			if (database==2)
			{
				//
			}
			else
			{
				conn = DriverManager.getConnection("jdbc:sqlite:src/ej5/unidad2.db");
				statement = conn.createStatement();
				statement.executeUpdate("insert into productos values ("
					+id+",'"+sb1.toString()+"', '"+sb2.toString()+"', '"+sb3.toString()+"', '"
						+sb4.toString()+"', '"+sb5.toString()+"')");
			}
			statement.close();
			conn.close();
		}
		catch (InputMismatchException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}	
	}
	
	
	
	
}

