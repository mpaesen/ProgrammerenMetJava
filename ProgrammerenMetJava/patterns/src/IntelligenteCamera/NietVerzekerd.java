package IntelligenteCamera;

/**
 * Write a description of class NietVerzekerd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NietVerzekerd extends VoertuigDecorator {
    public NietVerzekerd(IVoertuig voertuig) {
        super(voertuig);
    }


    @Override
    public String toString() {
        return getGeseind() + " Niet Verzekerd";
    }
}
