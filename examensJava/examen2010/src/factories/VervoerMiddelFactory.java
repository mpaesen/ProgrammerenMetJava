package factories;

import business.vervoermiddelen.Bus;
import business.vervoermiddelen.Tram;
import business.vervoermiddelen.Trein;
import business.vervoermiddelen.VervoerMiddel;
import business.vervoermiddelen.Vliegtuig;
import business.vervoermiddelen.Boot;

/**
 * Write a description of class VervoerMiddelFactory here.
 * 
 * @author Mathy 
 * @version 1.0
 */
public class VervoerMiddelFactory implements IVervoermiddelFactory
{

    /**
     * Genereert een voertuig op basis van een int selectie variabele
     * 
     * @param  y   selectie variabele
     * @return     Voertuig 
     */
    public VervoerMiddel createVervoermiddel(int y)
    {
        // put your code here
        switch (y)
        {
            case 1: return new Bus();
            case 2: return new Tram();
            case 3: return new Vliegtuig();
            case 4: return new Trein();
            case 5: return new Boot();
            default: return null;
        }
    }
}
