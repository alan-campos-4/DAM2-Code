import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
		o Un enfoque básico sería que cada conexión atienda una sola consulta de noticias, luego se
		  cierra. O se puede mantener la conexión abierta para que el usuario consulte varias veces.
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

public class Ej5_Noticias_Servidor 
{
	public static void main(String[] args)
	{
		// 1. Crear ServerSocket (puerto 5004).
		// 2. Bucle infinito que acepte conexiones (accept()).
		// 3. Por cada cliente:
		//		- Enviar menú de categorías.
		//		- Leer opción del cliente.
		// 		- Enviar noticias de la categoría correspondiente.
		//		- Cerrar o mantener la conexión según la lógica deseada.
		
		try
		{
			Socket S5 = null;
			ServerSocket SS5 = new ServerSocket(5004);
			BufferedReader in = null;
			PrintWriter out = null;
			System.out.println("Listening to port "+SS5.getLocalPort()+"...");
			
			while (true)
			{
				S5 = SS5.accept();
				System.out.println("Client connected.");
				
				in = new BufferedReader(new InputStreamReader(S5.getInputStream()));
				out = new PrintWriter(S5.getOutputStream(), true);
				
				out.println("1. Deportes");
				out.println("2. Tecnología");
				out.println("3. Entrenimiento");
				out.println("4. Salir");
				
				int categoria = Integer.parseInt(in.readLine().replaceAll("","").replaceAll("\\s+","").trim());
				
				do {
					if (categoria==4) 	{}
					if (categoria>=1 && categoria<=3)
					{
						out.println(getNoticias(categoria));
					}
					else
					{
						System.out.println("Opción no válida.");
					}
				} while (categoria!=4);
				break;
			}
			
			in.close();
			out.close();
			S5.close();
			SS5.close();
		}
		catch (IOException e)	{e.printStackTrace();}
	}
	
	// Método para obtener las noticias de una categoría:
	private static String getNoticias(int categoria)
	{
		switch (categoria)
		{
			case 1:	return "Estas son noticias de deportes...";
			case 2:	return "Estas son noticias de tecnología...";
			case 3:	return "Estas son noticias de entretenimiento...";
		}
		return "";
	}
	
}

