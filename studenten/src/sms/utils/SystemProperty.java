package sms.utils;

import persistency.VaccinLogger;

/**
 * SystemProperty voorziet enkele systeem-gebonden eigenschappen of handelingen.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-21
 */
public class SystemProperty {

    public static String getUserName() {
        try {
            return System.getProperty("user.name");
        }
        catch (Exception e) {
            VaccinLogger.log().debug("ISSUE when retrieving getUserName() -> " + e.getMessage());
            return "";
        }
    }
}