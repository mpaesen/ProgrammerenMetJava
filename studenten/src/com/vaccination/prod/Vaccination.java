package com.vaccination.prod;
import com.vaccination.prod.factory.*;

/**
 * Vaccination
 * <p>
 *     This class contains 2objects
 *     - Patient
 *     - Vaccine
 * </p>
 *
 */
public class Vaccination {

    private Vaccine myVaccine;
    private Patient patient;

    public Vaccination(Vaccine myVaccine,  Patient patient) {
        this.myVaccine = myVaccine;
        this.patient = patient;
    }

    public Vaccine getMyVaccine() {
        return myVaccine;
    }

    public Patient getPatient() {
        return patient;
    }
}
