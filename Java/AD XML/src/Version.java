public class Version
{
	private double numero;
	private String nombre;
	private int api;

	public double getNumero()	{return numero;}
	public String getNombre()	{return nombre;}
	public int getApi()			{return api;}
	
	public void setNumero(double numero)	{this.numero = numero;}
	public void setNombre(String nombre)	{this.nombre = nombre;}
	public void setApi(int api)				{this.api = api;}
	
	public String toString()
	{
		return " Version => Numero: " + numero + ", Nombre: " + nombre + ", API: " + api;
	}
	
//	public Version(double num, String nom, int api)
//	{
//		setNumero(num);
//		setNombre(nom);
//		setApi(api);
//	}
}
