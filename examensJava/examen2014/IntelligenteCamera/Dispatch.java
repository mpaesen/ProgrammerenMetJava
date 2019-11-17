import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;
/**
 * Write a description of class Dispatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dispatch extends Actor implements Subject
{
    // instance variables - replace the example below with your own
    private List<Voertuig> geseind;
    private List<Voertuig> gesignaleerd;
    private List<Camera> cameras;
    private List<Patrouille> patrouilles;

    /**
     * Constructor for objects of class Dispatch
     */
    public Dispatch(Locatie locatie)
    {
        // initialise instance variables
        super(locatie);
        geseind = new LinkedList<Voertuig>();    
        gesignaleerd = new LinkedList<Voertuig>();    
        cameras = new LinkedList<Camera>();
        patrouilles = new LinkedList<Patrouille>();
    }
    public void signaleer(Voertuig voertuig){
        if(geseind.contains(voertuig)){
            gesignaleerd.add(voertuig);
            notifyObservers();
        }
    }
    public void remove(Voertuig voertuig){
        if(!geseind.contains(voertuig) && (gesignaleerd.contains(voertuig))){
            gesignaleerd.remove(voertuig);
            notifyObservers();
        }
    }
    public void notifyObservers(){
        ListIterator list = patrouilles.listIterator();
        while(list.hasNext()){
            ((Patrouille)list.next()).update(gesignaleerd);
        }
    }
    public void registerObserver(Patrouille patrouille){
        patrouilles.add(patrouille);
    }
    public void removeObserver(Patrouille patrouille){
        patrouilles.remove(patrouille);
    }
}
