package IntelligenteCamera;

import java.util.LinkedList;

/**
 * Write a description of class Patrouille here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patrouille extends Actor implements Observer {
    private static int number;
    // instance variables - replace the example below with your own
    private PatrouilleState state;
    private LinkedList<IVoertuig> gesignaleerd;

    /**
     * Constructor for objects of class Patrouille
     */
    public Patrouille(Locatie locatie) {
        super(locatie);
        setCounter(++number);
    }

    public void update(LinkedList<IVoertuig> gesignaleerd) {
        this.gesignaleerd = gesignaleerd;
    }


}
