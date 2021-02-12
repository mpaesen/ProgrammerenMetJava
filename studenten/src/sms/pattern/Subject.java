package sms.pattern;

import sms.model.CampagneStatus;

import java.util.ArrayList;

public abstract class Subject {
    protected ArrayList<Observer> observers;
    protected String status;

    //region getters & setters
    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
    //endregion

    public Subject() {
        this.observers = new ArrayList<Observer>();
        this.status = String.valueOf(CampagneStatus.Open);
    }

    public void attach(Observer observer) {
        // je kan je inschrijven bij de centrale instantie, maar slechts 1 x
        if (observers.stream().filter(p->p.equals(observer)).count()==0) {
            observers.add(observer);
        }
    }

    public void detach(Observer observer) {
        // je kan je uitschrijven bij de centrale instantie
        if (observers.stream().filter(p->p.equals(observer)).count()==1) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() { // verstuur sms
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

}
