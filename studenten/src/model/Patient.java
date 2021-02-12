package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient {

    private String rijksregisterNummer;
    private String naam;
    private LocalDate geboorteDatum;
    private ArrayList<Vaccin> vaccins;

    public Patient(String rijksregisterNummer, String naam, LocalDate geboorteDatum) {
        this.rijksregisterNummer = rijksregisterNummer;
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.vaccins = new ArrayList<Vaccin>();
    }

    //region getters & setters
    public ArrayList<Vaccin> getVaccins() {
        return vaccins;
    }

    private void setVaccins(ArrayList<Vaccin> vaccins) {
        this.vaccins = vaccins;
    }

    public String getRijksregisterNummer() {
        return rijksregisterNummer;
    }

    public void setRijksregisterNummer(String rijksregisterNummer) {
        this.rijksregisterNummer = rijksregisterNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }
    //endregion

    public int leeftijd() {
        try {
            return Period.between(getGeboorteDatum(), LocalDate.now()).getYears();
        }
        catch (Exception e) { return 0; }
    }

    @Override
    public String toString() {
        return String.format("Patiënt %-30s %-20s geboren op %tF (%d)", getNaam(), getRijksregisterNummer(), getGeboorteDatum(), leeftijd());
    }

}
