package general;
import java.util.Scanner;


public class Base
{
	public static void clear()
	{
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\n\n\n\n");
	}
	
	public static void pressAnyKey()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nPress any key to continue.");
        try {
            System.in.read();
            input.nextLine();
        } catch (Exception e) {e.printStackTrace();}
        
        input.close();
        clear();
	}
	
	public static void createMenu(int entry, String... opts) 
	{
		String tab = "\t";
		System.out.println("\nEJERCICIOS\n");
		for (String op : opts)
		{
			System.out.println(tab+entry+". "+op+".");
			entry++;
		}
		System.out.println(tab+"0.  Salir.");
		System.out.print("\nSelecciona una opción: ");
	}
	
}