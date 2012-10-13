package model.vaartuigen;

import java.math.BigDecimal;

import utilities.Category;

import model.deuren.Deur;
import model.vensters.Venster;

public class Boot extends Vaartuig {

	public Boot(Category cat, BigDecimal waarde){
		super(cat, waarde);
		deuren = new Deur[1+(int)(Math.random() * 150.0)];
		maakDeuren();
		vensters = new Venster[1+(int)(Math.random() * 150.0)];
		maakVensters();
	}
	
	private void maakVensters(){
		int dikte =(int)(Math.random()*10.0);
		for(int i=0; i<vensters.length; i++){
			
			vensters[i] = new Venster("Zij",dikte);
		}
			
	}
	
	private void maakDeuren(){		
		for(int i=0; i<deuren.length; i++){
			
			deuren[i] = new Deur("Kajuit");
		}
			
	}	
	  public Venster getVenster(int y)
	    {
	        // put your code here
	        return vensters[y];
	    }
	    
	    /**
	     * Gives a Door
	     * 
	     * @param  y   index in array deuren
	     * @return     the selected Door
	     */
	    public Deur getDeur(int y)
	    {
	        // put your code here
	        return deuren[y];
	    }
	  
	   /**
	     * Gives all doors
	     * 
	     * @param  y   index in array wielen
	     * @return     the selected Wheel
	     */
	    public String getDeuren()
	    {
	        // put your code here
	        StringBuffer str = new StringBuffer();
	        str.append("[");
	        for(int i=0; i<deuren.length; i++){
	            str.append(getDeur(i));
	             if(i<deuren.length-1)
	                str.append(", ");
	        }
	        str.append("]");
	        return str.toString();
	            
	    }    
	  /**
	     * Gives all windows
	     * 
	     * @param  y   index in array wielen
	     * @return     the selected Wheel
	     */
	    public String getVensters()
	    {
	        // put your code here
	        StringBuffer str = new StringBuffer();
	        str.append("[");
	        for(int i=0; i<vensters.length; i++){
	            str.append(getVenster(i));
	            if(i<vensters.length-1)
	                str.append(", ");
	        }
	        str.append("]");
	        return str.toString();
	            
	    }            
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Deze Boot is "+getKleur()+" en heeft "+getDeuren()+"Deuren \n"+getVensters()+"Vensters ");
		return buffer.toString();
	}
	
}
