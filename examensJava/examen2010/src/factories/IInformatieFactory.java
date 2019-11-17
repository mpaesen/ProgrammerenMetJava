package factories;


import java.util.ArrayList;
import business.Verplaatsing;
import business.berichten.Bericht;
import business.informatie.Informatie;


/**
 * Write a description of interface IInformatieFactory here.
 * 
 * @author Mathy 
 * @version 1.0
 */

public interface IInformatieFactory
{
	/**
     * Genereert een info op basis van een int selectie variabele, een bericht een verplaatsing en een datum
     * 
     * @param  y   selectie variabele, bericht, verplaatsing, datum
 	 * @return informatie
	 */

    Informatie createInformatie(int y, Verplaatsing verplaatsing, ArrayList<Bericht> berichten);
}
