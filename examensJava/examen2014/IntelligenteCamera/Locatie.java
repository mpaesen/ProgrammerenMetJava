
/**
 * Write a description of class Coördinaten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Locatie
{
    // instance variables - replace the example below with your own
   
    private String locatie;

    /**
     * Constructor for objects of class Coördinaten
     */
    public Locatie(String locatie)
    {
        // initialise instance variables
        setLocatie(locatie);
    }
    public void setLocatie(String locatie){
        this.locatie = locatie;
    }
    public String getLocatie(){
        return locatie;
    }

}
