package IntelligenteCamera;

/**
 * Abstract class Actor - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Actor {
    // instance variables -
    private Locatie locatie;
    private int counter;

    public Actor(Locatie locatie) {
        this.locatie = locatie;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    @Override
    public String toString() {
        return "\n\t " + getClass().getName() + " nr. " + getCounter() + " bevindt zich op " + getLocatie();
    }

}
