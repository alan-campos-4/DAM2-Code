package ej4;

/*
 * Ejercicio 4
 * 
 * Se requiere desarrollar un programa en Java que gestione un sistema de biblioteca 
 * utilizando ficheros de acceso aleatorio. 
 * Este sistema permitirá almacenar, consultar, modificar y eliminar la información de libros 
 * en un fichero de acceso directo, de forma que cada registro se pueda acceder de manera eficiente 
 * sin necesidad de recorrer todo el fichero.
 * El sistema debe estar diseñado para permitir la persistencia de datos entre ejecuciones del programa, 
 * garantizando la integridad de la información almacenada.
 * Cada registro debe ocupar un espacio fijo en el fichero para facilitar la lectura y escritura 
 * de manera directa usando el ID del libro como clave para la posición en el fichero.
 * 
 * El programa debe validar que no existan ID duplicados cuando se agregue un nuevo libro.
 *  Cada libro debe contener los siguientes campos:
 * o	ID del libro (entero, 4 bytes)
 * o	Título del libro (cadena de texto, máximo 50 caracteres)
 * o	Autor (cadena de texto, máximo 30 caracteres)
 * o	Año de publicación (entero, 4 bytes)
 * o	Disponibilidad (booleano, 1 byte) – para controlar si el libro está disponible para préstamo.
 *  Operaciones del sistema: El programa debe ofrecer un menú con las siguientes opciones:
 * o	Añadir un nuevo libro:
 * 		 El usuario introducirá la información necesaria para agregar un nuevo libro a la biblioteca.
 * o	Consultar libro por ID:
 * 		 Se buscará un libro por su ID y se mostrarán sus detalles (si existe).
 * o	Modificar los datos de un libro: 
 * 		 Permitir al usuario modificar el título, el autor o el año de publicación de un libro existente.
 * o	Eliminar un libro: 
 * 		 Marcar un libro como no disponible, eliminándolo lógicamente (sin borrar el registro del fichero).
 * o	Listar todos los libros disponibles: 
 * 		 Mostrar en pantalla los libros que están disponibles para préstamo.

 */

public class Ejercicio4
{
	public static void main(String[] args)
	{
		//
	}
}
