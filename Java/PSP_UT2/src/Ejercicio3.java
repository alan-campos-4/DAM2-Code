
/*
 * Descripción
 * 
 * El objetivo de este programa es simular un juego de adivinanza de números en el que varios jugadores, 
 * representados por hilos (threads), compiten para adivinar un número secreto generado aleatoriamente.
 * El juego se desarrolla de la siguiente manera:
 * 
 * Descripción General del Juego:
 *  Número Secreto: Se genera un número aleatorio entre 1 y 10 utilizando la fórmula:
 * 		numeroSecreto = 1 + (int) (10 * Math.random());
 *  Jugadores: Varios hilos representan a los jugadores que intentan adivinar el número secreto.
 *  Árbitro: Un hilo especial actúa como árbitro, controlando el flujo del juego, 
 * verificando las conjeturas de los jugadores y determinando a quién le toca jugar.
 */

/*
Funcionamiento Detallado del Juego:

 Inicio del Juego:
	o El árbitro genera el número secreto y establece el primer turno.
	o Los jugadores están listos y comienzan a ejecutar sus hilos.
 Desarrollo de Turnos:
	o Solo el jugador cuyo idJugador coincide con el turno actual puede realizar una jugada.
	o Los demás jugadores esperan hasta que sea su turno.
	o Después de cada jugada, el árbitro actualiza el turno al siguiente jugador en orden secuencial.
		· Si el último jugador ha jugado, el turno vuelve al jugador 1.
 Realización de Jugadas:
	o Cuando es su turno, el jugador genera un número aleatorio como su intento.
	o Llama al método realizarJugada del árbitro para comprobar su conjetura.
	o El árbitro verifica si el número es correcto y actualiza el estado del juego.
 Finalización del Juego:
	o Si un jugador adivina correctamente el número secreto:
		· El árbitro establece juegoTerminado a true.
		· Anuncia al ganador y termina el juego.
	o Los demás jugadores, al verificar arbitro.isJuegoTerminado(), finalizarán su ejecución.
 */

/*
Consideraciones Técnicas:

 Sincronización y Concurrencia:
	o El uso de métodos sincronizados es crucial para evitar conflictos entre hilos.
	o Garantiza que las operaciones críticas (como verificar el turno y actualizar el estado del juego) 
	se realicen de manera atómica.
 Eficiencia:
	o Para evitar que los hilos consuman demasiados recursos mientras esperan su turno, 
	  se puede implementar un mecanismo de espera:
		· Utilizar wait() y notifyAll() dentro del árbitro para notificar a los jugadores cuando es su turno.
		· Los jugadores llamarían a wait() si no es su turno y serían notificados cuando el turno cambie.
 Escalabilidad:
	o El programa está diseñado para un número variable de jugadores.
	o Es fácilmente adaptable para añadir más jugadores sin cambios significativos en el código.
 Robustez y Manejo de Excepciones:
	o Se deben manejar posibles excepciones, como interrupciones de hilos.
	o Validar entradas y asegurar que los identificadores de jugadores y números jugados sean válidos.
 */

import java.util.ArrayList;


public class Ejercicio3
{
	static ArrayList<Jugador> lista;
	
	
	/* Genera un número aleatorio. */
	public static int generarNumeroSecreto()	{return (1 + (int)(10 * Math.random()));}
	
	
	/* . */
	public static class Arbitro
	{
		int numJugadores;		//Número total de jugadores en el juego.
		int turno;				//Identificador del jugador que jugará en el turno actual.
		int numeroSecreto;		//El número que los jugadores intentan adivinar.
		boolean juegoTerminado;	//Variable booleana que indica si el juego ha concluido.
		
		public Arbitro(int num, int turn)
		{
			this.numJugadores = num;
			this.numeroSecreto = generarNumeroSecreto();
			this.turno = turn;
			this.juegoTerminado = false;
		}
		
		//Devuelve el identificador del jugador al que le toca jugar.
		int getTurno()				{return this.turno;}
		
		//Indica si el juego ha terminado.
		boolean isJuegoTerminado()	{return this.juegoTerminado;}
		
