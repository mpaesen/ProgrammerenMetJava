package utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Input{

/** Leest een geheel getal van het scherm */
public static double leesBedrag(String s)
	{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(isr);
	double number=0;
	System.out.print("Geef "+s+": ");
	    try
		{number = Double.parseDouble(in.readLine());}
	    catch(java.io.IOException e)
		{    System.out.println(e.toString());
		}
	 return number;
	}
	
/** Vraagt de gebuiker de gewenste optie in te brengen */
public static char optie()
{	char input='\0';
	InputStreamReader isr = new InputStreamReader(System.in);
   	BufferedReader in = new BufferedReader(isr);
	do
  	 {  
	    System.out.println("\nDruk E voor berekening van het eindbedrag");
 	    System.out.println("Druk I voor intrest berekening");
 	    System.out.println("Druk K voor kapitaal berekening");
 	    System.out.println("\nDruk S om te eindigen");
	   try
		{input = (char)in.read();}
	    catch(java.io.IOException e)
		{    System.out.println(e.toString());
		     System.exit(1);
		}
	 } while (Character.toLowerCase(input)!='e' && Character.toLowerCase(input)!='i' && Character.toLowerCase(input)!='k'
			&& Character.toLowerCase(input)!='s'); 
	return input;
}
}