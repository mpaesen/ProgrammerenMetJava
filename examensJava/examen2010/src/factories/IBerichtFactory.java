package factories;

import business.berichten.Bericht;

/**
 * Write a description of interface IBerichtFactory here.
 * 
 * @author Mathy 
 * @version 1.0
 */

public interface IBerichtFactory
{
	/**
     * Genereert een bericht op basis van een int selectie variabele, een bericht
     * 
     * @param  y   selectie variabele, bericht
 	 * @return bericht
	 */

    Bericht createBericht(int y, String bericht);
}
