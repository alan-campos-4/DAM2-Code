package ej2_08;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaData_Oracle
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "", "");
			
			DatabaseMetaData dbmd = conn.getMetaData();
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS ORACLE:");
			System.out.println("===================================");
			System.out.printf("Nombre:  %s %n", nombre);
			System.out.printf("Driver:  %s %n", driver);
			System.out.printf("URL:     %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);
			
			ResultSet resul = dbmd.getTables(null, "ejemplo", null, null);
			while (resul.next())
			{
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString (4);
				System.out.printf("%s Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			conn.close();
		}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}
	}
}
