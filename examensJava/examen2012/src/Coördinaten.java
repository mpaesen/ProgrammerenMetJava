
/**
 * Write a description of class Coördinaten here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Coördinaten
{
    // instance variables - replace the example below with your own
    private double breedte; 
    private double lengte; 


    /**
     * Constructor for objects of class CoÃ¶rdinaten
     */
    public Coördinaten(double breedte,double lengte)
    {
        // initialise instance variables
       this.lengte = lengte;
       this.breedte = breedte;
    }


    public double getBreedte()
    {
        // put your code here
        return breedte;
    }   

    public double getLengte()
    {
        // put your code here
        return lengte;
    }   
    public String toString(){
        return String.format("%s\t%s", "Breedte " + breedte, "Lengte "+lengte);
    }
    public boolean equals(Coördinaten coördinaten){
    	if(this.breedte == coördinaten.getBreedte() && this.lengte == coördinaten.getLengte()){
    		return true;
    	}
    	return false;
    
    }
}
