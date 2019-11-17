import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;
/**
 * Test basis functionaliteiten Schip in Nood
 * 
 * @author Mathy Paesen 
 * @version 6/01/2013
 */
public class Rescue
{
    private static List<Verkeerstoren> verkeerstorens;
    private static List<Hulpdienst> hulpdiensten;
    private static List<Schip> schepen;
    private static Random random = new Random();
    private static Locatie locatie = new Locatie();
    private static  Coördinaten coördinaten;
    private static final int AANTAL = 20;
    private static final double RECHT = 90.0;
    
    public static void main(String [] args){
        verkeerstorens = new ArrayList<Verkeerstoren>();
        randomVerkeerstoren(verkeerstorens);
        hulpdiensten = new ArrayList<Hulpdienst>();
        randomHulpdiensten(hulpdiensten);
        schepen = new ArrayList<Schip>();
        randomSchepen(schepen);
        
        Schip schipInNood = (Schip)schepen.get(random.nextInt(schepen.size()));
        Verkeerstoren controle = schipInNood.getVerkeerstoren();
        
        controle.notifyObservers(schipInNood);
    }
    
    @SuppressWarnings("rawtypes")
	public static void randomVerkeerstoren(List list){

        for(int i = 0; i<random.nextInt(AANTAL); i++){
        	coördinaten = new Coördinaten(random.nextDouble() * RECHT, random.nextDouble() * RECHT);
            locatie.setLocatie(coördinaten);
            list.add(ActorFactory.createActor(1, locatie));
        }
        
    }
     
    
       public static void randomSchepen(List<Schip> list){        
        Locatie locatie = new Locatie();
        ListIterator<Verkeerstoren> iterator = verkeerstorens.listIterator();
        Verkeerstoren verkeerstoren;
        Schip schip;
       
        while(iterator.hasNext()){
            verkeerstoren = (Verkeerstoren)iterator.next();
            for(int i = 0; i<random.nextInt(AANTAL); i++){
            	coördinaten = new Coördinaten(random.nextDouble() * RECHT, random.nextDouble() * RECHT);
                locatie.setLocatie(coördinaten);
                schip = (Schip)ActorFactory.createActor(2, locatie);
                schip.setVerkeerstoren(verkeerstoren);
                list.add(schip);
            }
        }
    }
    
      @SuppressWarnings("rawtypes")
	public static void randomHulpdiensten(List list){
        for(int i = 0; i<random.nextInt(AANTAL); i++){
        	coördinaten = new Coördinaten(random.nextDouble() * RECHT, random.nextDouble() * RECHT);
            locatie.setLocatie(coördinaten);
            list.add(ActorFactory.createActor(3, locatie));
        }
    }
}