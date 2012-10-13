package model;

import java.math.BigDecimal;

import utilities.Category;

import model.deuren.Deur;
import model.kleuren.Kleur;
import model.kleuren.Kleurbaar;
import model.kleuren.Kleuren;
import model.motoren.Motor;
import model.vensters.Venster;


public abstract class VervoerMiddel extends Object implements Kleurbaar{

	private Category category;
	private BigDecimal waarde;
	private Kleur kleur;
	protected Motor motor;
	public Venster vensters[];
	public Deur deuren[];

	/**
	 * @param category
	 * @param waarde
	 */
	public VervoerMiddel(Category category, BigDecimal waarde) {
		this.category = category;
		this.waarde = waarde;
		kleur = Kleuren.randomKleur();
	}	

	public BigDecimal getWaarde() {
		return waarde;
	}

	public void setWaarde(BigDecimal waarde) {
		this.waarde = waarde;
	}

	public Category getCategory() {
		return category;
	}
	
	/**
     * An example of an abstract method
     * @return      String
     */
    public abstract String toString();

	public Kleur getKleur() {
		return kleur;
	}

	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}
	
	/**
	 * Gives all doors
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public String getDeuren() {
		StringBuffer str = new StringBuffer();
		str.append("[");
		if (deuren.length > 0) {
		for (int i = 0; i < deuren.length; i++) {
			str.append(getDeur(i));
			if (i < deuren.length - 1)
				str.append(", ");
		}
		}else{
			str.append("Geen Deuren");
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
		if (vensters.length > 0) {
			for (int i = 0; i < vensters.length; i++) {
				str.append(getVenster(i));
				if (i < vensters.length - 1)
					str.append(", ");
			}
		} else {
			str.append("Geen Vensters");
		}
	
		str.append("]");
		return str.toString();
	
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

	public static BigDecimal setWaarde() {//genereert een random test waarde
		BigDecimal waarde;
		 waarde = new BigDecimal(1000.0 + Math.random() * 1000000.0).setScale(2,BigDecimal.ROUND_HALF_UP);		
		return waarde;
	}

}
