package ej2_10;

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
			System.out.println("1. Crear y rellenar.");
			System.out.println("2. Comprobar.");
			System.out.print(" -> ");
			int opt = input.nextInt();
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/ej2_10/unidad2.db");
			Statement statement = conn.createStatement();
			
			if (opt==1)
			{
				statement.executeUpdate("drop table if exists departamentos");
				statement.executeUpdate("drop table if exists empleados");
				String t1 = ("create table departamentos ("
						+ "	dept_no int(2) not null primary key,"
						+ "	dnombre varchar(15),"
						+ "	loc varchar(15) "
						+ ");");
				String t2 = ("create table empleados ("
						+ " emp_no int not null primary key,"
						+ " apellido varchar(10),"
						+ " oficio varchar(10),"
						+ " dir int,"
						+ " fecha_alta date,"
						+ " salario float,"
						+ " comision float,"
						+ " dept_no int not null references departamentos(dept_no)"
						+ ");");
				statement.executeUpdate(t1);
				statement.executeUpdate(t2);
				
				statement.executeUpdate("insert into departamentos values (10,'CONTABILIDAD', 'SEVILLA')");
				statement.executeUpdate("insert into departamentos values (20,'INVESTIGACIÓN','MADRID')");
				statement.executeUpdate("insert into departamentos values (30,'VENTAS',       'BARCELONA')");
				statement.executeUpdate("insert into departamentos values (40,'PRODUCCIÓN',   'BILBAO')");
				
				statement.executeUpdate
				("insert into empleados values (7369,'SANCHEZ','EMPLEADO',7902,'1990- 12-17',1040,NULL,20)");
				statement.executeUpdate
				("insert into empleados values (7499,'ARROYO', 'VENDEDOR',7698,'1990- 02-20',1500,390, 30)");
				statement.executeUpdate
				("insert into empleados values (7521,'SALA',	  'VENDEDOR',7698,'1991- 02-22',1625 650, 30)");
			}
			else
			{
				ResultSet rs1 = statement.executeQuery("select * from departamentos");
				while(rs1.next())
				{
					System.out.println("\nDepartamento " + rs1.getInt("dept_no"));
		            System.out.println(" - Nombre: " + rs1.getString("dnombre"));
		            System.out.println(" - Local: " + rs1.getString("loc"));
	            }
				ResultSet rs2 = statement.executeQuery("select * from empleados");
				while(rs2.next())
				{
					System.out.println("\nEmpleado " + rs2.getInt("emp_no"));
		            System.out.println(" - Apellido: " + rs2.getString("apellido"));
		            System.out.println(" - Oficio: " + rs2.getString("oficio"));
		            System.out.println(" - Departamento: " + rs2.getString("dept_no"));
	            }
			}
			conn.close();
		}
		catch (SQLException e)				{e.printStackTrace();}
	}
}

