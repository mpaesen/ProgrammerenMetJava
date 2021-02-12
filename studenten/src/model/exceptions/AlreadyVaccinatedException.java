package model.exceptions;

public class AlreadyVaccinatedException extends Exception {
    public AlreadyVaccinatedException() {
        super("De patiënt werd reeds gevaccineerd. Een nieuwe vaccinatie is nu niet mogelijk.");
    }
}
