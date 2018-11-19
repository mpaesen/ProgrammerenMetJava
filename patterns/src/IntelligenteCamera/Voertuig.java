package IntelligenteCamera;

/**
 * Write a description of class Voertuig here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voertuig extends Actor implements IVoertuig
{
    // instance variables - replace the example below with your own
    private NummerPlaat nummerPlaat;
    private String merk;
    private static int number;

    /**
     * Constructor for objects of class Voertuig
     */
    public Voertuig(Locatie locatie, NummerPlaat nummerPlaat, String merk)
    {
        // initialise instance variables
        super(locatie);
        this.nummerPlaat = nummerPlaat;
        this.merk = merk;
        setCounter(++number);
    }
    // triviale properties en methods van een voertuig
    public NummerPlaat getNummerplaat(Foto foto){
        // nummerplaat herkenning op basis van foto
        return nummerPlaat;
    }
    
    public boolean isGeseind(){
            return nummerPlaat.isGeseind();
    }
    
    public String getGeseind(){
        return this.toString();
    }
    public void setGeseind(boolean geseind){
        nummerPlaat.setGeseind(geseind);
    }

    @Override
    public String toString(){
        return super.toString() + " met nummer plaat " +nummerPlaat.toString() ;}
}
