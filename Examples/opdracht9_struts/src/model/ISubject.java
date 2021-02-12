package model;

/**
 * @author Rudy Nelen
 */


public interface ISubject 
{	
	public void registerObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notifyObservers();	
}
