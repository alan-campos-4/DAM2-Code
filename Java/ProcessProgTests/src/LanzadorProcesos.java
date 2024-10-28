public class LanzadorProcesos 
{
	public void ejecutar(String ruta)
	{
		ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
        }
        catch (Exception e) {e.printStackTrace();}
    }
	
    /*
     * @param args
     */
    public static void main(String[] args)
    {
		String ruta = "\"C:\\Windows\\System32\\calc.exe\"";
		LanzadorProcesos lp = new LanzadorProcesos();
		lp.ejecutar(ruta);
		System.out.println("Finalizado");
    }
}
