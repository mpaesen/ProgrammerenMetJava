package model.wielen;

/**
 * Write a description of class Wiel here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wiel {
	// instance variables - replace the example below with your own
	private static int nummer = 0;

	private String wiel;

	/**
	 * Constructor for objects of class Wiel
	 */
	public Wiel() {
		// initialise instance variables
		nummer++;
		wiel = "Wiel " + nummer;
	}

	/**
	 * String value of a wheel
	 * 
	 * @return String value of this motor
	 */
	public String toString() {
		return wiel;
	}

	public static int getNummer() {
		return nummer;
	}
	public static int setAantalWielen() {// wordt enkel gebruikt voor
		// vrachtwagens
		int aantal = (int) (4.0 + Math.random() * 4.0); // minstens 4 wielen
		return aantal;
	}
}
