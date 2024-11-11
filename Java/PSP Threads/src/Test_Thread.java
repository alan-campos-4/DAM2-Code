class LiftOff extends Thread
{
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount;

	public LiftOff() {}

	public LiftOff(int countDown)	{this.countDown = countDown;}

	public void run()
	{
		while (countDown > 0)
		{
			System.out.println("#" + id + " (" + countDown + ")");
			countDown--;
		}
		System.out.println("Lanzamiento (" + id + ")");
	}
}


public class Test_Thread
{
	public static void main(String[] args)
	{
		LiftOff launch1 = new LiftOff();
		launch1.start();
		System.out.println("Comienza la cuenta atrás!");
	}
}