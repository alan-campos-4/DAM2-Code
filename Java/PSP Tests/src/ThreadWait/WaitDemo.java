package ThreadWait;

//Java Program to demonstrate usage of wait() and notify()

class demo
{
	// variable to check if part1 has returned
	// volatile used to prevent threads from
	// storing local copies of variable
	volatile boolean part1done = false;

	// method synchronized on this
	// i.e. current object of demo
	synchronized void part1()
	{
		System.out.println("Thread t1 running");
		part1done = true;
		System.out.println("Thread t1 about to surrender lock");
		notify(); //notify the waiting thread, if any
	}

	// method synchronized on this
	// i.e. current object of demo
	synchronized void part2()
	{
		// loop to prevent spurious wake-up
		while (!part1done)	
		{
			try
			{
				System.out.println("Thread t2 waiting");
				
				wait();// wait till notify is called
				
				System.out.println("Thread t2 running again");
			}
			catch (Exception e)	{System.out.println(e.getClass());}
		}
		System.out.println("Thread t2 finished");
	}
}

public class WaitDemo
{
	public static void main(String[] args)
	{
		// Make an instance of demo class
		demo obj = new demo();

		// Thread t1 will call part1()
		Thread t1 = new Thread(new Runnable() {
			public void run() { obj.part1(); }
		});

		// Thread t2 will call part2()
		Thread t2 = new Thread(new Runnable() {
			public void run() { obj.part2(); }
		});

		// Start t2 and then t1
		t2.start();
		t1.start();
	}
}

