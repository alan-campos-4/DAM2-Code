package ejB;

import java.util.ArrayList;

/*
Ana es una apasionada de la montaña y del trekking. 
Está en contacto con una marca de relojes que monitorizan nuestra actividad y el resultado, y, 
mediante una aplicación para el teléfono de la que dispone, 
nos permite exportar el seguimiento de la actividad en un formato JSON.

{
	"name":
	"date":
	"trackPoints": [
		{
			"lng": -0.213694
			"time": "Sat Sep 05 05:18:48 CEST 2020"
			"lat": 39.010751
			"ele": 22.2999992370605
		},
		{
			"lng": -0.213694
			"time": "Sat Sep 05 05:18:51 CEST 2020"
			"lat": 39.010733
			"ele": 22
		}
	]
}


Como puede comprobarse, se incorpora una fecha de realización, y el nombre de la actividad.
La información general se obtiene de un array de trackPoints, 
donde se almacena la posición capturada por el reloj. Básicamente, 
se almacena la longitud y latitud (lng y lat), la elevación del terreno (ele) 
y el momento en el que se ha efectuado dicha medición (time).
Hay que implementar, por una parte, una clase TrackPoint, que contendrá dicha información. 
La clase deberá contener los métodos habituales, junto con un constructor general. 
Deberá añadir también un método que calcule la distancia en metros entre dos Trackpoint, 
para ayudarnos en el programa principal.

Se pide realizar un programa que calcule:
1.	Elevación máxima y mínima.
2.	Genera una exportación a un fichero XML como aparece a continuación:
 */


public class EjercicioB
{
	public static class Libro
	{
		int id;
		String title;
		String author;
		double price;
		String date;
		
		public Libro(int c, String t, String a, double p, String d)
		{
			this.id = c;
			this.title = t;
			this.author = a;
			this.price = p;
			this.date = d;
		}
		public void display()
		{
			System.out.println(id);
	    	System.out.println("  "+title);
	    	System.out.println("  "+author);
	    	System.out.println("  "+date);
	    	System.out.println();
		}
	}
	
	public static ArrayList<Libro> ListaLibros;
	
	public static void main(String[] args)
	{
		leerArchivo();
		mostrarLibros();
		agregarLibro();
	}
	
	
	
	
	/* Leer el archivo XML y deserializarlo en objetos Java. */
	public static void leerArchivo()
	{
		//
	}
	
	
	/* Mostrar la información de los libros en la consola. */
	public static void mostrarLibros()
	{
		//
	}
	
	
	/* Agregar un nuevo libro al catálogo y guardar el catálogo actualizado en un nuevo archivo XML. */
	public static void agregarLibro()
	{
		//
	}
	
	
	
	
}
