package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EjercicioSQLite
{
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		try
		{
			//Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:unidad2.db");
			
			Statement statement = conn.createStatement();
			statement.executeUpdate("drop table if exists departamentos");
			String sql = ("create table departamentos ("
					+ "	dept_no int(2) primary key,"
					+ "	dnombre varchar(15),"
					+ "	loc varchar(15) "
					+ ");");
			statement.executeUpdate(sql);
			System.out.println("Table created.");
			
			statement.executeUpdate("insert into departamentos VALUES (10, 'CONTABILIDAD', 'SEVILLA')");
			statement.executeUpdate("insert into departamentos VALUES (20, 'INVESTIGACIÓN', 'MADRID')");
			statement.executeUpdate("insert into departamentos VALUES (30, 'VENTAS', 'BARCELONA')");
			statement.executeUpdate("insert into departamentos VALUES (40, 'PRODUCCIÓN', 'BILBAO')");
			
			ResultSet rs = statement.executeQuery("select * from departamentos");
			while(rs.next())
			{
				System.out.println("\nDepartamento " + rs.getInt("dept_no"));
	            System.out.println(" - Nombre: " + rs.getString("dnombre"));
	            System.out.println(" - Local: " + rs.getString("loc"));
            }
			
			conn.close();
		}
		catch (SQLException e)				{e.printStackTrace();}
	}
}

