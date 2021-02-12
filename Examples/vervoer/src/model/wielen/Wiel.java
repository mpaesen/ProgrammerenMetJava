package model.wielen;

/**
 * Write a description of class Wiel here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wiel
{
	// instance variables - replace the example below with your own
	private static int nummer = 0;

	private final String wiel;

	/**
	 * Constructor for objects of class Wiel
	 */
	public Wiel()
	{
		// initialise instance variables
		nummer++;
		wiel = "Wiel " + nummer;
	}

	/**
	 * String value of a wheel
	 * 
	 * @return String value of this motor
	 */
	@Override
	public String toString()
	{
		return wiel;
	}

	/**
	 * @param nummer the nummer to set
	 */
	public static void setNummer(final int nummer)
	{
		Wiel.nummer = nummer;
	}

	public static int getNummer()
	{
		return nummer;
	}

	public static int setAantalWielen()
	{// wordt enkel gebruikt voor
		// vrachtwagens
		final int aantal = (int) (4.0 + Math.random() * 4.0); // minstens 4 wielen
		return aantal;
	}
}
