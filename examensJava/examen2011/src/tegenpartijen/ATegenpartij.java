/* Generated by Together */

package tegenpartijen;

import java.util.*;

abstract public class ATegenpartij implements Tegenpartijen {
    public ATegenpartij(String naam, SoortRelatie soortRelatie) {
        setNaam(naam);
        setSoortRelatie(soortRelatie);
    }

    public String getNaam(){ return naam; }

    public void setNaam(String naam){ this.naam = naam; }

    private String naam;

    public String toString() {
        return "\n"+naam+soortRelatie.toString();
    }

    public String toonNaam(){return toString();}

    public SoortRelatie getSoortRelatie(){ return soortRelatie; }

    public void setSoortRelatie(SoortRelatie soortRelatie){ this.soortRelatie = soortRelatie; }

    private Vector adressen;
    private SoortRelatie soortRelatie;
}
