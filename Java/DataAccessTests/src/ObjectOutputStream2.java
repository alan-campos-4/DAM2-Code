import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class ObjectOutputStream2 extends ObjectOutputStream
{
    public ObjectOutputStream2(OutputStream out) throws IOException			{super(out);}
    
    protected ObjectOutputStream2() throws IOException, SecurityException	{super();}
    
    protected void writeStreamHeader() throws IOException					{}
}