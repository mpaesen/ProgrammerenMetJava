
/**
 * Write a description of interface Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject
{
    public void registerObserver(Schip schip);
    public void removeObserver(Schip schip);
    public void notifyObservers(Schip schipInNood);
}
