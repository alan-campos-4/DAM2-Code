package ThreadWait;

public class Data
{
	private String packet;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;
	
	public synchronized void send(String packet)
	{
		while (!transfer)
		{
			try {
				System.out.println("Sending "+packet);
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Thread Interrupted");
			}
		}
		transfer = false;

		this.packet = packet;
		notifyAll();
	}
	
	public synchronized String receive()
	{
		while (transfer)
		{
			try {
				System.out.println("Receiving "+packet);
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Thread Interrupted");
			}
		}
		transfer = true;

		String returnPacket = packet;
		notifyAll();
		return returnPacket;
	}
}