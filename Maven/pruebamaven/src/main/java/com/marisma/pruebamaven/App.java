package com.marisma.pruebamaven;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import clases.Departamentos;
import clases.Empleados;



@SuppressWarnings({ "removal", "deprecation" })
public class App
{
	public static Scanner input = new Scanner(System.in);
	public static SessionFactory sesion;
	public static Session session;
	public static Transaction tx;
	
	public static void main(String[] args)
	{
		/*
		La aplicación puede crear registros en la base de datos (5 puntos)
		La aplicación puede recuperar registros de la base de datos (5 puntos)
		La aplicación puede actualizar registros en la base de datos (5 puntos)
		La aplicación puede eliminar registros en la base de datos (5 puntos
		 */
		sesion = HibernateUtil.getSessionFactory();
		session = sesion.openSession();
		//tx = session.beginTransaction();

		int op = 0;
		int table = 0;
		try
		{
			do
			{
				System.out.println("----- Hibernate CRUD -----\n");
				System.out.println("Tablas.");
				System.out.println("  1. Departamentos.");
				System.out.println("  2. Empleados.");
				System.out.print("\nElige una opción: ");
				table = input.nextInt();
				
				if (table==1 || table==2)
				{
					if (table==1)	{System.out.println("\nEstás en la tabla Departamentos.");}
					else			{System.out.println("\nEstás en la tabla Empleados.");}
					System.out.println("\nOperaciones.");
					System.out.println("  1. Insertar registros.");
					System.out.println("  2. Consultar registros.");
					System.out.println("  3. Actualizar registros.");
					System.out.println("  4. Eliminar registros.");
					System.out.println("  0. Salir.");
					System.out.print("\nElige una opción: ");
					op = input.nextInt();
					input.nextLine();
					switch (op)
					{
						case 1: {insertar(table);}		break;
						case 2: {consultar(table);}		break;
						case 3: {actualizar(table);}	break;
						case 4: {eliminar(table);}		break;
						default: {System.out.println("Opción no válida.");} break;
					}
				}
				else if (table==0)	{System.out.println("Saliendo...");}
				else				{System.out.println("Opción no válida.");}
				
				clear();
			}
			while (table!=0 && op!=0);
		}
		catch (NumberFormatException e)		{e.printStackTrace();}
		catch (InputMismatchException e)	{e.printStackTrace();}
		finally
		{
			session.close();
			System.exit(0);
		}
	}
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void consultar(int table)
	{
		tx = session.beginTransaction();
		//***** Consulta en Departamentos *****
		String option = "";
		if (table==1)
		{
			System.out.println("Consulta en la tabla Departamentos.");
			System.out.println("Escribe el número del departamento que quieras ver,");
			System.out.println("o escribe * para ver todos");
			System.out.print("  -> ");
			option = input.nextLine();
			
			//Si introduce un * muestra todos los registros, si no, uno solo
			if (option.equals("*"))
			{
				//Obtiene todos los empleados en una lista y la recorre.
				Query qq = session.createQuery("from Departamentos");
				List<Departamentos> list = qq.list();
				Iterator<Departamentos> iter = list.iterator();
				while (iter.hasNext())
				{
					Departamentos dep = (Departamentos) iter.next();
					System.out.printf("%s, %s %n", dep.getDnombre(), dep.getLoc());
				}
			}
			else
			{
				//Consulta el departamento con el número dado.
				try
				{
					Query q = session.createQuery("from Departamentos where deptNo = :numdep");
					q.setParameter("numdep", (byte)Byte.parseByte(option));
					Departamentos dep = (Departamentos) q.uniqueResult();
					System.out.printf("%s, %s %n", dep.getDnombre(), dep.getLoc());
				}
				//Lanzadas si no se puede convertir la entrada a byte,
				// o si el objeto es nulo porque no se encontró el departamento con el número dado.
				catch (NumberFormatException |NullPointerException e)
					{System.out.println("El Empleado no existe");}
			}
		}
		
		//***** Consulta en Empleados *****
		else
		{
			System.out.println("Consulta en la tabla Empleados.");
			System.out.println("Escribe el número del empleado que quieras ver,");
			System.out.println("o escribe * para ver todos");
			System.out.print("  ->");
			option = input.nextLine();
			
			if (option.equals("*"))
			{
				//Obtiene todos los empleados en una lista y la recorre.
				Query qq = session.createQuery("from Empleados");
				List<Empleados> list = qq.list();
				Iterator<Empleados> iter = list.iterator();
				while (iter.hasNext())
				{
					Empleados em = (Empleados) iter.next();
					System.out.printf("%s, %s %n", em.getApellido(), em.getOficio());
				}
			}
			else
			{
				//Consulta el empleado con el número dado.
				try
				{
					Query q = session.createQuery("from Empleados where empNo = :numemple");
					q.setParameter("numemple", (short)Short.parseShort(option));
					Empleados em = (Empleados) q.uniqueResult();
					System.out.printf("%s, %s %n", em.getApellido(), em.getOficio());
				}
				//Lanzadas si no se puede convertir la entrada a short,
				// o si el objeto es nulo porque no se encontró el empleado con el número dado.
				catch (NumberFormatException |NullPointerException e)
					{System.out.println("El Empleado no existe");}
			}
		}
		tx.commit();
	}
	



