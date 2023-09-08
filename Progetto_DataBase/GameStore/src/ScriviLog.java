
import java.util.*;
import java.io.*;

public class ScriviLog 
{
	public ScriviLog() 
	{
			
	}
	public void Scrivi(String Path,String Error) throws IOException 
	{
		FileWriter w;
		w = new FileWriter(Path,true);
        BufferedWriter b;
		b= new BufferedWriter (w);
		b.write(Error);
		b.write("\n");
		b.flush();

	}
	
}





