package model;

/**
 * @author Rudy Nelen
 */


public interface IObserver 
{
	public void update(int itemId, double amount, Sale sale);
}
