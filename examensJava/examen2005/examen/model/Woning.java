package model;

import java.util.Random;

import exceptions.MaximumAantalKamers;

/**
 * Abstract class Woning - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Woning {
	// instance variables - replace the example below with your own
	public final int EENHEIDS_PRIJS;

	private int aantalKamers;
	public static Random random = new Random();
	private Kamer[] kamers;

	/**
	 * @return Returns the aantalKamers.
	 */
	public int getAantalKamers() {
		return aantalKamers;
	}

	/**
	 * @param aantalKamers
	 *            The aantalKamers to set.
	 */
	public void setAantalKamers(int aantalKamers) throws MaximumAantalKamers {
		this.aantalKamers = aantalKamers;
	}

	public void setAantalKamers(String type, int aantalKamers, int MAX)
			throws MaximumAantalKamers {
		this.setAantalKamers(aantalKamers);

		if (this.aantalKamers > MAX) {
			throw new MaximumAantalKamers("Een " + type + " mag slechts " + MAX
					+ " kamers bevatten!");
		}

	}


	/**
	 * @return Returns the kamers.
	 */
	public Kamer[] getKamers() {
		return kamers;
	}

	/**
	 * @param kamers
	 *            The kamers to set.
	 */
	public void setKamer(Kamer kamer, int index) {
		this.kamers[index] = kamer;
	}

	/**
	 * @return Returns the kamers.
	 */
	public Kamer getKamers(int index) {
		return kamers[index];
	}

	/**
	 * @param kamers
	 *            The kamers to set.
	 */
	public void setKamers(Kamer[] kamers) {
		this.kamers = kamers;
		for (int i = 0; i < kamers.length; i++) {
			kamers[i] = new Kamer();
			kamers[i].setBreedte(2 * (1 + random.nextInt(4)));// veelvoud van
																// 2 max 8
			kamers[i].setLengte(3 * (1 + random.nextInt(3)));// veelvoud van
																// 3 max 9
		}
	}

	/**
	 * @return Returns the prijs.
	 */
	public int getPrijs() {
		return getAantalKamers() * EENHEIDS_PRIJS;
	}

	public int getOppervlakte() {
		return (int)berekenOppervlakte();
	}

	public double berekenKostPrijs() {
		return berekenOppervlakte() * getPrijs();
	}
	/**
	 * Berekening oppervlakte van de woning
	 * 
	 * @return		de som van alle oppervlakten van alle vertrekken 
	 */
	public double berekenOppervlakte()
	{
		// put your code here
		double oppervlakte = 0;
		for(Kamer kamer : kamers){
		    oppervlakte += kamer.getOppervlakte();
		  }
		return oppervlakte;
	}

	public Woning(int eenheidsPrijs) {
		EENHEIDS_PRIJS = eenheidsPrijs;
	}

	public int voorstellingWoning() {
		int voorstelling = 0;
		for (int i = 0; i < kamers.length; i++) {
			voorstelling += kamers[i].getOppervlakte();
		}
		return voorstelling;
	}

	public String kamers() {
		StringBuffer alleKamers = new StringBuffer();
		for (int i = 0; i < kamers.length; i++) {
			alleKamers.append(kamers[i].toString());
			alleKamers.append("\n");
		}
		return alleKamers.toString();
	}

	public String toString() {
		return " met een oppervlakte van " + getOppervlakte()
				+ "m², wordt verhuurd aan " + berekenKostPrijs()
				+ "€ per maand en heeft " + getAantalKamers() + " kamers. ";
	}
}
