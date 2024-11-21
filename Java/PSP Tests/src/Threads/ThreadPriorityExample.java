package Threads;

class ThreadPriority extends Thread
{
	private int c = 0;
	private boolean stopHilo = false;
	
	public long getContador()	{return c;}
	
	public void pararHilo()		{stopHilo = true;}
	
	@Override
	public void run()
	{
		while (!stopHilo) c++;
	}
}
	
public class ThreadPriorityExample
{
	public static void main(String args[])
	{
		ThreadPriority h1 = new ThreadPriority();
		ThreadPriority h2 = new ThreadPriority();
		ThreadPriority h3 = new ThreadPriority();
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		h1.start();
		h2.start();
		h3.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		System.out.println("h2 (Prio. Máx: "+h2.getContador());
		System.out.println("h1 (Prio. Normal: "+h1.getContador());
		System.out.println("h3 (Prio. Mínima: "+h3.getContador());
	}
}
