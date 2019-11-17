
/**
 * Write a description of class VoertuigDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class VoertuigDecorator implements IVoertuig
{
    // instance variables - replace the example below with your own
   private IVoertuig voertuig;
   public VoertuigDecorator(IVoertuig voertuig){
       this.voertuig = voertuig;
    }
    
    public String getGeseind(){
        return voertuig.toString();
    }
}
