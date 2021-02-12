package IntelligenteCamera;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class Dispatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dispatch extends Actor implements Subject
{
    // instance variables - replace the example below with your own
    private LinkedList<IVoertuig> geseind;
    private LinkedList<IVoertuig> gesignaleerd;
    private List<Camera> cameras;
    private List<Patrouille> patrouilles;
    private static int number;

    public LinkedList<IVoertuig> getGeseind() {
        return geseind;
    }

    public void setGeseind(LinkedList<IVoertuig> geseind) {
        this.geseind = geseind;
    }

    public void setGesignaleerd(LinkedList<IVoertuig> gesignaleerd) {
        this.gesignaleerd = gesignaleerd;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public void setPatrouilles(List<Patrouille> patrouilles) {
        this.patrouilles = patrouilles;
    }

    public LinkedList<IVoertuig> getGesignaleerd() {
        return gesignaleerd;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    public List<Patrouille> getPatrouilles() {
        return patrouilles;
    }

    /**
     * Constructor for objects of class Dispatch
     */
    public Dispatch(Locatie locatie)
    {
        // initialise instance variables
        super(locatie);
        geseind = new LinkedList<IVoertuig>();
        gesignaleerd = new LinkedList<IVoertuig>();
        cameras = new LinkedList<Camera>();
        patrouilles = new LinkedList<Patrouille>();
        super.setCounter(++number);
    }
    public void signaleer(IVoertuig voertuig){
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
        while(list.hasNext()) ((Patrouille) list.next()).update(gesignaleerd);
    }
    public void registerObserver(Patrouille patrouille){
        patrouilles.add(patrouille);
    }
    public void removeObserver(Patrouille patrouille){
        patrouilles.remove(patrouille);
    }
}
