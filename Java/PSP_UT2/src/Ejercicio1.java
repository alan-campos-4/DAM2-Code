
/*
 * Implementa una simulación de la fábula que cuenta la carrera entre la liebre y la tortuga. 
 * Para hacerlo más interesante la carrera será cuesta arriba por una pista resbaladiza, 
 * de modo que a veces podrán resbalar y retroceder algunas posiciones. 
 * Habrá un thread que implementará la tortuga y otro la liebre.
 * Cada uno se suspenderá durante un segundo y luego evaluará lo que ha pasado según unas probabilidades:
 * 
 * Tortuga	Avance rápido	  50%	3 casillas a la derecha
 * 			Resbaló 		  20%	6 casillas a la izquierda
 * 			Avance lento	  30%	1 casilla a la derecha
 * 
 * Liebre	Duerme			  20%	No se mueve
 * 			Gran salto		  20%	9 casillas a la derecha
 * 			Resbalón grande	  10%	12 casillas a la izquierda
 * 			Pequeño salto	  30%	1 casilla a la derecha
 * 			Resbalón pequeño  20%	2 casillas a la izquierda
 * 
 * Calcula la probabilidad con Random, de 1 a 100, y determina que ha hecho cada animal.
 * Considera que hay 70 casillas, de la 1 a la 70, la 1 de salida y la 70 de llegada. 
 * Si resbala al principio vuelve a la 1, nunca por debajo. 
 * Tras cada segundo y después de calcular su nueva posición, imprime una línea por cada animal, 
 * con blanco de 1 a la posición -1 y luego una letra T para la tortuga y una L para la liebre. 
 * Imprime al comienzo de la carrera un mensaje. Después de imprimir las líneas, 
 * determina si alguno ha llegado a la meta y ha ganado imprimiendo un mensaje. Si ambos llegan a la vez, declara un empate.
 */

public class Ejercicio1
{
	public static void main(String[] args)
	{
		//
	}
}