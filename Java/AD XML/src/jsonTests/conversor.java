package jsonTests;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
//import org.junit.Test;

public class conversor
{
	public static String xmlStringToJSONString(String xmlString, int indentFactor)
	{
		JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
		String string = xmlJSONObj.toString(indentFactor);
		return string;
	}
	
	public static void main(String[] args) throws Exception
	{
		String xmlEntrada = "<?xml version=\"1.0\" ?>" +
				"<serviceRequest><id>123</id><desc>Hola</desc></serviceRequest>" + 
				"<serviceRequest><id>124</id><desc>Hola</desc></serviceRequest>" +
				"<sourceRequest><id>125</id><desc>Hola</desc></sourceRequest>";
		try
		{
			System.out.println(xmlStringToJSONString(xmlEntrada, 4));
		}
		catch (JSONException je) {System.out.println(je.toString());}
	}
}