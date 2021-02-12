package model.voertuigen;

import model.VervoerMiddel;
import model.wielen.Wiel;
import utilities.Category;

import java.math.BigDecimal;

/**
 * Abstract class Voertuig - write a description of the class here
 * 
 * @author: Mathy Date: 21/09/2003
 */
public abstract class Voertuig extends VervoerMiddel
{
	private final int AANTAL_WIELEN;

	private final Wiel wielen[];

	/**
	 * @param AANTAL_WIELEN
	 * @param cat
	 * @param waarde
	 */
	public Voertuig(final int aantalWielen, final Category cat, final BigDecimal waarde)
	{
		super(cat, waarde);
		this.AANTAL_WIELEN = aantalWielen;
		wielen = new Wiel[AANTAL_WIELEN];
		for (int i = 0; i < wielen.length; i++)
		{
			wielen[i] = new Wiel();
		}
		Wiel.setNummer(0);
	}

	public int getAantalWielen()
	{
		return AANTAL_WIELEN;
	}

	@Override
	public String toString()
	{
		return "\n\tDe Categorie is " + getCategory() + " " + "met als waarde €" + getWaarde();
	}

	/**
	 * Gives a selected Wheel
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public Wiel getWiel(final int y)
	{
		// put your code here
		return wielen[y];
	}

	/**
	 * Gives all wheels
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public String getWielen()
	{
		// put your code here
		final StringBuffer str = new StringBuffer();
		str.append("[");
		for (int i = 0; i < wielen.length; i++)
		{
			str.append(getWiel(i));
			if (i < wielen.length - 1)
				str.append(", ");
		}
		str.append("]");
		return str.toString();

	}

}
