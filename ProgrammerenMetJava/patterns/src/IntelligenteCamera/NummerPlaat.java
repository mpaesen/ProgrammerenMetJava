package IntelligenteCamera;

/**
 * Write a description of class NummerPlaat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NummerPlaat {
    // instance variables - replace the example below with your own
    private boolean geseind;
    private String nummerPlaat;

    /**
     * Constructor for objects of class NummerPlaat
     */
    public NummerPlaat(String nummerPlaat) {
        // initialise instance variables
        this.nummerPlaat = nummerPlaat;
        this.geseind = false;
    }

    public boolean isGeseind() {
        //enkel geseinde voertuigen/nummerplaten worden weerhouden door geïnteresseerden
        //Er kunnen verschillende redenen zijn waarom een voertuig geseind staat
        return geseind;
    }

    //triviale properties en methods van een Nummerplaat
    public void setGeseind(boolean geseind) {
        this.geseind = geseind;
    }

    @Override
    public String toString() {
        return getNummerPlaat();
    }

    public String getNummerPlaat() {
        return nummerPlaat;
    }

    public void setNummerPlaat(String nummerPlaat) {
        this.nummerPlaat = nummerPlaat;
    }

}
