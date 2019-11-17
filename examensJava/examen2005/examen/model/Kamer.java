package model;

/**
 * Write a description of class Kamer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kamer
{
	// instance variables - replace the example below with your own
	private String naam;
	private int breedte;
	private int lengte;
	/**
	 * Constructor for objects of class Kamer
	 */
	public Kamer()
	{
		// initialise instance variables
		
	}

	/**
	 * @return Returns the breedte.
	 */
	public int getBreedte() {
		return breedte;
	}

	/**
	 * @param breedte The breedte to set.
	 */
	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}

	/**
	 * @return Returns the diepte.
	 */
	public int getLengte() {
		return lengte;
	}

	/**
	 * @param diepte The diepte to set.
	 */
	public void setLengte(int diepte) {
		this.lengte = diepte;
	}
	
	public int getOppervlakte(){
		return getBreedte()*getLengte();
	}
	
	public String toString(){
		return "\t\tDeze kamer heeft een oppervlakte van "+getOppervlakte()+"m²";
	}

	/**
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}
}
