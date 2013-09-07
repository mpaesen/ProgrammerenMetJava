package behavioral.observer;

public interface LineSubject {
	public void addObserver(LineObserver observer);
	public String getLine();
	public void notifyObservers();
	public void removeObserver(LineObserver observer);
}
