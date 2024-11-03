import java.util.Scanner;

public class DigitCounter
{
	static Scanner input;
	
	/*
	 * ¿Cuántos números hay por cada cantidad de dígitos?
	 * 
	 * Sin contar el 0, los números enteros de 1 cifra son del 1 hasta el 9.
	 * Los números con 2 dígitos serían del 10 hasta el 99. Por lo que tendríamos 99-10+1=90 números con 2 dígitos.
	 * Se suma un 1 al final para que se incluyan todos los números en la diferencia.
	 * Los números con 3 dígitos serían del 100 hasta el 999. Por lo que tendríamos 999-100+1=900 números con 3 dígitos.
	 * Si repetimos con 4 dígitos tendríamos 9999-1000+1=9000 números con 4 dígitos.
	 * 
	 * Otra forma de calcular esta progresión es tomar el número más grande de una cantidad de cifras y restarle
	 * los números de cantidad de cifras inferiores
	 * Los números con 2 dígitos serían del 1 hasta el número más grande de 2 cifras (99) menos los números de 1 cifra.
	 * 		99 - 9 = 90 números de 2 cifras
	 * Los números con 3 dígitos serían del 1 hasta el 999 menos los números de 2 cifras y de 1 cifra.
	 * 		999 - 90 - 9 = 900 números de 3 cifras
	 * Los números con 4 dígitos serían del 1 hasta el 9999 menos los números de 3, 2 y 1 cifras.
	 * 		9999 - 900 - 90 - 9 = 9000 números de 4 cifras
	 * 
	 * Observamos que siempre obtenemos un número que empieza por 9 seguido de una cantidad de ceros igual a la cantidad
	 * 	de dígitos que buscamos menos 1. Esto se puede escribir como x = 9*10^(c-1)
	 * 		donde x es la cantidad de números con c cifras.
	 * 
	 * En esta clase se calcula el número de una dada cantidad de cifras de las tres formas indicadas:
	 * 	diferencial, recursiva y potencial.
	 * 
	 */
	public static void main(String[] args)
	{
		int d=0;
		input = new Scanner(System.in);
		
		System.out.print("Introduce un número de dígitos: ");
		try
		{
			d = input.nextInt();
			if (d!=0)
			{
				System.out.println("\nCon "+d+" dígito"+(d==1 ? "" : "s")+" existen");
				System.out.println("  "+Method1(d) + " (diferencial)");
				System.out.println("  "+Method2(d) + " (recursivo)");
				System.out.println("  "+Method3(d) + " (potencial)");
				System.out.println("  números posibles.");
			}
			else {System.out.print("Valor no válido.");}
		}
		catch (InputMismatchException e)	{System.out.print("Entrada no válida.");}
		catch (NumberFormatException e)		{System.out.print("Valor no válido.");}
	}
	
	
	/* Método 1: Cálculo de Resta de mínimo y máximo */
	public static int Method1(int digit)
	{
		if (digit==1)
			return 9;
		else
			return (int) (generate99(digit) - Math.pow(10, digit-1) + 1);
	}
	
	/* Método 2: Cálculo de Resta Recursiva */
	public static int Method2(int digit)
	{
		int res = generate99(digit);
		int i = 1;
		while (i<digit)
		{
			res -= (int) (9*Math.pow(10, digit-i-1));
			i++;
		}
		return res;
	}
	
	/* Método 3: Cálculo Potencial */
	public static int Method3(int digit)
	{
		return (int) (9 * Math.pow(10, digit-1));
	}
	
	
	/* Genera un número compuesto de n cifras 9 */
	public static int generate99(int n)
	{
		String res="";
		for (int i=0; i<n; i++)
		{
			res += "9";
		}
		return Integer.parseInt(res);
	}
	
	
	
	
}