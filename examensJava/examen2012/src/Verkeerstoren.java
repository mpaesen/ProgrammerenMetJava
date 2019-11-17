import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Verkeerstoren here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Verkeerstoren extends Actor implements Subject 
{
    private List<Schip> schepenOnderKontrole;
    private List<Hulpdienst> hulpDiensten;
    public Verkeerstoren(Locatie locatie){
        super(locatie);
        schepenOnderKontrole = new ArrayList<Schip>();
    }   
    public void registerObserver(Schip schip){
        schepenOnderKontrole.add(schip);
    }
    public void removeObserver(Schip schip){
        schepenOnderKontrole.remove(schip);
    }
    public void notifyObservers(Schip schipInNood){
        System.out.printf("%s","\nSchip in nood, coördinaten :"+schipInNood.getLocatie());
        for(Schip schip:schepenOnderKontrole){
            
            if(!schip.equals(schipInNood) && schip.isGeschikt(schipInNood)){
            	System.out.printf("%s","\n"+schip+" gestuurd naar schip in nood!");
                schip.update(schipInNood);    
            }
        }
    }
    public void updateLocatie(Schip schip){
        schepenOnderKontrole.set(schepenOnderKontrole.indexOf(schip), schip);
    }
    
    private void sendSchip(Schip schip, Schip schipInNood){
        schip.setKoers(schipInNood.getFuncties().getKoers());
    }
}
