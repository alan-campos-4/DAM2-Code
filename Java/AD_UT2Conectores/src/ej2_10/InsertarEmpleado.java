package ej2_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertarEmpleado
{
	static Scanner input = new Scanner(System.in);
	static Connection connection;
	
	
	/* Accede a una columna de una tabla dada y busca si el valor dado existe. */
	public static boolean foundInColumn(String table, String col, int value) throws SQLException
	{
		boolean found = false;
		Statement stmnt = connection.createStatement();
		ResultSet res = stmnt.executeQuery("SELECT "+col+" FROM "+table+";");
		
		while (res.next())
		{
			if (res.getInt(1)==value) {found = true; break;}
		}
		stmnt.close();
		res.close();
		return found;
	}
	
	
	
	
	public static void main(String[] args)
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver"); deprecated for my version of MySql.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/unidad2", "root", "QKEBFF");
			
			int num, dir, depart;
			String apellido, oficio, fecha = LocalDate.now().toString();
			double salario, comision;
			
			System.out.println("Insertar un empleado a la tabla. ");
			/*
			 –	que el departamento exista en la tabla departamentos, si no existe no se inserta.
			 –	que el número del empleado no exista, si existe no se inserta.
			 –	que el salario sea > que 0, si es <= 0 no se inserta.
			 –	que el director (DIR, es el número de empleado de su director) exista en la tabla empleados, si no existe no se inserta.
			 –	El APELLIDO y el OFICIO no pueden ser nulos.
			 –	La fecha de alta del empleado es la fecha actual.
			*/
			
			System.out.print("- Código del empleado: ");
			num = input.nextInt();
			if (!foundInColumn("empleados", "emp_no", num))
			{
				input.nextLine();
				System.out.print("- Apellido: ");
				apellido = input.nextLine();
				if (!apellido.isEmpty())
				{
					System.out.print("- Oficio: ");
					oficio = input.nextLine();
					if (!oficio.isEmpty())
					{
						System.out.print("- Código de Director: ");
						dir = input.nextInt();
						if (foundInColumn("empleados", "emp_no", dir))
						{
							System.out.print("- Salario: ");
							salario = input.nextDouble();
							if (salario > 0)
							{
								System.out.print("- Comisión: ");
								comision = input.nextDouble();
								
								System.out.print("- Código de Departamento: ");
								depart = input.nextInt();
								if (foundInColumn("departamentos", "dept_no", depart))
								{
									System.out.print("- Fecha de alta: "+fecha);
									StringBuffer sb1 = new StringBuffer(apellido);
									StringBuffer sb2 = new StringBuffer(oficio);
									sb1.setLength(10);
									sb2.setLength(10);
									
									Statement query = connection.createStatement();
									query.executeUpdate("INSERT INTO empleados VALUES "
											+ "(" + num + ", '"+sb1.toString()+"', '"+sb2.toString()+"', " + dir 
											+ ", '"+fecha+"', " + salario + ", " + comision + ", " + depart + ")");
									
									System.out.print("Se ha guardado el empleado con éxito.");
									query.close();
								}
								else {System.out.println("Error. No existe el departamento con ese código.");}
							}
							else {System.out.println("Error. El salario no puede ser menor que 0.");}
						}
						else {System.out.println("Error. El director no existe.");}
					}
					else {System.out.println("Error. El oficio no puede ser nulo.");}
				}
				else {System.out.println("Error. El apellido no puede ser nulo.");}
			}
			else {System.out.println("Error. Ya existe un empleado con ese código.");}
			
			connection.close();
		}
		catch (InputMismatchException e)	{System.out.println("Error. El valor dado no es válido.");}
		catch (ClassNotFoundException e)	{e.printStackTrace();}
		catch (SQLException e)				{e.printStackTrace();}
	}
}

