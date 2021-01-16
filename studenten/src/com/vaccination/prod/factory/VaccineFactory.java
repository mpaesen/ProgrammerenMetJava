package com.vaccination.prod.factory;


/**
 * Factory class This class returns an implementation of the Vaccine interface
 */
public class VaccineFactory {
    /**
     * getVaccine
     * <p>
     *     generate a  Vaccine object using the factory pattern
     * </p>
     * @param  vaccineName
     * @return implementation of Vaccine
     */
    public static Vaccine getVaccine(String vaccineName) {
        String vaccineNameU = vaccineName.toUpperCase();
        if ("COVID19".equals(vaccineNameU)) {
            return new Covid19();
        } else if ("DTP".equals(vaccineNameU)) {
            return new DifterieTetanusPolio();
        } else if ("HEPATITISB".equals(vaccineNameU)) {
            return new HepatitisB();
        } else if ("INFLUENZA".equals(vaccineNameU)) {
            return new Influenza();
        }
        return null;
    }
}
