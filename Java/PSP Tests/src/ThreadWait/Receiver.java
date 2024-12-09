package ThreadWait;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable
{
	private Data load;

	public Receiver(Data d)
	{
		this.load = d;
	}

	public void run()
	{
		for (String receivedMessage = load.receive(); 
			!receivedMessage.equals("End");
			receivedMessage = load.receive())
		{
			System.out.println(receivedMessage);

			// Thread.sleep() to mimic heavy server-side processing
			try
			{
				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
			}
			catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				System.err.println("Thread Interrupted");
			}
		}
	}
}