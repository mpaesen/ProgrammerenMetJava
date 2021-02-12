package persistency;

import model.Vaccin;
import model.exceptions.DoesNotExistsException;
import model.vaccins.Covid;
import model.vaccins.Polio;
import model.vaccins.Rubella;

import java.time.LocalDate;

/**
 * Aanmaken van een Vaccin object kan op basis van een String parameter die de naam van het vaccin bevat.
 * Je krijgt een vaccin object dat nog niet toegediend werd (dat zou nog kunnen mislukken) en waarvan de
 * datum van vaccinatie ingesteld is op vandaag.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20
 */
public class VaccinFactory {

    private static Vaccin vaccin;

    public static Vaccin createVaccin(String soortVaccin) throws DoesNotExistsException {
        switch (soortVaccin) {
            case "Covid" :
                vaccin = new Covid();
                break;
            case "Polio" :
                vaccin = new Polio();
                break;
            case "Rubella" :
                vaccin = new Rubella();
                break;
            default :
                throw new DoesNotExistsException("Het opgegeven vaccin '" + soortVaccin + "' bestaat niet!");
        }

        vaccin.setVaccinatieDatum(LocalDate.now());
        return vaccin;
    }

}
