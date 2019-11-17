import java.util.List;
/**
 * Abstract class Actor - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Actor
{
    // instance variables - replace the example below with your own
    private BasisFuncties functies;
    private List<Verkeerstoren> verkeerstorens;
    private Locatie locatie;
    public Actor(Locatie locatie){
        this.locatie = locatie;
    }
    public void setFuncties(BasisFuncties functies){
        this.functies = functies;
    } 
    
    public BasisFuncties getFuncties(){
        return functies;
    } 
    public double getAfstand(Actor actor){
        return 1.0;
    }
    public Locatie getLocatie(){
        return locatie;
    }
}
