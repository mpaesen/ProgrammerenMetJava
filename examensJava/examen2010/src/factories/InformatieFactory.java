package factories;
import java.util.ArrayList;
import business.Verplaatsing;
import business.informatie.Afgelasting;
import business.informatie.Informatie;
import business.informatie.Omleiding;
import business.informatie.Vertraging;
import business.berichten.Bericht;

/**
 * Write a description of class InformatieFactory here.
 * 
 * @author Mathy
 * @version 1.0
 */
public class InformatieFactory implements IInformatieFactory{
	/**
     * Genereert een info op basis van een int selectie variabele, een bericht een verplaatsing en een datum
     * 
     * @param  y   selectie variabele, bericht, verplaatsing, datum
 	 * @return informatie
	 */
	public Informatie createInformatie(int y, Verplaatsing verplaatsing, ArrayList<Bericht> berichten) {
		
		switch (y) {
		case 1:
			return new Omleiding(verplaatsing, berichten);
		case 2:
			return new Vertraging(verplaatsing, berichten);
		case 3:
			return new Afgelasting(verplaatsing, berichten);
		default:
			return null;
		}
	}
}
