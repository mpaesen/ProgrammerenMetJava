package sms.model;

import sms.pattern.Subject;

import java.time.LocalDate;

public class Campagne extends Subject {

    private String locatieNaam;
    private String straat;
    private String postcode;
    private String gemeente;
    private LocalDate geplandeDatum;

    //region getters & setters
    public LocalDate getGeplandeDatum() {
        return geplandeDatum;
    }

    public void setGeplandeDatum(LocalDate geplandeDatum) {
        this.geplandeDatum = geplandeDatum;
    }

    public String getLocatieNaam() {
        return locatieNaam;
    }

    public void setLocatieNaam(String locatieNaam) {
        this.locatieNaam = locatieNaam;
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
    //endregion

    public Campagne(String locatieNaam, String straat, String postcode, String gemeente, LocalDate geplandeDatum) {
        super(); // constructor van Subject uitvoeren, status = 'Open'
        this.locatieNaam = locatieNaam;
        this.straat = straat;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.geplandeDatum = geplandeDatum;
    }

    public String toStringLong() {
        return String.format("[%-6s] %-45s, %-30s, %-6s %-25s, inschrijvingen %5s [%tF]", getStatus(), locatieNaam, straat, postcode, gemeente, "(" + getObservers().stream().count() + ")", geplandeDatum);
    }

    @Override
    public String toString() {
        return String.format("%-45s, %-30s, %-6s %-25s", locatieNaam, straat, postcode, gemeente);
    }

}
