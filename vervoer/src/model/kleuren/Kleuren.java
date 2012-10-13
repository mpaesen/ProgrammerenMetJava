package model.kleuren;
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
     * This method gives a color
     * @return     a color
     */ 
    
    public static String getKleur(Kleur k){
        switch(k.kleurNumeric()){
            case 0: return Kleur.WIT.kleurString();
            case 1: return Kleur.GROEN.kleurString();
            case 2: return Kleur.ROOD.kleurString();
            case 3: return Kleur.BLAUW.kleurString();
            case 4: return Kleur.GEEL.kleurString();
            default: return "Onbekende kleur";
        }
    }
}
