package ej5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScriptRellenarVentas
{
	static Scanner input = new Scanner(System.in);
	
	
	public static String getDBName(int db)
	{
		if (db==1)		return "MySQL";
		else if (db==2)	return "Oracle";
		else			return "SQLite";
	}
	
	public static String dataFormat(int db)
	{
		return "YYYY-MM-DD";
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\nSelecciona una base de datos:");
			System.out.println("1. MySQL");
			System.out.println("2. Oracle");
			System.out.println("3. SQLite");
			System.out.print(" -> ");
			
			int db = input.nextInt();
			
			if (db==0)
			{
				System.exit(0);
			}
			else if (db>=1 && db<=3)
			{
				System.out.println("\nIngresa los datos de un producto.");
				String fecha;
				Date fe;
				int id, cliente, producto, cantidad;
				Connection conn = null;
				Statement statement = null;
				
				try
				{
					System.out.println("ID de venta: ");		id = input.nextInt(); input.nextLine();
					System.out.println("Fecha de venta ("+dataFormat(db)+"): ");
					fecha = input.nextLine();
					System.out.println("ID del cliente: ");		cliente = input.nextInt();
					System.out.println("ID del producto: ");	producto = input.nextInt();
					System.out.println("Cantidad: ");			cantidad = input.nextInt();
					
					if (db==1)
					{
						
					}
					if (db==2)
					{
						//
					}
					else
					{
						conn = DriverManager.getConnection("jdbc:sqlite:src/ej5/unidad2.db");
						statement = conn.createStatement();
						statement.executeUpdate("insert into productos values ("
							+id+",'"+fecha.toString()+"', "+stock+", "+minstock+", "+pvp+")");
					}
					statement.close();
					conn.close();
				}
				catch (InputMismatchException e)	{e.printStackTrace();}
				catch (SQLException e)				{e.printStackTrace();}
			}
			else {System.out.println("Opción no válida.");} 
		}
		catch (InputMismatchException e)	{System.out.println("Opción no válida.");}
	
		
		
		
		
		
		
		
	}
	
	
	
	
	
}

