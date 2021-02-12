package model.voertuigen;

import model.deuren.Deur;
import model.factory.MotorFactory;
import model.vensters.Venster;
import utilities.Category;

import java.math.BigDecimal;

/**
 * Write a description of class Auto here.
 * 
 * @author Mathy 
 * @version 8 april 2011
 */
public class Auto extends Voertuig
{
	/**
	 * Constructor for objects of class Auto
	 */
	public Auto(final int aantalWielen, final Category cat, final BigDecimal waarde)
	{
		super(aantalWielen, cat, waarde);//constructor van Voertuig
		setMotor(MotorFactory.createMotor());
		setDeuren(new Deur[1 + (int) (Math.random() * 5.0)], "Gewone");
		setVensters(new Venster[1 + (int) (Math.random() * 2.0)], "Ordinaire");
	}

	public Auto(final BigDecimal waarde)
	{
		// initialise instance variables
		this(4, Category.PERSONEN, waarde);//default 4 wielen voor een auto
	}

	/**
	  * String value of a Car
	  * 
	  * @return     String value of this motor
	  */
	@Override
	public String toString()
	{
		return "Deze auto heeft een \"" + getMotor() + "\" motor \n\tde deuren zijn: " + getDeuren() + "\n\tmet als vensters: " + getVensters() + "\n\tde wielen zijn: " + getWielen() + "\n\ten als kleur: " + getKleur() + super.toString();
	}
}
