package samples;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOSample
{
  public static void main( String[] args )
  {
	String name = null;
	String welcomeBanner = "Welcome ";
	BufferedReader br = new BufferedReader(
						   new InputStreamReader( System.in )
						);

	try
	{
	  name = br.readLine();
	}
	catch (IOException exc)
	{
	  System.err.println( exc );
	}
	System.out.println( welcomeBanner + name );
  }    
}