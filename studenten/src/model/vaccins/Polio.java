package model.vaccins;

import model.Patient;
import model.Vaccin;
import model.exceptions.PatientAgeException;
import persistency.VaccinLogger;
import utils.Globals;

public class Polio extends Vaccin {

    @Override
    protected void registreren(Patient patient) throws PatientAgeException {
        if (patient.leeftijd() > 12) {
            throw new PatientAgeException();
        }
        else { VaccinLogger.log().warn(Globals.prefixVaccinatie + "Kind-patiënt werd geregistreerd voor vaccinatie voor polio."); }
    }

    @Override
    protected void informeren() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Brochure werd overhandigd waarin het belang van vacciantie tegen polio zo belangrijk is.");
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Bijkomend werd de patiënt geïnformeerd over het aantal gevallen van polio in de laatste 10 jaar op het Europese continent.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Zorg dat de patiënt in een kamer is met minstens 25°C omdat het vaccin ook op kamertemperatuur moet zijn.");
    }

    @Override
    protected void voorbereiden() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Het serum moet opgelost worden met fysionlogisch water totdat de minimum dosis van 3ml opgenomen is in een spuit van 25cc.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Let op de kamertemperatuur!");
    }

    @Override
    protected void toedienen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "De dokter zet de spuit in het achterwerk.");
    }

    @Override
    protected void nazorgen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "++ De patiënt moet nog 15minuten plat blijven liggen en mag daarna aankleden en vertrekken.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "++ Plat blijven liggen is verplicht! Ook als de patiënt denkt dat alles ok is.");
    }
}
