package persistency;

import org.apache.log4j.Logger;


/**
 * De Log4j logger-class
 *
 * De instellingen voor log4j zijn opgenomen in een properties file en die file zit in een package die
 * gemarkeerd is als 'resource'. Het doel is om uiteindelijk 2 logs te voorzien. Eentje op de console
 * en eentje als file. Afhankelijk van het loglevel dat gebruikt wordt bij het wegschrijven van de log
 * komt de log wel of niet in de file.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-19
 */
public final class VaccinLogger {

    private static Logger logger;

    private VaccinLogger() { }
    private static void setLogger(Logger logger) {
        VaccinLogger.logger = logger;
    }
    private static void initialize() {
        setLogger(Logger.getLogger("Vaccinatie")); // we voorzien 1 logger
    }

    public static Logger log() {
        if (logger == null) { initialize(); }
        return logger;
    }

}
