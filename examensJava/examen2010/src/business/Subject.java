package business;

/**
 * Write a description of interface Subject here.
 * 
 * @author Mathy 
 * @version 1.0
 */

public interface Subject
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    void addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers();
}
