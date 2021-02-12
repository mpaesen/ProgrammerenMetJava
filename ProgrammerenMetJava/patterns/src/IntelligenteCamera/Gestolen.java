package IntelligenteCamera;

/**
 * Write a description of class Gestolen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gestolen extends VoertuigDecorator {
    /**
     * Constructor for objects of class Gestolen
     */
    public Gestolen(IVoertuig voertuig) {
        super(voertuig);
    }

    @Override
    public String toString() {
        return super.toString() + " is Gestolen";
    }
}
