package Threads;

import java.util.Random;

public class ThreadInterruptExample
{
	static Random rand;
	static final int TRACKLENGTH = 20;
	
	public static int calculoAvance()
	{
		rand = new Random();
		int randInt = rand.nextInt(99)+1;
		if (randInt>=1 && randInt<=50)			{return 3;}
		else if (randInt>=51 && randInt<=80)	{return 6;}
		else									{return 1;}
	}
	
	public static void main(String[] args)
	{
		final Thread subject1 = new Thread(new Runnable()
		{
			public synchronized void run()
			{
				int pos = 1;
				while (pos<TRACKLENGTH)
				{
					pos += calculoAvance();
					System.out.println(Thread.currentThread().getName()+" - Posicion "+pos);
					
					if (pos>=TRACKLENGTH)
					{
						while (!Thread.interrupted()) {
							Thread.yield();
						}
					}
				}
				
				
				System.out.println(Thread.currentThread().getName()+" stopped!");
			}
		});
		final Thread subject2 = new Thread(new Runnable()
		{
			public synchronized void run()
			{
				int pos = 1;
				while (pos<TRACKLENGTH)
				{
					pos += calculoAvance();
					System.out.println(Thread.currentThread().getName()+" - Posicion "+pos);
				}
				
				//while (!Thread.interrupted()) {
					//Thread.yield();
				//}
				System.out.println(Thread.currentThread().getName()+" stopped!");
			}
		});
		final Thread coordinator = new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("coordinator stopping!");
				subject1.interrupt();
				subject2.interrupt();
			}
		});

		subject1.start();
		subject2.start();
		coordinator.start();
	}
}
