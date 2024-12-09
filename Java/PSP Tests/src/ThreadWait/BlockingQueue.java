package ThreadWait;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T>
{
	private Queue<T> queue = new LinkedList<T>();
	private int capacity;

	public BlockingQueue(int capacity)
	{
		this.capacity = capacity;
	}

	public synchronized void put(T element) throws InterruptedException
	{
		while (queue.size() == capacity) {
			wait();
		}

		queue.add(element);
		notify(); // notifyAll() for multiple producer/consumer threads
	}

	public synchronized T take() throws InterruptedException
	{
		while (queue.isEmpty()) {
			wait();
		}

		T item = queue.remove();
		notify(); // notifyAll() for multiple producer/consumer threads
		return item;
	}
	
	
	
	
	public static void main(String[] args)
	{
		BlockingQueue<Integer> q = new BlockingQueue<>(5);
		try
		{
			q.put(1);
			q.put(2);
			q.put(3);
			q.put(4);
			q.put(5);
		}
		catch (InterruptedException e)	{e.printStackTrace();}
	}
	
}
