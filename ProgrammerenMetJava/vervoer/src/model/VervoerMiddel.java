package model;

import java.math.BigDecimal;

import utilities.Category;

import model.deuren.Deur;
import model.kleuren.Kleur;
import model.kleuren.Kleurbaar;
import model.kleuren.Kleuren;
import model.motoren.Motor;
import model.vensters.Venster;

public abstract class VervoerMiddel extends Object implements Kleurbaar {

	private Category category;
	private BigDecimal waarde;
	private Kleur kleur;
	protected Motor motor;
	private Venster[] vensters;
	private Deur[] deuren;

	/**
	 * @param category
	 * @param waarde
	 */
	public VervoerMiddel(Category category, BigDecimal waarde) {
		this.category = category;
		this.waarde = waarde;
		kleur = Kleuren.randomKleur();
	}

	/**
	 * An example of an abstract method
	 * @return String
	 */
	public abstract String toString();

	/**
	 * @param vensters
	 *            the vensters to set
	 */
	public void setVensters(Venster[] vensters, String soort) {
		this.vensters = vensters;
		maakVensters(soort);
	}
	
	private void maakVensters(String soort){
		int dikte =(int)(Math.random()*10.0);
		for(int i=0; i<getVenstersArray().length; i++){			
			setVenster(i, new Venster(soort,dikte));
		}			
	}
	

	/**
	 * @param deuren
	 *            the deuren to set
	 */
	public void setDeuren(Deur[] deuren, String soort) {
		this.deuren = deuren;
		maakDeuren(soort);
	}
	
	private void maakDeuren(String soort){		
		for(int i=0; i<getDeurenArray().length; i++){			
			setDeur(i, new Deur(soort));
		}			
	}	
	
	public void setDeur(int i, Deur deur){
		deuren[i]= deur;
	}
	public void setVenster(int i, Venster venster){
		vensters[i]= venster;
	}
	public void setWaarde(BigDecimal waarde) {
		this.waarde = waarde;
	}

	public static Category setCategory() {// wordt niet gebruikt voor auto's
		Category cat;
		switch ((int) (Math.random() * 2.0)) {
		case 0:
			cat = Category.DIEREN;
			break;
		case 1:
			cat = Category.GOEDEREN;
			break;
		default:
			cat = Category.ONBEPAALD;
		}
		return cat;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}

	public static BigDecimal setWaarde() {// genereert een random test waarde
		BigDecimal waarde;
		waarde = new BigDecimal(1000.0 + Math.random() * 1000000.0).setScale(2,
				BigDecimal.ROUND_HALF_UP);
		return waarde;
	}

	public Kleur getKleur() {
		return kleur;
	}

	/**
	 * Gives all doors
	 * 
	 * @param y index in array wielen
	 * @return the selected Wheel
	 */
	public String getDeuren() {
		StringBuffer str = new StringBuffer();
		str.append("[");
		if ((deuren == null) || (deuren.length <= 0)) {
			str.append("Geen Deuren");
			
		} else {
			for (int i = 0; i < deuren.length; i++) {
				str.append(getDeur(i));
				if (i < deuren.length - 1)
					str.append(", ");
			}
		}
		str.append("]");
		return str.toString();

	}

	/**
	 * Gives all windows
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public String getVensters() {
		// put your code here
		StringBuffer str = new StringBuffer();
		str.append("[");
		if ((vensters == null) || (vensters.length <= 0)) {
			str.append("Geen Vensters");
			
		} else {
			for (int i = 0; i < vensters.length; i++) {
				str.append(getVenster(i));
				if (i < vensters.length - 1)
					str.append(", ");
			}
		}

		str.append("]");
		return str.toString();

	}

	public Venster[] getVenstersArray() {
		return vensters;
	}

	public Deur[] getDeurenArray() {
		return deuren;
	}

	/**
	 * Gives the Motor
	 * 
	 * @return the motor
	 */
	public Motor getMotor() {
		// put your code here
		return motor;
	}

	/**
	 * Gives a Window
	 * 
	 * @param y
	 *            index in array deuren
	 * @return the selected Door
	 */
	public Venster getVenster(int y) {
		// put your code here
		return vensters[y];
	}

	/**
	 * Gives a Door
	 * 
	 * @param y
	 *            index in array deuren
	 * @return the selected Door
	 */
	public Deur getDeur(int y) {
		// put your code here
		return deuren[y];
	}

	public BigDecimal getWaarde() {
		return waarde;
	}

	public Category getCategory() {
		return category;
	}

}
