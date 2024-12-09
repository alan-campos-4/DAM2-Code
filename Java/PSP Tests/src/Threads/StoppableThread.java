package Threads;

public class StoppableThread implements Runnable
{
	private volatile boolean running = true;

	@Override
	public void run()
	{
		while (running) {
			// Perform thread tasks
			System.out.println("Thread is running...");
			try {
				Thread.sleep(1000); // Simulate work
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Restore interrupted status
			}
		}
		System.out.println("Thread has stopped.");
	}

	public void stop() {
		running = false;
	}

	public static void main(String[] args) throws InterruptedException
	{
		StoppableThread stoppableThread = new StoppableThread();
		Thread thread = new Thread(stoppableThread);
		thread.start();

		Thread.sleep(5000); // Let it run for a while
		stoppableThread.stop(); // Signal the thread to stop
		thread.join(); // Wait for the thread to finish
	}
}