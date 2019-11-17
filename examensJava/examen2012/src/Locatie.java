

/**
 * Write a description of class Locatie here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Locatie
{
    private Coördinaten coördinaten;
    public Coördinaten getLocatie(){
        return coördinaten;
    } 
    public void setLocatie(Coördinaten coördinaten){
        this.coördinaten = coördinaten;
    }
    public String toString(){
        return coördinaten.toString();
    }
    public boolean equals(Locatie locatie){
    	if(this.coördinaten.equals(locatie.getLocatie())){
    		return true;
    	}
    	return false;
    }
}
