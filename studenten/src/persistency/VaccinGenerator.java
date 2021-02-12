package persistency;

import model.Patient;
import model.Vaccin;
import model.exceptions.DoesNotExistsException;
import utils.Meta;
import utils.RandomDate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Random generator voor vaccins
 * De lijst van beschikbare vaccins om te genereren wordt via meta-data opgehaald uit de package model.vaccins.
 * In deze package zitten alle subclasses van de abstracte class 'Vaccin' en een enumerator is bijgevolg niet nodig.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-20
 */
public class VaccinGenerator {

    private static Vaccin vaccin;

    // als we een random vaccin willen voor een patient (historiek) dan geven we de geboortedatum mee
    // en wordt dat vaccin ergens tijdens het leven van de patient toegediend
    public static Vaccin createRandomVaccin(Patient patient) throws DoesNotExistsException {
        return createRandomVaccin(patient.getGeboorteDatum());
    }

    // als we een random vaccin willen, zonder dat we patient kennen, dan krijg je een vaccin met een
    // willekeurige datum van toedienen tussen 19xx en nu
    public static Vaccin createRandomVaccin() throws DoesNotExistsException {
        return createRandomVaccin(RandomDate.randomLocalDate());
    }

    private static Vaccin createRandomVaccin(LocalDate geboorteDatum) throws DoesNotExistsException {
        try {
            ArrayList<String> vaccins = Meta.getPackageClasses("model.vaccins");
            int randomValue = new Random().nextInt((int) vaccins.stream().count());
            vaccin = VaccinFactory.createVaccin(vaccins.get(randomValue));

            vaccin.setVaccinatieDatum(RandomDate.randomLocalDate(geboorteDatum));
            return vaccin;
        }
        catch (IOException e) {
            VaccinLogger.log().error("IO error while screening package 'model.vaccins' for subclasses! No random vaccin can be created!");
            throw new DoesNotExistsException("");
        }
        catch (ClassNotFoundException e) {
            VaccinLogger.log().error("Subclasses from package 'model.vaccins' are not found! No random vaccin can be created!");
            throw new DoesNotExistsException("");
        }
    }

}
