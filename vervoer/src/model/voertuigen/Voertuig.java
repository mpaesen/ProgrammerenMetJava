package model.voertuigen;

import model.VervoerMiddel;
import model.motoren.Motor;
import model.wielen.Wiel;
import utilities.Category;
import utilities.kleuren.Kleur;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Abstract class Voertuig - write a description of the class here
 *
 * @author: Mathy Date: 21/09/2003
 */
public abstract class Voertuig extends VervoerMiddel {
	private final int AANTAL_WIELEN;
	private final Wiel[] wielen;

	/**
	 * @param cat
	 * @param waarde
	 */
	public Voertuig(int aantalWielen, Category cat, BigDecimal waarde, Kleur kleur, Motor motor) {
		super(cat, waarde, kleur, motor);
		this.AANTAL_WIELEN = aantalWielen;
		wielen = new Wiel[AANTAL_WIELEN];
		for (int i = 0; i < wielen.length; i++) {
			wielen[i] = new Wiel();
		}
	}

	public int getAantalWielen() {
		return AANTAL_WIELEN;
		//wielen.length
	}

	@Override
	public String toString() {
		return "Voertuig{" + super.toString() +
				" wielen=" + Arrays.toString(wielen) +
				", motor=" + motor +
				'}';
	}

	/**
	 * Gives a selected Wheel
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public Wiel getWiel(int y) {
		// put your code here
		return wielen[y];
	}

	/**
	 * Gives all wheels
	 * 
	 * @return the selected Wheel
	 */
	public String getWielen() {
		// put your code here
		StringBuffer str = new StringBuffer();//of StringBuilder
		str.append("[");
		for (int i = 0; i < wielen.length; i++) {
			str.append(getWiel(i));
			if (i < wielen.length - 1)
				str.append(", ");//komma tussen de wielen
		}
		str.append("]");
		return str.toString();
	}


}
