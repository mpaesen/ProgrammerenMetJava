

/**
 * Write a description of class Locatie here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Locatie
{
    private Co�rdinaten co�rdinaten;
    public Co�rdinaten getLocatie(){
        return co�rdinaten;
    } 
    public void setLocatie(Co�rdinaten co�rdinaten){
        this.co�rdinaten = co�rdinaten;
    }
    public String toString(){
        return co�rdinaten.toString();
    }
    public boolean equals(Locatie locatie){
    	if(this.co�rdinaten.equals(locatie.getLocatie())){
    		return true;
    	}
    	return false;
    }
}
