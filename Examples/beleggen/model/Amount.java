/** de class amount bevat alle functionaliteit 
om een vastrentende belegging
te berekenen */
package model;

public class Amount
{
/** beginkapitaal */
   private double kapitaal;
/** gekapitaliseerd eindBedrag */
   private double eindBedrag;
/** rentevoet waaraan de belegging wordt gekapitaliseerd */
   private double interest;
/** aantal jaren dat het geld kapitaliseert */
   private int jaren;

   public Amount(){kapitaal =0.00;
	    eindBedrag =0.00;
	    interest =0.00;
	    jaren =0;}

   public void setKapitaal(double kapitaal){this.kapitaal=kapitaal;}
   public void setEindBedrag(double eindBedrag){this.eindBedrag=eindBedrag;}
   public void setInterest(double interest){this.interest=interest;}
   public void setJaren(int jaren){this.jaren=jaren;}

   public void berekenKapitaal(){
   	kapitaal = eindBedrag/
   	Math.pow(1.00 + interest/100.00,(double)jaren);
   	
   }
   
   public void berekenEindBedrag(){
   	eindBedrag = kapitaal*
   	Math.pow(1.00 + interest/100.00 ,(double)jaren);
   	
   }
   
   public void berekenInterest(){
   	interest = 100.00 * 
   	(Math.pow(eindBedrag/kapitaal,1.00/(double)jaren) - 1.00);
   	
   }

   public double getKapitaal(){return kapitaal;}
   public double getEindBedrag(){return eindBedrag;}
   public double getInterest(){return interest;}
   public int getJaren(){return jaren;}

   public void printEindBedrag(String s)
	{print(eindBedrag,s);}
   public void printKapitaal(String s)
	{print(kapitaal,s);
    }
   public void printInterest(String s)
	{print(interest,s);}

/** concatineert een string met een bedrag */
   public void print(double onbekende, String s)
	{
	System.out.printf("De gevraagde onbekende "+s+" is: %.2f", onbekende);
	}
}