package model.factory;


import model.VervoerMiddel;
import model.voertuigen.Auto;
import model.voertuigen.StootKar;
import model.voertuigen.Voertuig;
import model.voertuigen.Vrachtwagen;
import model.wielen.Wiel;
import model.laadbakken.LaadBak;

/**
 * Write a description of class Factory here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class VoertuigFactory {
	/**
	 * An example of a factorymethod
	 * 
	 * @param y
	 *            int
	 * @return Voertuig
	 */
	public static VervoerMiddel createVoertuig(int y) {
		// put your code here
	
		switch (y) {
		case 0:
			return new StootKar(2, Voertuig.setCategory(), Voertuig.setWaarde());
		case 1:
			return new Auto(Voertuig.setWaarde());
		case 2:
			return new Vrachtwagen(LaadBak.setLaadBak(), Wiel.setAantalWielen(), Voertuig.setCategory(), Voertuig.setWaarde());
		default:
			return null;
		}
	}


	
}
