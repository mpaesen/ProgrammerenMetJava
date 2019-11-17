import java.util.ArrayList;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    private static ArrayList instanties = new ArrayList();
    private static ArrayList leveranciers = new ArrayList();

    public final static int MAX = 10;

   
    public static void main(String[] args)
    {
        // put your code here
        for(int i = 0; i<MAX; i++){
            instanties.add(InstantieFactory.createInstantie(InschrijfFactory.createStrategy(1)));
        }
        
        for(int i = 0; i<MAX; i++){
            leveranciers.add(LeverancierFactory.createInstantie(PrijsFactory.createPrijs(1)));
        }
    }
}
