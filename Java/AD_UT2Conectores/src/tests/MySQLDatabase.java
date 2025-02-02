package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabase
{
	public static void main(String[] args)
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver"); deprecated for my version of MySql.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/unidad2", "root", "QKEBFF");
			
			String sql = "SELECT * FROM empleados";
			Statement query = conn.createStatement();
			ResultSet res = query.executeQuery(sql);
			
			while (res.next())
			{
				System.out.printf("%d - %s \n", 
					res.getInt(1), res.getString(2));
			}
			
			res.close();
			query.close();
			conn.close();
		}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}
		finally {
		System.out.println("Opened database successfully"); }
	}
}
