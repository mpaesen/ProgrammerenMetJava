import java.util.Random;

/**
 * Write a description of class Randomizer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Randomizer
{
    // instance variables - replace the example below with your own
    private static Random random;
    /**
     * Constructor for objects of class Randomizer
     */
    public Randomizer()
    {
        // initialise instance variables
        random = new Random();
    }

    public static NummerPlaat getNummerPlaat(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        StringBuffer nummerPlaat = new StringBuffer();
        nummerPlaat.append("1-");
        for(int i = 0; i<3; i++){
            nummerPlaat.append(letters.charAt(random.nextInt(26)));
        }
        nummerPlaat.append("-");
        for(int i = 0; i<3; i++){
            nummerPlaat.append(random.nextInt(10));
        }
        return new NummerPlaat(nummerPlaat.toString());
    }
    
    public static String getMerk(){
        String merken[] = {"Ford", "VW","Hyundai","Opel","Chevrolet","Citroën","Renault","Seat","Skoda","Toyota","Lada","Mitsubishi","Nissan","Dacia","Jaguar","Mercedes","BMW","Porche","Range Rover"};
        return merken[random.nextInt(merken.length)];
    }
    
    public static Locatie getLocatie(){
        String []straten = {"Tiensestraat", "Brusselsestraat", "Naamsestraat", "Diestestraat","Tiensevest", "Brusselsevest", "Naamsevest", "Diestevest", "Brouwersstraat", "Vesaliusstraat", "Dekenstraat", "Capucijnenvoer", "Schapenstraat", "Herenstraat", "Vanwayenberglaan", "Pieter de somer plein"};
        StringBuffer locatie = new StringBuffer();
        locatie.append(straten[random.nextInt(straten.length)]);
        locatie.append(" ");
        locatie.append(random.nextInt());
        return new Locatie(locatie.toString());
    }
}
