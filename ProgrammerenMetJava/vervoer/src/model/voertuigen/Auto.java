package model.voertuigen;

import java.math.BigDecimal;

import utilities.Category;

import model.deuren.Deur;
import model.motoren.Motor;
import model.vensters.Venster;


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
    public Auto(int aantalWielen, Category cat, BigDecimal waarde)
    { 
    	super(aantalWielen, cat, waarde);//constructor van Voertuig
        motor = new Motor();	
		setDeuren(new Deur[1+(int)(Math.random() * 5.0)], "Gewone");
		setVensters(new Venster[1+(int)(Math.random() * 2.0)], "Ordinaire");
    }
    
    	
    public Auto(BigDecimal waarde)
    {
        // initialise instance variables
    	this(4, Category.PERSONEN, waarde);//default 4 wielen voor een auto
    }
   /**
     * String value of a Car
     * 
     * @return     String value of this motor
     */        
    public String toString(){
        return "Deze auto heeft een "+getMotor()+"motor \n\tde deuren zijn: "+getDeuren() +"\n\tmet als vensters: "+ getVensters()+"\n\tde wielen zijn: "+ getWielen()+ "\n\ten als kleur: "+ getKleur()+super.toString();
    }        
}
