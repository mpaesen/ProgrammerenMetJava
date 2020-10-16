package model.factory;

import utilities.kleuren.Kleur;

/**
 * Write a description of class Kleur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kleuren
{
    /**
     * This method generates a random Color
     * @return     a color
     */
    public static Kleur randomKleur()
    {
        // put your code here
        return Kleur.values()[(int)(Math.random()*Kleur.values().length)];
    }

    /**
     * This factory method gives a color
     * @return     a color
     */ 
    
    public static String getKleur(Kleur k){
        switch(k.kleurNumeric()){
            case 0: return Kleur.WIT.getKleurString();
            case 1: return Kleur.GROEN.getKleurString();
            case 2: return Kleur.ROOD.getKleurString();
            case 3: return Kleur.BLAUW.getKleurString();
            case 4: return Kleur.GEEL.getKleurString();
            default: return "Onbekende kleur";
        }
    }
}
