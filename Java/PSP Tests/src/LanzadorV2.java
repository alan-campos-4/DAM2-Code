import java.io.File;


public class LanzadorV2
{
    public void lanzarSumador(Integer n1, Integer n2, String fichResultado)
    {
        String clase = "com.ies.Sumador";
        ProcessBuilder pb;
        try
        {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();
        }
        catch (Exception e)	{e.printStackTrace();}
    }
    
    public static void main(String[] args)
    {
        LanzadorV2 l = new LanzadorV2();
        l.lanzarSumador(1, 5,  "result1.txt");
        l.lanzarSumador(6, 10, "result2.txt");
        System.out.println("Ok");
    }
}