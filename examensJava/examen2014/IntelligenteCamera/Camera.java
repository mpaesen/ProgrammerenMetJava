
/**
 * Write a description of class Camera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camera extends Actor
{
    
    /**
     * Constructor for objects of class Camera
     */
    public Camera(Locatie locatie)
    {
        // initialise instance variables
        super(locatie);
    }
    public double getSnelheid(Voertuig voertuig){ 
    //snelheidsherkenning in km/u
        return 0.0;
    }
    public Voertuig getVoertuig(Foto foto){
    //herken voertuig op basis van foto
        
        return (Voertuig)ActorFactory.createActor(ActorFactory.VOERTUIG, getLocatie());
    }
    
    public Foto getFoto(){
        // fotograferen van een voertuig
            return new Foto();
    }

}
