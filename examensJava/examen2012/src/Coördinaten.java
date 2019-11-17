
/**
 * Write a description of class Co�rdinaten here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Co�rdinaten
{
    // instance variables - replace the example below with your own
    private double breedte; 
    private double lengte; 


    /**
     * Constructor for objects of class Coördinaten
     */
    public Co�rdinaten(double breedte,double lengte)
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
    public boolean equals(Co�rdinaten co�rdinaten){
    	if(this.breedte == co�rdinaten.getBreedte() && this.lengte == co�rdinaten.getLengte()){
    		return true;
    	}
    	return false;
    
    }
}
