package ej4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/*
 * Ejercicio 4 - JSON - 1 pto
 * 
 * Escribe un programa para obtener una representación de un fichero XML en formato JSON.
 */


public class Ejercicio4
{
	public static void main(String[] args)
	{
		try
		{
			String line, xmlString = "";
			File fichero = new File("src/peliculas.xml");
			BufferedReader br = new BufferedReader(new FileReader(fichero));

			while ((line = br.readLine()) != null)
			{
				if (!line.equals(""))
					{xmlString += line;}
			}
			br.close();

			JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
			String JSONstring = xmlJSONObj.toString(4);

			System.out.println(JSONstring);
		}
		catch (FileNotFoundException e)	{e.printStackTrace();}
		catch (IOException e)			{e.printStackTrace();}
		catch (JSONException e)			{e.printStackTrace();}
	}
}
