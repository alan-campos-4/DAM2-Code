
/*
 * Implementa una barrera. Una barrera es un punto de sincronización entre varios threads. 
 * Se caracteriza porque los threads que van llegando a ella esperan hasta que llega el último. 
 * Por ejemplo, se pueden sincronizar N threads y hasta que el último no llegue los demás no deben poder continuar. 
 * Prueba a lanzar unos pocos threads, por ejemplo 4, cada uno que espere un tiempo proporcional a su identificador, 
 * y que luego imprima un mensaje que lo identifique y que luego espere en la barrera a los otros threads.
 * Para simular una situación más real en el código de entrega del ejercicio 
 * debe haber las siguientes modificaciones de la prueba anterior:
 */

/*
Se deben lanzar 30 hilos con:
1. Subtareas Dinámicas:
	 Cada hilo realiza un número aleatorio de subtareas (entre 5 y 20) antes de llegar a la barrera.
	 Esto simula un escenario más realista donde los hilos tienen diferentes cantidades de trabajo.
2. Tiempos de Trabajo Aleatorios:
	 El tiempo de cada subtarea se genera aleatoriamente entre 500 y 2500 ms.
	 Esto asegura que los hilos no lleguen a la barrera en un orden predecible.
3. Información Detallada:
	 Los hilos informan sobre qué tarea están realizando y cuánto tiempo les tomará.
Como ayuda, puedes usar CyclicBarrier que es una clase en Java que pertenece al paquete java.util.concurrent. 
Es una herramienta de sincronización que permite que un conjunto de hilos 
esperen entre sí en un punto común de ejecución antes de continuar. 
Es especialmente útil cuando se desea realizar tareas en paralelo y sincronizar los hilos 
en un momento determinado antes de avanzar a la siguiente etapa del programa.
 */

/*
Características principales de CyclicBarrier:
1. Número fijo de hilos: 
	Se especifica un número fijo de hilos en el momento de crear la barrera.
	Este número indica cuántos hilos deben alcanzar la barrera antes de que todos puedan continuar.
2. Uso cíclico: 
	A diferencia de otras herramientas como CountDownLatch, que no puede reutilizarse,
	CyclicBarrier es reutilizable. Después de que todos los hilos alcanzan la barrera y continúan, 
	la barrera puede ser reutilizada.
3. Tarea opcional al final: 
	Puede ejecutar una tarea adicional (llamada "barrier action") 
	una vez que todos los hilos llegan a la barrera, antes de permitirles continuar.
	
Constructor de CyclicBarrier:
 CyclicBarrier(int parties)
	o Crea una barrera que se activará cuando el número especificado de hilos (parties) llame a await().
 CyclicBarrier(int parties, Runnable barrierAction)
	o Igual que el anterior, pero además ejecuta la acción (barrierAction) en un hilo 
	  una vez que todos los hilos han llegado a la barrera.
 */

/*
Métodos clave:
1. await()
	o Se llama desde un hilo cuando este llega a la barrera.
	o El hilo queda bloqueado hasta que todos los hilos especificados en la barrera lleguen a este punto.
2. getParties()
	o Devuelve el número de hilos registrados en la barrera.
3. getNumberWaiting()
	o Devuelve el número de hilos que actualmente están esperando en la barrera.
4. reset()
	o Reinicia la barrera, liberando a los hilos que esperan y permitiendo que la barrera sea reutilizada.
 */

/*
Ventajas:
	1. Fácil sincronización de hilos en un punto común.
	2. Reutilización en múltiples fases de un programa paralelo.
	3. Permite agregar una tarea adicional (opcional) al final de cada ciclo.
	
Casos de uso:
	 Simulaciones paralelas.
	 Procesamiento por etapas donde los hilos deben sincronizarse entre fases.
	 Cualquier situación en la que un conjunto de hilos necesite un punto de encuentro antes de continuar.	 
 */


public class Ejercicio2
{
	public static void main(String[] args)
	{
		//
	}
}