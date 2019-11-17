import java.util.List;
/**
 * Abstract class Actor - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Actor
{
    // instance variables - replace the example below with your own
    private Locatie locatie;
    public Actor(Locatie locatie){
        this.locatie = locatie;
    }
    public Locatie getLocatie(){
        return locatie;
    }
}
