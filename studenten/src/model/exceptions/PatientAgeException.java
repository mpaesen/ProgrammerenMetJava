package model.exceptions;

public class PatientAgeException extends Exception {
    public PatientAgeException() {
        super("De patiënt voldoet niet aan het leeftijdscriterium en kan daarom niet gevaccineerd worden.");
    }
}
