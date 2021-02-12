package sms.pattern;

public abstract class Observer {
    protected Subject subject;
    public abstract void update(Subject subject); //verstuur SMS
}
