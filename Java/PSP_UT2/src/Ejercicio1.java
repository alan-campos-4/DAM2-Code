
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
	public static Random rand = new Random();
	public static final int TRACK_LENGTH = 20;	//Longitud de la carrera.
	
	
	/* Clase abstracta que define el comportamiento de ambos animales. */
	public static abstract class AnimalThread implements Runnable
	{
		private volatile boolean running = true; //Determina si el animal está corriendo o no.
		private int posicion;					 //La posición del animal en la carrera.
		
		public int getPos()			{return posicion;}	//Devuelve la posicion del animal.
		public boolean isRunning()	{return running;}	//Devuelve si el animal está corriendo.
		public void stop()			{running = false;}	//Detiene al animal.
		
		public abstract int calculoAvance();	 // Devuelve cuánto avanza la posicion del animal.
		
		/* Ejecuta el movimiento del animal */
		@Override
		public void run()
		{
			String threadName = Thread.currentThread().getName();
			System.out.println("[" + threadName + "] " + "Thread Started");
			
			posicion = 1;
			printRaceTrack(threadName, posicion);
			
			while (running)
			{
				posicion += calculoAvance();
				
				if (posicion>TRACK_LENGTH)	{posicion=TRACK_LENGTH;}
				if (posicion<0)		{posicion=1;}
				
				try {Thread.sleep(1000);}
				catch (InterruptedException e) {e.printStackTrace();}
				
				printRaceTrack(threadName, posicion);
			}
			
		}
		
		/* Imprime el recorrido de la carrera y la posicion del animal en él. */
		public static synchronized void printRaceTrack(String threadName, int posicion)
		{
			System.out.println("\nPosicion de "+threadName+" = "+posicion);
			
			for (int i=0; i<TRACK_LENGTH+3; i++)	{System.out.print("-");}
			System.out.println("");
			
			System.out.print("|");
			for (int i=0; i<posicion; i++)
			{
				System.out.print(" ");
			}
			System.out.print(threadName.charAt(0));
			for (int i=posicion; i<TRACK_LENGTH; i++)
			{
				System.out.print(" ");
			}
			System.out.println("|");
			
			for (int i=0; i<TRACK_LENGTH+3; i++)	{System.out.print("-");}
			System.out.println("");
		}
		
	}
	
	/* Clase que representa el movimiento de la tortuga. */
	public static class TurtleThread extends AnimalThread
	{
		@Override
		public synchronized int calculoAvance()
		{
			int randInt = rand.nextInt(99)+1;
			if (randInt>=1 && randInt<=50)			{return 3;}
			else if (randInt>=51 && randInt<=80)	{return 6;}
			else									{return 1;}
		}
	}
	
	/* Clase que representa el movimiento de la liebre. */
	public static class HareThread extends AnimalThread
	{
		@Override
		public synchronized int calculoAvance()
		{
			int randInt = rand.nextInt(99)+1;
			if (randInt>=1 && randInt<=20)			{return 0;}
			else if (randInt>=21 && randInt<=40)	{return 9;}
			else if (randInt>=41 && randInt<=50)	{return -12;}
			else if (randInt>=51 && randInt<=80)	{return 1;}
			else									{return -2;}
		}
	}
	
	
	
	
	/* Función Main*/
	public static void main(String[] args)
	{
		TurtleThread TurtleRunnable = new TurtleThread();
		HareThread HareRunnable = new HareThread();
		Thread turtle = new Thread(TurtleRunnable);
		Thread hare = new Thread(HareRunnable);
		turtle.setName("Tortuga");
		hare.setName("Liebre");
		turtle.start();
		hare.start();
		
		System.out.println("Empieza la carrera!");
		
		try
		{
			//Mientras los hilos estén ejecutándose,
			while (TurtleRunnable.isRunning() && HareRunnable.isRunning())
			{
				// si alguno de los animales ha llegado al final,
				if (TurtleRunnable.getPos()>=TRACK_LENGTH || HareRunnable.getPos()>=TRACK_LENGTH)
				{
					// termina la ejecución de ambos hilos
					TurtleRunnable.stop();
					HareRunnable.stop();
					turtle.join();
					hare.join();
					System.out.println("\n\nLa carrera ha terminado.");
					
					// y muestra el ganador.
					if (TurtleRunnable.getPos()>=TRACK_LENGTH && HareRunnable.getPos()>=TRACK_LENGTH)
						System.out.println("Ha habido un empate!!");
					else if (TurtleRunnable.getPos()>=TRACK_LENGTH)
						System.out.println("Ha ganado la tortuga!");
					else
						System.out.println("Ha ganado la liebre!");
				}
			}
		}
		catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
}