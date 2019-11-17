package factories;

import business.vervoermiddelen.VervoerMiddel;
/**
 * Write a description of interface Factory here.
 * 
 * @author Mathy 
 * @version 1.0
 */

public interface IVervoermiddelFactory
{
	/**
     * Genereert een voertuig op basis van een int selectie variabele
     * 
     * @param  y   selectie variabele
     * @return     Voertuig 
     */
    VervoerMiddel createVervoermiddel(int y);
}
