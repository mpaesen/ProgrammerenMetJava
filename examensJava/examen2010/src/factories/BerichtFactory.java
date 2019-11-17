package factories;


import business.berichten.Bericht;
import business.berichten.Email;
import business.berichten.SMS;
import business.berichten.Telefoon;

/**
 * Write a description of class BerichtFactory here.
 * 
 * @author Mathy 
 * @version 1.0
 */
public class BerichtFactory implements IBerichtFactory
{
	/**
     * Genereert een bericht op basis van een int selectie variabele, een bericht
     * 
     * @param  y   selectie variabele, bericht
 	 * @return bericht
	 */

    public Bericht createBericht(int y, String bericht)
    {
        // put your code here
        switch (y)
        {
            case 1: return new SMS(bericht);
            case 2: return new Email(bericht);
            case 3: return new Telefoon(bericht);            
            default: return null;
        }
    }
}