	public static void insertar(int table)
	{
		tx = session.beginTransaction();
		//***** Inserta en Departamentos *****
		if (table==1)
		{
			System.out.println("Insertando en la tabla Departamentos.");
			byte num;
			String name, localidad;
			try
			{
				//Lee los datos del nuevo departamento y lo guarda.
				System.out.print("Número: ");	num = input.nextByte(); input.nextLine();
				System.out.print("Nombre: ");	name = input.nextLine();
				System.out.print("Oficio: ");	localidad = input.nextLine();
				
				Departamentos dep = new Departamentos();
				dep.setDeptNo((byte) num);
				dep.setDnombre(name);
				dep.setLoc(localidad);
				
				session.save(dep);
				tx.commit();
			}
			catch (ConstraintViolationException e)
			{
				System.out.println("Departamento duplicado");
				System.out.printf("MENSAJE: %s%n", e.getMessage());
				System.out.printf("COD ERROR: %d%n", e.getErrorCode());		
				System.out.printf("ERROR SQL: %s%n", e.getSQLException().getMessage());
			}
		}
		
		//***** Inserta en Empleados *****
		else
		{
			System.out.println("Insertando en la tabla Empleados.");
			short num, dir;
			byte numdep;
			String name, oficio;
			float sal, com;
			try
			{
				//Lee los datos del nuevo empleado y lo guarda.
				System.out.print("Número: ");		num = input.nextShort(); input.nextLine();
				System.out.print("Nombre: ");		name = input.nextLine();
				System.out.print("Director: ");		dir = input.nextShort(); input.nextLine();
				System.out.print("Oficio: ");		oficio = input.nextLine();
				System.out.print("Salario: ");		sal = input.nextFloat();
				System.out.print("Comision: ");		com = input.nextFloat();
				System.out.print("Departamento: ");	numdep = input.nextByte(); input.nextLine();
				
				Float salario = new Float(sal);
				Float comision = new Float(com);
				Empleados em = new Empleados();
				em.setEmpNo((short) num);
				em.setApellido(name);
				em.setDir((short) dir);
				em.setOficio(oficio);
				em.setSalario(salario);
				em.setComision(comision);
				Departamentos d = new Departamentos();
				d.setDeptNo((byte) numdep);
				em.setDepartamentos(d);
				
				java.util.Date hoy = new java.util.Date();
				java.sql.Date fecha = new java.sql.Date(hoy.getTime());
				em.setFechaAlta(fecha);
			
				session.save(em);
				tx.commit();
			}
			catch (ConstraintViolationException e)
			{
				System.out.println("Empleado duplicado");
				System.out.printf("MENSAJE: %s%n", e.getMessage());
				System.out.printf("COD ERROR: %d%n", e.getErrorCode());
				System.out.printf("ERROR SQL: %s%n", e.getSQLException().getMessage());
			}
			catch (TransientPropertyValueException e)
			{
				System.out.println("El Departamento no existe");
				System.out.printf("MENSAJE: %s%n", e.getMessage());
				System.out.printf("Propiedad: %s%n", e.getPropertyName());
			}
			catch (Exception e)
			{
				System.out.println("Error no controlado.");
				e.printStackTrace();
			}
		}
	}




