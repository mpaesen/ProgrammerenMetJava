package model.factory;

import model.kleuren.Kleur;

public class KleurFactory
{

	/**
	  * This method gives a color
	  * @return     a color
	  */

	public static Kleur getKleur(final Kleur k)
	{
		switch (k.kleurNumeric())
		{
		case 0:
			return Kleur.WIT;
		case 1:
			return Kleur.GROEN;
		case 2:
			return Kleur.ROOD;
		case 3:
			return Kleur.BLAUW;
		case 4:
			return Kleur.GEEL;
		default:
			return null;
		}
	}

	public static Kleur randomKleur()
	{
		// put your code here
		return Kleur.values()[(int) (Math.random() * Kleur.values().length)];
	}
}
