
/*
 * Implementa una simulación de la fábula que cuenta la carrera entre la liebre y la tortuga. 
 * Para hacerlo más interesante la carrera será cuesta arriba por una pista resbaladiza, 
 * de modo que a veces podrán resbalar y retroceder algunas posiciones. 
 * Habrá un thread que implementará la tortuga y otro la liebre.
 * Cada uno se suspenderá durante un segundo y luego evaluará lo que ha pasado según unas probabilidades:
 * 
 * Tortuga	Avance rápido	  50%	3 casillas a la derecha
 * 			Resbaló 		  20%	6 casillas a la izquierda
 * 			Avance lento	  30%	1 casilla a la derecha
 * 
 * Liebre	Duerme			  20%	No se mueve
 * 			Gran salto		  20%	9 casillas a la derecha
 * 			Resbalón grande	  10%	12 casillas a la izquierda
 * 			Pequeño salto	  30%	1 casilla a la derecha
 * 			Resbalón pequeño  20%	2 casillas a la izquierda
 * 
 * Calcula la probabilidad con Random, de 1 a 100, y determina que ha hecho cada animal.
 * Considera que hay 70 casillas, de la 1 a la 70, la 1 de salida y la 70 de llegada. 
 * Si resbala al principio vuelve a la 1, nunca por debajo. 
 * Tras cada segundo y después de calcular su nueva posición, imprime una línea por cada animal, 
 * con blanco de 1 a la posición -1 y luego una letra T para la tortuga y una L para la liebre. 
 * Imprime al comienzo de la carrera un mensaje. Después de imprimir las líneas, 
 * determina si alguno ha llegado a la meta y ha ganado imprimiendo un mensaje. 
 * Si ambos llegan a la vez, declara un empate.
 */

import java.util.Random;

public class Ejercicio1
{
	public static Random rand;
	public static int posicionT, posicionL;
	public static final int TRACKLENGTH = 20;
	
	/* Clase abstracta que define el comportamiento de ambos animales. */
	public static abstract class AnimalThread implements Runnable
	{
		int posicion, randInt, avance;
		
		public abstract void calculoAvance();
		
		@Override
		public void run()
		{
			String threadName = Thread.currentThread().getName();
			System.out.println("[" + threadName + "] " + "Thread Started");
			rand = new Random();
			
			posicion = 1;
			
			while (posicion<TRACKLENGTH)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					System.out.println(threadName+": ");
					e.printStackTrace();
				}
				
				randInt = rand.nextInt(99)+1;
				calculoAvance();
				posicion += avance;
				
				if (posicion>TRACKLENGTH)	{posicion=TRACKLENGTH;}
				if (posicion<0)		{posicion=1;}
				
				if (threadName=="Tortuga")	{posicionT = posicion;}
				else						{posicionL = posicion;}
				printRaceTrack(threadName, posicion);
				Thread.interrupted();
			}
		}
		
		public static synchronized void printRaceTrack(String threadName, int posicion)
		{
			System.out.println("\nPosicion de "+threadName+" = "+posicion);
			
			for (int i=0; i<TRACKLENGTH+3; i++)	{System.out.print("-");}
			System.out.println("");
			
			System.out.print("|");
			for (int i=0; i<posicion; i++)
			{
				System.out.print(" ");
			}
			System.out.print(threadName.charAt(0));
			for (int i=posicion; i<TRACKLENGTH; i++)
			{
				System.out.print(" ");
			}
			System.out.println("|");
			
			for (int i=0; i<TRACKLENGTH+3; i++)	{System.out.print("-");}
			System.out.println("");
			
			if (posicion>=20)
				{System.out.println(threadName+" ha llegado al final");}
		}
		
	}
	
	/* Clase que representa el movimiento de la tortuga. */
	public static class TurtleThread extends AnimalThread
	{
		@Override
		public synchronized void calculoAvance()
		{
			if (randInt>=1 && randInt<=50)			{avance = 3;}
			else if (randInt>=51 && randInt<=80)	{avance = 6;}
			else									{avance = 1;}
		}
	}
	
	/* Clase que representa el movimiento de la liebre. */
	public static class HareThread extends AnimalThread
	{
		@Override
		public synchronized void calculoAvance()
		{
			if (randInt>=1 && randInt<=20)			{avance = 0;}
			else if (randInt>=21 && randInt<=40)	{avance = 9;}
			else if (randInt>=41 && randInt<=50)	{avance = -12;}
			else if (randInt>=51 && randInt<=80)	{avance = 1;}
			else									{avance = -2;}
		}
	}
	
	/*  */
	
	
	
	
	public static void main(String[] args)
	{
		Thread.currentThread().setName("Main");
		System.out.println(Thread.currentThread().getName());
		
		Runnable TurtleRun = new TurtleThread();
		Runnable HareRun = new HareThread();
		Thread turtle = new Thread(TurtleRun);
		Thread hare = new Thread(HareRun);
		turtle.setName("Tortuga");
		hare.setName("Liebre");
		turtle.start();
		hare.start();
		
		try
		{
			if (posicionT>TRACKLENGTH && posicionL>TRACKLENGTH)
			{
				System.out.println("--Posiciones--");
				
				
				if (posicionT==posicionL)
					{System.out.println("Ha habido un empate.");turtle.join();
					hare.join();}
				else if (posicionT>posicionL)
					{System.out.println("Ha ganado la tortuga.");hare.join();}
				else
					{System.out.println("Ha ganado la liebre.");turtle.interrupt();}
				
				turtle.join();
				hare.join();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
			System.err.println("The main thread was interrupted while waiting for " + turtle.toString() + "to finish");
		}
		System.out.println("Main thread ending");
	}
	
}