	@SuppressWarnings("rawtypes")
	public static void actualizar(int table)
	{
		tx = session.beginTransaction();
		//***** Modificación en Departamentos *****
		if (table==1)
		{
			System.out.println("Modificando la tabla Departamentos.");
			byte dep;
			String loc;
			
			//Lee los datos por consola y busca el departamento para modificar.
			System.out.print("Número del departamento: ");		dep = input.nextByte(); input.nextLine();
			System.out.print("Nombre de la nueva localidad: ");	loc = input.nextLine();
			Query q =
				session.createQuery("update Departamentos set loc = :nuevo where deptNo = :depnum");
			q.setParameter("nuevo", loc);
			q.setParameter("depnum", (byte)dep);
			int filas = q.executeUpdate();
			
			//Si las filas modificadas son 1 o mayor, la operación se ha completado.
			if (filas>0)
			{
				System.out.println("Se ha modificado la fila. +("+filas+")");
				tx.commit();
			}
			else {System.out.println("No se ha encontrado el departamento.");}
			
		}
		
		//***** Modificación en Empleados *****
		else
		{
			System.out.println("Modificando la tabla Empleados.");
			short emp;
			float sal;
			
			//Lee los datos por consola y busca el empleado para modificar.
			System.out.print("Número del empleado: ");	emp = input.nextShort(); input.nextLine();
			System.out.print("Nuevo salario: ");		sal = input.nextFloat();
			Query q = 
				session.createQuery("update Empleados set salario = :nuevosal where empNo = :num");
			q.setParameter("nuevosal", (float)sal);
			q.setParameter("num", (short)emp);
			int filas = q.executeUpdate();
			
			//Si las filas modificadas son 1 o mayor, la operación se ha completado.
			if (filas>0)
			{
				System.out.println("Se ha modificado la fila. +("+filas+")");
				tx.commit();
			}
			else {System.out.println("No se ha encontrado el departamento.");}
		}
	}




	@SuppressWarnings("rawtypes")
	public static void eliminar(int table)
	{
		tx = session.beginTransaction();
		//***** Eliminación en Departamentos *****
		if (table==1)
		{
			System.out.println("Eliminación en la tabla Departamentos.");
			byte dep;
			
			//Lee los datos por consola y busca el departamento para eliminar.
			System.out.print("Numero del departamento: ");	dep = input.nextByte(); input.nextLine();
			Query q = session.createQuery("delete Departamentos where deptNo = :depnum");
			q.setParameter("depnum", dep);
			int filas = q.executeUpdate();
			
			//Si las filas eliminadas son 1, la operación se ha completado.
			if (filas>0)
			{
				System.out.println("Se ha modificado la fila. +("+filas+")");
				tx.commit();
			}
			else {System.out.println("No se ha encontrado el departamento.");}
			
		}
		
		//***** Eliminación en Empleados *****
		else
		{
			System.out.println("Eliminación la tabla Empleados.");
			short emp;
			
			//Lee los datos por consola y busca el empleado para eliminar.
			System.out.print("Numero del departamento: ");	emp = input.nextShort(); input.nextLine();
			Query q = session.createQuery("delete Empleados where empNo = :num");
			q.setParameter("num", (float)emp);
			int filas = q.executeUpdate();
			
			//Si las filas eliminadas son 1, la operación se ha completado.
			if (filas>0)
			{
				System.out.println("Se ha modificado la fila. +("+filas+")");
				tx.commit();
			}
			else {System.out.println("No se ha encontrado el departamento.");}
			
		}
	}
	
	

	
	public static void clear()
	{
		System.out.println("\n\n\n\n");
	}


}

