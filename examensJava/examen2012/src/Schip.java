
/**
 * Write a description of class Schip here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Schip extends Actor implements Observer 
{
    private Verkeerstoren verkeerstoren;
    private double koers;
    private double snelheid;
    private int capaciteit;
    private double grootte;
    private Locatie bestemming;
    private Bericht laatsteBericht;
    /**
     * Constructor for objects of class Schip
     */
    public Schip(Locatie locatie)
    {
        super(locatie);
    }
    public void update(Schip schip){ 
    //stuur locatie van schip in nood
        bestemming = schip.getLocatie();
        System.out.printf("%s","\n\tKoers gewijzigd naar bestemming :"+bestemming);
    }
    public void setSnelheid(double snelheid){ 
        this.snelheid = snelheid;
    }
    public void setGrootte(double grootte){ 
        this.grootte = grootte;
    }
    public void setCapaciteit(int capaciteit){ 
        this.capaciteit = capaciteit;
    }
    public void setKoers(double koers){ 
        this.koers = koers;
    }
    public void stuurBericht(){ 
        //meld locatie en koers aan verkeerstoren om de 10'
        setLaatsteBericht();
        verkeerstoren.updateLocatie(this);
        System.out.printf("%s", "\nBericht verzonden");
    }
    public Verkeerstoren getVerkeerstoren(){
        return verkeerstoren;
    }
    public void setVerkeerstoren(Verkeerstoren verkeerstoren){
        this.verkeerstoren = verkeerstoren;
        verkeerstoren.registerObserver(this);
    }
    private void setLaatsteBericht(){
         laatsteBericht = new Bericht(this.getLocatie(), this.getFuncties().getKoers());

    }
    public void help(){
        setLaatsteBericht();
        laatsteBericht.sendSOS();
    }
    
    public boolean isGeschikt(Schip schipInNood){
        //test of schip voldoet om hulp te bieden
        //op basis van capaciteit, afstand, grootte en reactietijd
        if(this.getFuncties().getCapaciteit() >= schipInNood.getFuncties().getCapaciteit()){
            return true;
        }
        return false;
    }
    
    public String toString(){
    	
    	return "Schip op locatie "+getLocatie();
    }
    public boolean equals(Schip schip){
    	if (this.getLocatie().equals(schip.getLocatie())){
    		return true;
    }
    	return false;
    }
}