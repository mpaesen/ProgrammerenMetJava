
/**
 * Write a description of class Bericht here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bericht
{
    private Locatie locatie;
    private double koers;
    public Bericht(Locatie locatie, double koers){
        this.locatie = locatie;
        this.koers = koers;
    }
    public double getKoers(){
        return koers;
    }
    public Locatie getLocatie(){
        return locatie;
    }
    public void sendSOS(){
      System.out.printf("%s", "\nHelp we zinken!");
    }
}
