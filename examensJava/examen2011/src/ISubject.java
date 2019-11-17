
/**
 * Write a description of interface ISubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface ISubject
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers();
}
