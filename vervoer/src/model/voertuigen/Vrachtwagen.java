package model.voertuigen;

import java.math.BigDecimal;

import utilities.Category;
import model.laadbakken.LaadBak;


/**
 * Write a description of class Vrachtwagen here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vrachtwagen extends Auto {
	// instance variables - replace the example below with your own
	private LaadBak laadbak;

	public Vrachtwagen(LaadBak laadbak, int aantalWielen, Category cat, BigDecimal waarde) {
		super(aantalWielen, cat, waarde);
		this.laadbak = laadbak;
	}


	public String toString() {
		return super.toString()
				+ "\n\thet is een vrachtwagen met als laadbak: " + getLaadbak();
	}


	public LaadBak getLaadbak() {
		return laadbak;
	}


	public void setLaadbak(LaadBak laadbak) {
		this.laadbak = laadbak;
	}
	

}
