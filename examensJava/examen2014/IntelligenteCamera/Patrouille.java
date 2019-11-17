import java.util.List;
/**
 * Write a description of class Patrouille here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Patrouille extends Actor implements Observer
{
    // instance variables - replace the example below with your own
   private PatrouilleState state;
   private List<Voertuig> gesignaleerd;
    /**
     * Constructor for objects of class Patrouille
     */
    public Patrouille(Locatie locatie){
        super(locatie);
    }
    public void update(List<Voertuig> gesignaleerd){
        this.gesignaleerd = gesignaleerd;
    }
    
    
}
