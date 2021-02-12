import model.Patient;
import persistency.PatientGenerator;
import persistency.VaccinatieGenerator;

import java.io.IOException;
import java.util.ArrayList;

/**
 * OEFENING OP HET GEBRUIK VAN HET TEMPLATE PATTERN -->
 *      template = Vaccin --> abstraheert alle complexiteit omtrent het vaccineren
 *
 * Dit is de startclass van de applicatie. Patiënten worden gegenereerd en een vaccinatiecampagne wordt gestart.
 * Alle activiteiten worden gelogd naar de console en naar een logfile via Log4J.
 *              zie de log4j.properties
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20
 */
public class Vaccinatie {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //step 1 we genereren een aantal fictieve patiënten met of zonder historiek aan vaccins
        ArrayList<Patient> patients = PatientGenerator.createRandomListOfPatients();

        // step 2 we dienen een aantal willekeurige vaccins toe aan patiënten
        VaccinatieGenerator.performVaccinaties(patients);

        System.in.read();

    }
}
