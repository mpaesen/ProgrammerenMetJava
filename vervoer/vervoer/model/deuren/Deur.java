package model.deuren;

import model.vensters.Venster;

/**
 * Write a description of class Deur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deur
{
    // instance variables - replace the example below with your own
    private Venster venster;
    private String deur;

    /**
     * Constructor for objects of class Deur
     */
    public Deur(String deur)
    {
        // initialise instance variables
        this.deur = deur;
        switch((int)(Math.random()*2.0)){
            case 0:venster = new Venster("(met normaal zijvenster)");break;
            case 1:venster = new Venster("(met geblindeerd zijvenster)");break;
            default:venster = new Venster("(met kapot zijvenster)");break;
        }
    }
    
    /**
     * Initialises a window
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setVenster(Venster venster)
    {
        // put your code here
        this.venster = venster;
    }
    /**
     * Gives the current window
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */ 
    public Venster getVenster()
    {
        // put your code here
        return venster;
    }
    
       /**
     * String value of a Door
     * 
     * @return     String value of this motor
     */        
    public String toString(){
        return deur + " "+ getVenster()+ " ";
    }    
}
