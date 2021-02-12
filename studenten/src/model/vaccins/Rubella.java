package model.vaccins;

import model.Patient;
import model.Vaccin;
import model.exceptions.AlreadyVaccinatedException;
import persistency.VaccinLogger;
import utils.Globals;

import java.util.List;
import java.util.stream.Collectors;

public class Rubella extends Vaccin {

    @Override
    protected void registreren(Patient patient) throws AlreadyVaccinatedException {
        List<Vaccin> covids = patient.getVaccins().stream().filter(p->p.getClass() == Covid.class).collect(Collectors.toList());

        // je mag maar 1x gevaccineerd worden met dit Covid-vaccin
        if (covids.stream().count()>=2){
            throw new AlreadyVaccinatedException();
        }
        else if (covids.stream().count()==1) {
            VaccinLogger.log().warn(Globals.prefixVaccinatie + String.format("Patiënt geregistreerd voor 2de inenting! Eerste inenting was op %tF", covids.get(0).getVaccinatieDatum()));
        }
        else {
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "Covid oproepingsbrief ingevuld, afgetekend en gescand in het systeem. Patiënt is geregistreerd voor inenting.");
        }
    }

    @Override
    protected void informeren() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Alle informatie over rode hond werd meegedeeld. Ook de info over anti-vaccers.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Informeer de patiënt dat het nieuwe vaccin voortaan intraveneus wordt toegediend.");
    }

    @Override
    protected void voorbereiden() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Houdt het vaccin op gekoelde temperatuur. Maximum temperatuur is 12°C.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Leg de lijn klaar en het baxter dat dient om de koude temperatuur van het vaccin op te vangen bij het injecteren.");
    }

    @Override
    protected void toedienen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "Enkel de dokter mag een intraveneuze lijn leggen en het serum koud toedienen.");
        VaccinLogger.log().info(Globals.prefixVaccinatie + "Let op een schrikreactie van de patiënt. Zelden is die reactie zo fel dat de lijn losgetrokken wordt.");
    }

    @Override
    protected void nazorgen() {
        VaccinLogger.log().warn(Globals.prefixVaccinatie + "++ De prikplaats werd afgeplakt. De patiënt wacht nog 10 minuten na in de wachtzaal.");
    }

}
