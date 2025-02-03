package ej5_y_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLiteDatabase
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println("1. Crear.");
			System.out.println("2. Comprobar.");
			System.out.print(" -> ");
			int opt = input.nextInt();
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/ej5_y_6/UNIDAD2.db");
			Statement statement = conn.createStatement();
			
			if (opt==1)
			{
				String productos_table = 
						("create table productos ("
						+ "	ID int primary key,"
						+ " DESCRIPCION varchar(50) not null,"
						+ " STOCKACTUAL int,"
						+ " STOCKMINIMO int,"
						+ " PVP deccimal(5,2)"
						+ ");");
				String clientes_table = 
						("create table clientes ("
						+ " ID int primary key,"
						+ " NOMBRE varchar(50) not null,"
						+ " DIRECCION varchar(50),"
						+ " POBLACION varchar(50),"
						+ " TELEF varchar(20),"
						+ " NIF varchar(10)"
						+ ");");
				String ventas_table = 
						("create table ventas ("
						+ " IDVENTA int primary key,"
						+ " FECHAVENTA date not null,"
						+ " IDCLIENTE int,"
						+ " IDPRODUCTO int"
						+ " CANTIDAD int"
						+ ");");
				statement.executeUpdate("drop table if exists productos");
				statement.executeUpdate("drop table if exists clientes");
				statement.executeUpdate("drop table if exists ventas");
				statement.executeUpdate(productos_table);
				statement.executeUpdate(clientes_table);
				statement.executeUpdate(ventas_table);
				
				System.out.println("Tablas creadas.");
			}
			else
			{
				ResultSet rs1 = statement.executeQuery("select * from productos");
				while(rs1.next())
				{
					System.out.println("\nProducto " + rs1.getInt("ID"));
		            //System.out.println(" - Nombre: " + rs1.getString("dnombre"));
		            //System.out.println(" - Local: " + rs1.getString("loc"));
	            }
				ResultSet rs2 = statement.executeQuery("select * from clientes");
				while(rs2.next())
				{
					//System.out.println("\nEmpleado " + rs2.getInt("emp_no"));
		            //System.out.println(" - Apellido: " + rs2.getString("apellido"));
		            //System.out.println(" - Oficio: " + rs2.getString("oficio"));
		            //System.out.println(" - Departamento: " + rs2.getString("dept_no"));
	            }
			}
			conn.close();
		}
		catch (SQLException e)				{e.printStackTrace();}
	}
}