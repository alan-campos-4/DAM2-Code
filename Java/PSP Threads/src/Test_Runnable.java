
class LifOff implements Runnable
{
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount;

	public LifOff() {}

	public LifOff(int countDown)	{this.countDown = countDown;}

	@Override
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


public class Test_Runnable
{
	public static void main(String[] args)
	{
		LifOff launch = new LifOff();
		launch.run();
		System.out.println("Comienza la cuenta atrás!");
	}
}