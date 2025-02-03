package ej5_y_6;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScriptRellenarVentas
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("\nSelecciona una base de datos:");
			System.out.println("1. MySQL.");
			System.out.println("2. SQLite.");
			System.out.println("0. Salir del programa.");
			System.out.print(" -> ");
			
			int db = input.nextInt();
			
			if (db==0)
			{
				System.exit(0);
			}
			else if (db>=1 && db<=3)
			{
				System.out.println("\nIngresa los datos de un producto en "+Functions.getDBName(db)+".");
				String fecha;
				LocalDate today = LocalDate.now();
				int id, cliente, producto, cantidad;
				
				try
				{
					System.out.print("ID de venta: ");		id = input.nextInt(); input.nextLine();
					System.out.print("Fecha de venta (YYYY-MM-DD): ");	fecha = input.nextLine();
					System.out.print("ID del cliente: ");	cliente = input.nextInt();
					System.out.print("ID del producto: ");	producto = input.nextInt();
					System.out.print("Cantidad: ");			cantidad = input.nextInt();
					
					if (!Functions.foundInColumn(db, "ventas", "ID_Venta", id))
					{
						if (Functions.foundInColumn(db, "clientes", "ID", cliente))
						{
							if (Functions.foundInColumn(db, "productos", "ID", producto))
							{
								if (cantidad>0)
								{
									if (fecha.equals(today.toString()))
									{
										//Realiza el comando de inserción.
										String sql = "insert into ventas values ("+id+", \'"+fecha+"\', "+cliente+", "
											+producto+", "+cantidad+");";
										
										Functions.executeCommand(db, "ventas", sql);
									}
									else {System.out.println("La fecha debe ser la actual.");}
								}
								else {System.out.println("La cantidad debe ser mayor a 0.");}
							}
							else {System.out.println("El producto no existe.");}
						}
						else {System.out.println("El cliente no existe.");}
					}
					else {System.out.println("El ID de la venta debe ser único.");}
				}
				catch (InputMismatchException e)	{e.printStackTrace();}
				catch (SQLException e)				{e.printStackTrace();}
			}
			else {System.out.println("Opción no válida.");} 
		}
		catch (InputMismatchException e)	{System.out.println("Opción no válida.");}
		
	}
	
	
	
	
}

