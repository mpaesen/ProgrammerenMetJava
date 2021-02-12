package test;

import model.Amount;
import model.Beleggen;
import utilities.Input;
 
 public class TestBeleggen
 {
 public static void main(String[] args)
  { 	char input;
	System.out.println("\nDit programma is een hulpmiddel voor uw beleggingen");
    	System.out.println("Afhankelijk van de vraag zal dit programma u om");
    	System.out.println("bepaalde gegevens vragen");
    do
    {    
	input=Character.toUpperCase(Input.optie());
         Amount amount = new Amount();
	   switch(input)
		{
		   case 'I': Beleggen.berekenInterest(amount);break;
   		   case 'K': Beleggen.berekenKapitaal(amount);break;
		   case 'E': Beleggen.berekenEindBedrag(amount);break;
		   case 'S': break;
		   default:System.out.println("Er heeft zich een fout voorgedaan!!");
			break;
		}
	} while (input!='S');
  }
}