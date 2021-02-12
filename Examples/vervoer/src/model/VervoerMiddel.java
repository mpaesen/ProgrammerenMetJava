package model;

import model.deuren.Deur;
import model.factory.KleurFactory;
import model.kleuren.Kleur;
import model.kleuren.Kleurbaar;
import model.motoren.Motor;
import model.vensters.Venster;
import utilities.Category;

import java.math.BigDecimal;

public abstract class VervoerMiddel extends Object implements Kleurbaar
{

	private Category category;
	private BigDecimal waarde;
	private Kleur kleur;
	private Motor motor;
	private Venster vensters[];
	private Deur deuren[];

	/**
	 * @param category
	 * @param waarde
	 */
	public VervoerMiddel(final Category category, final BigDecimal waarde)
	{
		this.category = category;
		this.waarde = waarde;
		//kleur = KleurFactory.randomKleur();
		//or
		kleur = KleurFactory.getKleur(Kleur.values()[(int) (Math.random() * Kleur.values().length)]);
	}

	/**
	 * An example of an abstract method
	 * 
	 * @return String
	 */
	@Override
	public abstract String toString();

	/**
	 * @param vensters
	 *            the vensters to set
	 */
	public void setVensters(final Venster[] vensters, final String soort)
	{
		this.vensters = vensters;
		maakVensters(soort);
	}

	private void maakVensters(final String soort)
	{
		final int dikte = (int) (Math.random() * 10.0);
		for (int i = 0; i < getVenstersArray().length; i++)
		{
			setVenster(i, new Venster(soort, dikte));
		}
	}

	/**
	 * @param deuren
	 *            the deuren to set
	 */
	public void setDeuren(final Deur[] deuren, final String soort)
	{
		this.deuren = deuren;
		maakDeuren(soort);
	}

	private void maakDeuren(final String soort)
	{
		for (int i = 0; i < getDeurenArray().length; i++)
		{
			setDeur(i, new Deur(soort));
		}
	}

	public void setDeur(final int i, final Deur deur)
	{
		deuren[i] = deur;
	}

	public void setVenster(final int i, final Venster venster)
	{
		vensters[i] = venster;
	}

	public void setWaarde(final BigDecimal waarde)
	{
		this.waarde = waarde;
	}

	public static Category setCategory()
	{// wordt niet gebruikt voor auto's
		Category cat;
		switch ((int) (Math.random() * 2.0))
		{
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
	public void setCategory(final Category category)
	{
		this.category = category;
	}

	/**
	 * @param motor
	 *            the motor to set
	 */
	public void setMotor(final Motor motor)
	{
		this.motor = motor;
	}

	public void setKleur(final Kleur kleur)
	{
		this.kleur = kleur;
	}

	public static BigDecimal setWaarde()
	{// genereert een random test waarde
		BigDecimal waarde;
		waarde = new BigDecimal(1000.0 + Math.random() * 100000.0).setScale(2, BigDecimal.ROUND_HALF_UP);
		return waarde;
	}

	public Kleur getKleur()
	{
		return kleur;
	}

	/**
	 * Gives all doors
	 * 
	 * @param y
	 *            index in array wielen
	 * @return the selected Wheel
	 */
	public String getDeuren()
	{
		final StringBuffer str = new StringBuffer();
		str.append("[");
		if ((deuren == null) || (deuren.length <= 0))
		{
			str.append("Geen Deuren");

		}
		else
		{
			for (int i = 0; i < deuren.length; i++)
			{
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
	public String getVensters()
	{
		// put your code here
		final StringBuffer str = new StringBuffer();
		str.append("[");
		if ((vensters == null) || (vensters.length <= 0))
		{
			str.append("Geen Vensters");

		}
		else
		{
			for (int i = 0; i < vensters.length; i++)
			{
				str.append(getVenster(i));
				if (i < vensters.length - 1)
					str.append(", ");
			}
		}

		str.append("]");
		return str.toString();

	}

	public Venster[] getVenstersArray()
	{
		return vensters;
	}

	public Deur[] getDeurenArray()
	{
		return deuren;
	}

	/**
	 * Gives the Motor
	 * 
	 * @return the motor
	 */
	public Motor getMotor()
	{
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
	public Venster getVenster(final int y)
	{
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
	public Deur getDeur(final int y)
	{
		// put your code here
		return deuren[y];
	}

	public BigDecimal getWaarde()
	{
		return waarde;
	}

	public Category getCategory()
	{
		return category;
	}

}
