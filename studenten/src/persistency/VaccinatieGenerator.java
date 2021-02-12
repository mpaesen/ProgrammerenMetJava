package persistency;

import model.Patient;
import model.Vaccin;
import model.exceptions.DoesNotExistsException;
import utils.Globals;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deze class genereert een willekeurig aantal vaccinaties op een lijst van patiënten.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20*
 */
public class VaccinatieGenerator {

    public static void  performVaccinaties(ArrayList<Patient> patients) {
        int aantal = new Random().nextInt((int) (patients.stream().count())); // gewoon niet meer dan het aantal patiënten, mag uiteraard dubbel zoveel zijn

        VaccinLogger.log().warn("");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("Starten van de vaccinatie-campagne");
        VaccinLogger.log().warn("  er wordt maximaal " + aantal + " vaccinaties toegediend");
        VaccinLogger.log().warn("  dit gaat over verschillende vaccins en patiënten kunnen meermaals aan bod komen");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");

        for (int i = 0; i < aantal; i++) {
            int patientNummer = new Random().nextInt((int) patients.stream().count());
            Patient patient = patients.get(patientNummer);

            VaccinLogger.log().warn(Globals.prefixPatient + patient);

            try {
                Vaccin vaccin = VaccinGenerator.createRandomVaccin(patient);
                VaccinLogger.log().warn(Globals.prefixVaccin + "Start vaccantie voor " + vaccin.getClass().getSimpleName() + "");
                if (vaccin.vaccineren(patient)) {
                    patient.getVaccins().add(vaccin);
                    VaccinLogger.log().warn(Globals.prefixVaccinatie + "++ Vaccin voor " + vaccin.getClass().getSimpleName() + " werd correct toegediend.");
                }

            } catch (DoesNotExistsException e) {
                VaccinLogger.log().error("Er werd een vaccin gekozen dat niet bestaat. Dit kan niet worden toegediend.");
            }

            VaccinLogger.log().warn("");

        }

        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");

    }

}
