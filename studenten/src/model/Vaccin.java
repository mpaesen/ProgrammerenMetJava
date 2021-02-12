package model;

import model.exceptions.AlreadyVaccinatedException;
import model.exceptions.PatientAgeException;
import persistency.VaccinLogger;
import utils.Globals;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vaccin {

    private LocalDate vaccinatieDatum;

    //region getters & setters
    public LocalDate getVaccinatieDatum() {
        return vaccinatieDatum;
    }

    public void setVaccinatieDatum(LocalDate vaccinatieDatum) {
        this.vaccinatieDatum = vaccinatieDatum;
    }
    //endregion

    abstract protected void registreren(Patient patient) throws PatientAgeException, AlreadyVaccinatedException;
    abstract protected void informeren();
    abstract protected void voorbereiden();
    abstract protected void toedienen();
    abstract protected void nazorgen();

    public final boolean vaccineren(Patient patient) {
        try {
            registreren(patient); //er zijn vacins die maar één keer mogen toegediend worden
            informeren();
            voorbereiden();
            toedienen();
            nazorgen();
            return true;
        }
        catch (PatientAgeException e) {
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "-- " + e.getMessage());
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "-- Deze vaccinatie kan niet verder behandeld worden en wordt stopgezet. De patiënt werd geïnformeerd en begeleid.");
            return false;
        }
        catch (AlreadyVaccinatedException e) {
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "-- " + e.getMessage());
            VaccinLogger.log().warn(Globals.prefixVaccinatie + "-- Het is momenteel niet toegelaten deze vaccinatie verder te zetten. De patiënt werd geïnformeerd en begeleid.");
            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Gevaccineerd op %tF voor %s", getVaccinatieDatum(), this.getClass().getSimpleName());
    }

}
