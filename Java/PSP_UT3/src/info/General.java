package info;

import java.util.Scanner;

public class General
{
	/* Puertos y explicaciones de cada ejercicio.*/
	
	
	/***** EJERCICIO 1: Servidor Echo "Saludo Exprés" *****
		
		PUNTOS CLAVE
		1. Componente Servidor:
			o Deberá utilizar la clase ServerSocket (de la librería java.net) para abrir un puerto y 
			  “ponerse a la escucha” (listen).
			o Cuando llega un cliente, se invoca el método accept(), que devuelve un objeto Socket.
			o Flujos de entrada y salida (InputStream y OutputStream) se obtienen directamente desde 
			  el objeto Socket. Esto permite la comunicación con el cliente.
			o Posteriormente, se pueden manipular estos flujos con InputStreamReader, BufferedReader, 
			PrintWriter o similar, para facilitar el trabajo con cadenas de texto.
		2. Componente Cliente:
			o Se conectará al servidor empleando la clase Socket de java.net, con la IP del servidor 
			  (por ejemplo, 127.0.0.1 si es local) y el puerto en que el servidor está escuchando.
			o Tras establecerse la conexión (creación del Socket), se podrá escribir y leer a través de los 
			  flujos de E/S con los métodos getOutputStream() y getInputStream().
		3. Intercambio de Mensajes:
			o El cliente enviará una cadena (p. ej. “Hola servidor”).
			o El servidor recibirá esa cadena, le añadirá “Hola, recibí tu mensaje: ” y la devolverá.
			o El cliente mostrará en pantalla la respuesta devuelta por el servidor.
		4. Consideraciones:
			o Cerrar adecuadamente los sockets y los flujos.
			o Manejar excepciones de tipo IOException, que son comunes en operaciones de red.
			o Utilizar un bucle en el servidor para permitir que escuche conexiones sucesivas 
			  (o continuar indefinidamente).
		
		PISTAS TEÓRICAS
			o ServerSocket serverSocket = new ServerSocket(5000); // Abre el puerto 5000 para escuchar.
			o Socket clientSocket = serverSocket.accept(); // Acepta una conexión y devuelve el socket del cliente.
			o Para manejar cadenas de texto, se puede emplear:
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			  Donde true en el PrintWriter habilita el auto-flush.
	*/
	public static final int PortSaludo = 5000;
	
	/***** EJERCICIO 2: Calculadora Remota *****
		
		PUNTOS CLAVE
		1. Comunicación de Comandos:
			o El cliente enviará una cadena con el formato:
			  OPERACION OPERANDO1 OPERANDO2
			  Ejemplos:
			  	 SUMA 4 5
			  	 RESTA 10 3
			  	 MULTIPLICA 7 2
			  	 DIVIDE 9 3
	  	2. Servidor:
			o Recibe la cadena y la parsea (divide) en varias partes usando, por ejemplo,
				String.split(" ").
			o Realiza la operación correspondiente:
				 SUMA -> op1 + op2
				 RESTA -> op1 - op2
				 etc.
			o Devuelve el resultado como cadena.
			o Debe pensar en casos especiales, por ejemplo, división entre cero.
		3. Cliente:
			o Pide la operación por consola o la tiene codificada.
			o Envía el texto al servidor, lee la respuesta y la muestra.
		4. Consideraciones:
			o Validar que se reciben 3 partes de la cadena (operación y dos números).
			o Manejar la conversión de String a double o int.
			o Controlar posibles excepciones como NumberFormatException.
			o Manejar la respuesta del servidor y errores (ej. “Error: división entre cero”).
			o Cerrar los recursos.
		
		PISTAS TEÓRICAS
			 El servidor seguirá usando un ServerSocket.
			 Para cada conexión (vía accept()), se tendrá un Socket.
			 Lectura: BufferedReader + readLine() para recibir el comando.
			 Escritura: PrintWriter + println() para enviar el resultado.
	*/
	public static final int PortCalculadora = 5001;
	
	/***** EJERCICIO 3: Juego de “Adivina el Número”  *****
		
		PUNTOS CLAVE
		1. Servidor:
			o Crea un número aleatorio (por ejemplo, usando java.util.Random).
			o Espera conexiones de un cliente.
			o Cuando llega un intento (un número que manda el cliente), compara con el número secreto:
				 Si el intento es menor, responde “Mayor”.
				 Si el intento es mayor, responde “Menor”.
				 Si acierta, responde “¡Acertaste!” y podría finalizar la partida o reiniciarla.
			o A continuación, el servidor podría (opcionalmente) permitir un nuevo juego o cerrar la conexión.
		2. Cliente:
			o Se conecta, muestra un mensaje de bienvenida o instrucciones al usuario (por consola).
			o Solicita al usuario un número.
			o Envía ese número al servidor y lee la respuesta.
			o Continúa hasta que el servidor responda “¡Acertaste!” o hasta que decida dejar de jugar.
		3. Bucles de Comunicación:
			o Tanto servidor como cliente se mantendrán en un bucle leyendo y escribiendo 
			  (request-response) hasta que se alcance la condición de fin del juego.
			o Cerrar adecuadamente los recursos al terminar.
		4. Manejo de Errores:
			o El cliente podría enviar algo que no sea un número.
			  Se podría controlar con Integer.parseInt(...) rodeado de un try/catch.
			o El servidor o el cliente pueden desconectarse abruptamente, generando IOException.
			  Manejar esas excepciones con cuidado.
		5. Puntos Didácticos:
			o Uso de un while para controlar la persistencia de la partida.
			o Separación de lógica: el servidor contiene la “lógica del juego” (comparaciones) 
			  y el cliente la “interfaz de usuario” (pedir datos por consola y mostrar respuestas).
			o Introducir la idea de “código bloqueante”: accept(), readLine(), etc. pueden bloquear la ejecución 
			  si no hay conexiones o si no llega más texto.
		
		PISTAS TEÓRICAS
			 Random rand = new Random();
				int numeroSecreto = rand.nextInt(100) + 1; // Genera entero entre 1 y 100.
			 Lectura de cadenas: String entrada = in.readLine();
			 Conversión a número: int intento = Integer.parseInt(entrada);
			 Comparación y respuesta: out.println("Mayor"); o out.println("¡Acertaste!");
	*/
	public static final int PortNumero = 5002;
	
	
	
	/* Variables y clases generales. */
	public static Scanner input = new Scanner(System.in);
	public static final String Host = "127.0.0.1";
	
	
	/* Funciones generales para mostrar el estado de la comunicación entre sockets. */
	public static void listening(int port)
	{
		System.out.println("Escuchando al puerto "+port+"...");
	}
	public static void connected()
	{
		System.out.println("Client connected!");
	}
	
	
	
}

