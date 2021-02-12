package sms.model;

import persistency.VaccinLogger;
import sms.pattern.Observer;
import sms.pattern.Subject;
import utils.Globals;

public class Person extends Observer {
    private String naam;
    private String straat;
    private String postcode;
    private String gemeente;
    private String telefoonnummer;

    //region getters & setters
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
    //endregion

    public Person(String naam, String straat, String postcode, String gemeente) {
        this.naam = naam;
        this.straat = straat;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public Person(String naam, String straat, String postcode, String gemeente, String telefoonnummer) {
        this.naam = naam;
        this.straat = straat;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.telefoonnummer = telefoonnummer;
    }

    @Override
    public void update(Subject subject) {
        // staat niet in de opdracht maar dit zou rekening kunnen houden met een campagne die afgelast wordt
        // die controle zou ook in de subject method zelf kunnen zetten maar ik zie dat het pattern eerder deze
        // werkwijze voorstelt

        if (subject.getStatus().equalsIgnoreCase(String.valueOf(CampagneStatus.Closed))) {
            if (telefoonnummer != null) {
                VaccinLogger.log().warn(Globals.prefixVaccinatie + "SMS BERICHT OVER DE COVD CAMPAGNE TE " + subject +
                        "\n" + Globals.prefixVaccinatie + " voor persoon: " + this.toString());
            }
            else {
                VaccinLogger.log().warn(Globals.prefixVaccinatie + "BRIEF MET SPOED AAN HET ADRES VAN DE BETROKKEN PERSOON OVER COVID CAMPAGNE TE " + subject +
                        "\n" + Globals.prefixVaccinatie +  " voor persoon: " + this.toString());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-25s, %-30s, %-6s %-35s %-15s", naam, straat, postcode, gemeente, (telefoonnummer ==  null ? "" : telefoonnummer) );
    }
}
