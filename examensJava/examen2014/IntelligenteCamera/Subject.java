import java.util.List;
/**
 * Write a description of interface Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject
{
    public void registerObserver(Patrouille voertuig);
    public void removeObserver(Patrouille voertuig);
    public void notifyObservers();
}
