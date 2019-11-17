/* Generated by Together */

package testtegenpartijen;
import tegenpartijen.*;
import java.util.*;
import keybIO.*;

public class TestTegenPartijen {
    public static boolean nog(String  string) {
        char ok = 'N';
        System.out.println("Wenst u nog een "+string+" in te geven?");
        ok = KeybIO.readChar();KeybIO.readChar();
	return Character.toUpperCase(ok)=='J';
    }

    public static void main(String [] args) {
        //creatie van een retail Tegenpartij
        int i=0;
        System.out.println("Geef een retailer");
        String naam =    UI.setString("Naam");
        String voornaam =    UI.setString("Voornaam");        
        String omschrijving =    UI.setString("Relatieomschrijving");
        SoortRelatie relatie = new SoortRelatie(++i, omschrijving);
        Vector adressen = new Vector();

        boolean verblijfplaats = true;
        do{
            String straat =    UI.setString("straat");
	        String gemeente =    UI.setString("gemeente");
	        int nummer =    UI.setInteger("nummer");
    	    int postcode =    UI.setInteger("postcode");
            adressen.addElement(new Adres(straat, nummer, gemeente, postcode,verblijfplaats));
            verblijfplaats = false;
        }
        while (nog("adres"));

        RetailTegenpartij retail =
            new RetailTegenpartij(naam , voornaam, relatie, adressen);

	System.out.println(retail);
    }
}