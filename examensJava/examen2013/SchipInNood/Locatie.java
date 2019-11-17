

public class Locatie
{
    private Coördinaten coördinaten;
    public Coördinaten getLocatie(){
        return coördinaten;
    } 
    public void setLocatie(Coördinaten coördinaten){
        this.coördinaten = coördinaten;
    }
    public String toString(){
        return coördinaten.toString();
    }
}
