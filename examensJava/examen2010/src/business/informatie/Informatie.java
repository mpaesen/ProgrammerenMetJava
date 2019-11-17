package business.informatie;

import java.util.ArrayList;
import java.util.Iterator;

import business.Observer;
import business.Subject;
import business.Verplaatsing;
import business.berichten.Bericht;
import business.Datum;

/**
 * Abstract class Informatie - write a description of the class here
 * 
 * @author Mathy
 * @version 1.0
 */
public abstract class Informatie implements Subject {
	// instance variables - replace the example below with your own
	private Verplaatsing verplaatsing;
	private ArrayList<Bericht> berichten;
	private ArrayList<Observer> observers;

	public Informatie(Verplaatsing verplaatsing, ArrayList<Bericht> berichten) {
		super();
		this.verplaatsing = verplaatsing;
		this.berichten = berichten;
		observers = new ArrayList<Observer>();
	}

	public ArrayList<Bericht> getBerichten() {
		return berichten;
	}

	public void setBerichten(ArrayList<Bericht> berichten) {
		this.berichten = berichten;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public Informatie(ArrayList<Bericht> berichten, Verplaatsing verplaatsing,
			Datum date) {
		super();
		this.berichten = berichten;
		this.verplaatsing = verplaatsing;
		observers = new ArrayList<Observer>();
	}

	public Verplaatsing getVerplaatsing() {
		return verplaatsing;
	}

	public void setVerplaatsing(Verplaatsing verplaatsing) {
		this.verplaatsing = verplaatsing;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			iterator.next().update(this);
		}
	}

	@Override
	public boolean removeObserver(Observer observer) {
		if (!observers.isEmpty() && (observers.contains(observer))) {
			observers.remove(observer);
			notifyObservers();
			return true;
		}
		return false;
	}

	public Iterator<Observer> iterator() {
		return observers.iterator();
	}

	@Override
	public String toString() {
		return "Informatie [berichten=" + berichten + ", verplaatsing="
				+ verplaatsing + "]";
	}
}
