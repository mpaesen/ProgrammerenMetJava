package model.voertuigen;

import java.math.BigDecimal;

import utilities.Category;


/**
 * Write a description of class StootKar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StootKar extends Voertuig
{
    public StootKar(int aantalWielen, Category cat, BigDecimal waarde) {
		super(aantalWielen, cat, waarde);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
        return "Dit voertuig is een stootkar."+super.toString();
        
    }
}
