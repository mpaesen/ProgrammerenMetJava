/* Generated by Together */

package tegenpartijen;

import java.util.Vector;

final public class ProfessioneleTegenPartij extends ATegenpartij {
    public String getBtwNummer(){ return btwNummer; }

    public void setBtwNummer(String btwNummer){ this.btwNummer = btwNummer; }

    public Adres getAdres(){ return adres; }

    public void setAdres(Adres adres){ this.adres = adres; }

    public ProfessioneleTegenPartij(String naam, SoortRelatie soortRelatie, Adres adres) {
        super(naam, soortRelatie);
        this.adres = adres;
    }

    public String toString() {
        return super.toString();
    }

    public String toonAdresGegevens(){
    	return getAdres().toString();
    }


    private String btwNummer;
    private Adres adres;
}
