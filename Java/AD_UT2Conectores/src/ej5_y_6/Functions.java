package ej5_y_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Functions
{
	/* Devuelve el nombre de la base de datos según el entero que recibe. */
	public static String getDBName(int db)
	{
		if (db==1)		return "MySQL";
		else			return "SQLite";
	}
	
	
	
	/* Devuelve true si el valor dado se encuentra en la columna de la tabla en la base de datos. */
	public static boolean foundInColumn(int db, String table, String col, int value) throws SQLException
	{
		Connection conn = null;
		if (db==1)		{conn = DriverManager.getConnection("jdbc:mysql://localhost/unidad2", "unidad2", "unidad2");}
		else			{conn = DriverManager.getConnection("jdbc:sqlite:src/ej5_y_6/UNIDAD2.db");}
		Statement stmnt = conn.createStatement();
		ResultSet res = stmnt.executeQuery("SELECT "+col+" FROM "+table+";");
		
		boolean found = false;
		while (res.next())
		{
			if (res.getInt(1)==value) {found = true; break;}
		}
		stmnt.close();
		res.close();
		conn.close();
		
		return found;
	}
	
	
	
	/* Ejecuta el comando SQL dado y muestra la tabla después. */
	public static void executeCommand(int db, String table, String sql) throws SQLException
	{
		System.out.println("\nInsertando valores en la tabla "+table+" de la base de datos "+getDBName(db)+".");
		
		//Establece la conexión con la base de datos.
		Connection conn = null;
		if (db==1)		{conn = DriverManager.getConnection("jdbc:mysql://localhost/unidad2", "unidad2", "unidad2");}
		else			{conn = DriverManager.getConnection("jdbc:sqlite:src/ej5_y_6/UNIDAD2.db");}
		
		//Realiza el comando y muestra si ha sido exitoso.
		Statement stmnt = conn.createStatement();
	    int i = stmnt.executeUpdate(sql);
		if (i > 0)	{System.out.println("Se ha introducido la fila.");} 
		else		{System.out.println("No se ha podido introducir la fila.");}
		
		
		//Muestra el contenido de la tabla. Cada tabla tiene un formato diferente.
		System.out.println("\nEl resultado en la tabla "+table+" es: ");
		ResultSet rs = null;
		if (table.equals("productos"))
		{
			rs = stmnt.executeQuery("select * from productos");
			while(rs.next())
			{
				System.out.println("- "+rs.getInt(1)+". "+rs.getString(2)+" | "+rs.getInt(3)+" - "+rs.getInt(4)+" | "
						+rs.getDouble(5)+"€");
	        }
		}
		else if (table.equals("clientes"))
		{
			rs = stmnt.executeQuery("select * from clientes");
			while(rs.next())
			{
				System.out.println("- "+rs.getInt(1)+". "+rs.getString(2)+" | "+rs.getString(3)+", "+rs.getString(4)+" | "
						+rs.getString(5)+", "+rs.getString(6));
	        }
		}
		else if (table.equals("ventas"))
		{
			rs = stmnt.executeQuery("select * from ventas");
			while(rs.next())
			{
				System.out.println("- "+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getInt(4)+", "+rs.getInt(5));
	        }
		}
		
		//Se cierran los recursos.
		rs.close();
		stmnt.close();
		conn.close();
	}
	
	
	
	
}

