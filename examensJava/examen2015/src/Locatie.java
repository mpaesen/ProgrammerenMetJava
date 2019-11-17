

public class Locatie
{
    private Coordinaten coordinaten;
    public Coordinaten getLocatie(){
        return coordinaten;
    } 
    public void setLocatie(Coordinaten coordinaten){
        this.coordinaten = coordinaten;
    }
    public String toString(){
        return coordinaten.toString();
    }
}
