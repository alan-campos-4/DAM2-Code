import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***** EJERCICIO 5: Servidor de Noticias “Breaking News” *****
Objetivo:
Implementar un servidor que ofrezca categorías de noticias (por ejemplo, “Deportes”, “Tecnología”,
“Entretenimiento”) y que el cliente, tras conectarse, seleccione una categoría y reciba los titulares
correspondientes.

	1. Servidor de Noticias:
		o De nuevo, se utiliza un ServerSocket para escuchar en un puerto (p. ej., 5004).
		o Una vez que un cliente se conecta, el servidor le envía un menú de opciones
		  (p. ej., “1. Deportes, 2. Tecnología, 3. Entretenimiento, 4. Salir”).
		o El cliente elige una opción (envía “1”, “2”, “3”, etc.), el servidor interpreta esa opción y
		  responde con las noticias o titulares correspondientes.
		o Se puede emplear una estructura de datos interna (por ejemplo, un Map o switch-case)
		  que asocia cada categoría con una lista de titulares.
	2. Cliente de Noticias:
		o Se conecta con un Socket.
		o Lee el menú de categorías que envía el servidor (varias líneas).
		o El usuario elige la categoría, el cliente envía esa elección al servidor.
		o Muestra las “noticias” recibidas y finaliza (o vuelve a preguntar al usuario si desea otra
		  categoría, según se diseñe el flujo).
	3. Consideraciones:
		o Un enfoque básico sería que cada conexión atienda una sola consulta de noticias, luego se cierra. 
		  O se puede mantener la conexión abierta para que el usuario consulte varias veces.
		o Prever que el usuario pueda introducir opciones no válidas (¿qué hace el servidor en ese
		  caso?).
		o Cerrar la conexión cuando la opción sea “salir”.
	4. Pistas Teóricas:
		o Podrás usar métodos como out.println(...) para enviar varias líneas con el menú. El
		  cliente usará readLine() repetidamente para leerlas.
		o Gestión de la entrada de la opción elegida, por ejemplo:
			String opcion = in.readLine();
			switch (opcion) {
				case "1":
				// noticias de deportes
				break;
				// ...
			}
		o Al finalizar, socket.close() para cerrar la conexión.
 */

public class Ej5_Server
{
	// 1. Crear ServerSocket (puerto 5004).
	// 2. Bucle infinito que acepte conexiones (accept()).
	// 3. Por cada cliente:
	//		- Enviar menú de categorías.
	//		- Leer opción del cliente.
	// 		- Enviar noticias de la categoría correspondiente.
	//		- Cerrar o mantener la conexión según la lógica deseada.
	
	private static final Map<String, List<String>> noticias = new HashMap<>();
	
    public static void main(String[] args)
    {
        //Inicializar las noticias por categoría.
        noticias.put("1", Arrays.asList("111111", "11111"));
        noticias.put("2", Arrays.asList("22222", "2222"));
        noticias.put("3", Arrays.asList("33", "33333333"));

        
        try (ServerSocket serverSocket = new ServerSocket(5004))
        {
            while (true)
            {
            	System.out.println("Listening to port "+serverSocket.getLocalPort()+"...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                
                try (//El stream de entrada del socket, para recibir del cliente.
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					//El stream de salida del socket, para enviar al cliente.
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);)
				{
					while (true)
					{
						//Muestra las categorías al cliente.
						out.println("--- Noticicas ---");
						out.println("1. Deportes");
						out.println("2. Tecnología");
						out.println("3. Entretenimiento");
						out.println("4. Salir");
						out.println("\nSeleccione una categoría:");

						//Recibe la opción del cliente
						String opcion = in.readLine();

						//Si la opción existe dentro del Hash,
						if (noticias.containsKey(opcion))
						{
							//Muestra todos los titulares de la categoria;
							out.println("Titulares:");
							for (String titular : noticias.get(opcion))
							{
								out.println("- " + titular);
							}
							out.println();
						}
						else if ("4".equals(opcion))
							{break;}
						else
							{out.println("Error. Opción no válida.");}
					}
					socket.close();
				}
			}
		}
        catch (SocketException e)	{System.err.println("Error. Se ha perdido la conexión con el socket.");}
        catch (IOException e)		{e.printStackTrace();}
    }

}

