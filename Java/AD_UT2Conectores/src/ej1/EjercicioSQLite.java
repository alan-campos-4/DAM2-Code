package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioSQLite
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			
			String sql = "SELECT * FROM clientes";
			Statement query = conn.createStatement();
			ResultSet res = query.executeQuery(sql);
			
			while (res.next())
			{
				System.out.printf("%d - %s | %s %s | %s %s\n", 
					res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
			}
			
			res.close();
			query.close();
			conn.close();
			
		}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}
		System.out.println("Opened database successfully");
	}
}