		/* 		 Verifica si es el turno del jugador que hace la jugada.
		 * 		 Comprueba si el numeroJugado coincide con el numeroSecreto.
		 * 		 Si coincide, establece juegoTerminado a true y anuncia al ganador.
		 * 		 Si no, informa al jugador que no ha acertado.
		 * 		 Actualiza el turno al siguiente jugador en orden secuencial.
		 * Importancia de synchronized:
		 * 		 Al ser un método sincronizado, garantiza que solo un jugador pueda ejecutar realizarJugada()
		 * 		a la vez, evitando condiciones de carrera y asegurando la integridad del juego.
		 */
		synchronized void realizarJugada(int idJugador, int numeroJugado)
		{
			if (idJugador==turno)
			{
				if (numeroJugado==numeroSecreto)
				{
					juegoTerminado = true;
					System.out.println("El jugador " + idJugador + " es el ganador");
				}
				else
					{ System.out.println("El jugador " + idJugador + " no ha acertado"); }
			}
			Thread.yield();
			//else {Thread.onSpinWait();}
		}
	}
	
	
	/* . */
	public static class Jugador extends Thread
	{
		int idJugador;		//Identificador único del jugador.
		Arbitro arbitro;	//Referencia al objeto Árbitro compartido entre todos los jugadores.
		
		public Jugador(int id, Arbitro Arb)
		{
			this.idJugador = id;
			this.arbitro = Arb;
		}
		
		/* o Método run():
		 * 	 Mientras el juego no haya terminado (arbitro.isJuegoTerminado() es false):
		 * 	 Verifica si es su turno consultando arbitro.getTurno().
		 * 	 Si es su turno:
		 * 		 Genera un número aleatorio entre 1 y 10 para intentar adivinar el número secreto:
		 * 			arduino
		 * 			Copiar código
		 * 			int numeroJugado = 1 + (int) (10 * Math.random());
		 * 		 Llama al método arbitro.realizarJugada(idJugador, numeroJugado) para realizar su intento.
		 * 		 Si no es su turno, el hilo puede dormir brevemente para evitar consumir recursos innecesarios.
		 * o Comportamiento del Hilo:
		 * 		 Cada jugador actúa independientemente, pero sincroniza sus acciones a través del árbitro.
		 * 		 Al compartir el mismo objeto Árbitro, los jugadores coordinan sus turnos y acciones.
		 */
		public void run()
		{
			while (!arbitro.isJuegoTerminado())
			{
				if (idJugador==arbitro.getTurno())
				{
					//this.notify();
					int numeroJugado = generarNumeroSecreto();
					arbitro.realizarJugada(idJugador, numeroJugado);
				}
				else
				{
//					try
//					{
//						this.wait();
//					}
//					catch (InterruptedException e)	{e.printStackTrace();}
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args)
	{
		/* 
		 * 3. Clase Main:
		 * 	Es el punto de entrada del programa y se encarga de inicializar el juego y los jugadores.
		 * 		o Método main():
		 * 			 Define el número de jugadores que participarán en el juego (por ejemplo, 3 jugadores).
		 * 			 Crea una instancia del Árbitro, pasándole el número de jugadores.
		 * 			 Crea y lanza los hilos de los jugadores:
		 * 				 Para cada jugador:
		 * 					 Asigna un idJugador único.
		 * 					 Crea una instancia de Jugador, pasándole su idJugador y el objeto arbitro.
		 * 					 Inicia el hilo del jugador llamando a start().
		 * 			 Opcionalmente, espera a que todos los hilos de los jugadores terminen utilizando join().
		 */
		Arbitro arb = new Arbitro(3, 147147);
		Jugador P1 = new Jugador(147147, arb);
		Jugador P2 = new Jugador(258258, arb);
		Jugador P3 = new Jugador(369369, arb);
		P1.setPriority(1);
		P2.setPriority(2);
		P3.setPriority(3);
		
		lista = new ArrayList<>();
		lista.add(P1);
		lista.add(P2);
		lista.add(P3);
		
		P1.start();
		P2.start();
		P3.start();
		
		try
		{
			P1.join();
			P2.join();
			P3.join();
		}
		catch (InterruptedException e)	{e.printStackTrace();}
	}
	
	
	
	
}
