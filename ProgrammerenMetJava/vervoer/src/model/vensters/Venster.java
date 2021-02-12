package model.vensters;

/**
 * Write a description of class Venster here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Venster {
	// instance variables - replace the example below with your own
	private final String venster;

	private final int dikte;

	/**
	 * Constructor for objects of class Venster
	 */
	public Venster(String venster) {
		// initialise instance variables
		this.venster = venster;
		dikte = 1;
	}

	public Venster(String venster, int dikte) {
		// initialise instance variables
		this.venster = venster;
		this.dikte = dikte;
	}

	public int getDikte() {
		return dikte;
	}

	public String getVenster() {
		return venster;
	}

	/**
	 * String value of a window
	 * 
	 * @return String value of this motor
	 */
	public String toString() {
		return venster;
	}
}
