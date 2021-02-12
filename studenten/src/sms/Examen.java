package sms;

import persistency.VaccinLogger;
import sms.model.Campagne;
import sms.model.CampagneStatus;
import sms.model.Person;
import sms.pattern.Observer;
import sms.utils.CampagneGenerator;
import sms.utils.ObserverGenerator;
import sms.utils.PersonGenerator;
import sms.utils.SystemProperty;
import utils.Globals;

import javax.swing.*;
import java.util.ArrayList;

public class Examen {
    private static ArrayList<Person> persons;
    private static ArrayList<Campagne> campagnes;

    public static void main(String[] args) {
        VaccinLogger.log().warn("Start van het examen (" + SystemProperty.getUserName() + ")");

        // voorbereiding
        persons = PersonGenerator.createRandomListOfPersons();
        campagnes = CampagneGenerator.createRandomListOfCampagnes(persons);

        // start keuzemenu
        String menuResponse = "";
        Boolean menuRepeat;
        do {
            menuResponse =  menuShow(menuResponse);
            switch (menuResponse)
            {
                case "1":
                    menuShowPersons();
                    break;
                case "2":
                    menuShowCampagnes();
                    break;
                case "3":
                    menuShowOneCampagne();
                    break;
                case "4":
                    if (menuGenereerInschrijvingen()) {
                        menuShowCampagnes();
                    };
                    break;
                case "5":
                    menuVerstuurSMS();
                    break;
                case "9":
                    break;
                default:
                    VaccinLogger.log().debug("Verkeerde keuze gemaakt");
                    JOptionPane.showMessageDialog (null, "Dit is geen geldige keuze.\nGeef het getal in van jouw keuze of het nummer 9 om te stoppen.");
            }

            menuRepeat = (menuResponse.equals("9") || menuResponse.equals("")) ? false : true;
        } while (menuRepeat);

        // stop
        VaccinLogger.log().debug("Stop van het examen.(" + SystemProperty.getUserName() + ")");
    }

    private static String menuShow(String previousResponse) {
        try {
            String message = previousResponse == "" ? "Welkom op het Examen Java Basis! Check de console!\n\n" : "";
            message = message + "Maak een keuze uit onderstaande opties en geef dat getal in:" +
                    "\n1. Oplijsten van alle gegenereerde personen" +
                    "\n2. Oplijsten van alle gegenereerde campagnes" +
                    "\n3. Details van de inschrijvingen van één campagne" +
                    "\n4. Genereer bijkomende inschrijvingen voor één campagne" +
                    "\n" +
                    "\n5. Sluit een campagne af en verstuur alle notificaties !!!" +
                    "\n" +
                    "\n\n9. Stop het Examen";
            return JOptionPane.showInputDialog(message);
        }
        catch (Exception e) {
            VaccinLogger.log().debug("ISSUE when retrieving menuShow() -> " + e.getMessage());
            VaccinLogger.log().debug("Application will abort!");
            return "9";
        }
    }

    private static boolean menuGenereerInschrijvingen() {
        Campagne campagne;
        int campagneNr = 0;
        try {
            campagneNr = Integer.parseInt(JOptionPane.showInputDialog("Voor welke [open] campagne? Geef het nummer of 0 om af te breken."));
            campagne = campagnes.get(campagneNr - 1); // zero based index

            if (campagne != null) {
                if (campagne.getStatus().equalsIgnoreCase(String.valueOf(CampagneStatus.Open)) ) {
                    ObserverGenerator.createRandomObservers(campagne, persons);
                    return true;
                }
                else {
                    VaccinLogger.log().warn("Campagne niet meer open!");
                    JOptionPane.showMessageDialog (null, "Deze campagne is niet meer open!");
                    return false;
                }
            }
            else { return false; }

        }
        catch (Exception e) {
            if (campagneNr != 0) {
                VaccinLogger.log().warn("Foutief campagnenummer");
                JOptionPane.showMessageDialog (null, "Het campagnenummer is ongeldig.");
            }
            return false;
        }
    }

    private static void menuVerstuurSMS() {
        Campagne campagne;
        int campagneNr = 0;
        try {
            campagneNr = Integer.parseInt(JOptionPane.showInputDialog("Welke [open] campagne sluit je af? Geef 0 in om af te breken."));
            campagne = campagnes.get(campagneNr - 1); // zero based index

            if (campagne != null) {
                if (campagne.getStatus().equalsIgnoreCase(String.valueOf(CampagneStatus.Open)) ) {
                    campagne.setStatus(String.valueOf(CampagneStatus.Closed)); // this does the trick
                }
                else {
                    VaccinLogger.log().warn("Campagne niet meer open!");
                    JOptionPane.showMessageDialog (null, "Deze campagne is niet meer open!");
                }
            }

        }
        catch (Exception e) {
            if (campagneNr != 0) {
                VaccinLogger.log().warn("Foutief campagnenummer");
                JOptionPane.showMessageDialog (null, "Het campagnenummer is ongeldig.");
            }
        }
    }

    private static void menuShowPersons() {
        VaccinLogger.log().warn("");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("Huidige lijst met gekende personen");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");
        for (Person person: persons) {
            VaccinLogger.log().warn(person);
        }
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");
    }

    private static void menuShowOneCampagne() {
        Campagne campagne;
        int campagneNr = 0;
        try {
            campagneNr = Integer.parseInt(JOptionPane.showInputDialog("Van welke campagne wil je details? Geef 0 in om af te breken."));
            campagne = campagnes.get(campagneNr - 1); // zero based index

            if (campagne != null) {
                VaccinLogger.log().warn("");
                VaccinLogger.log().warn("-".repeat(Globals.dashes));
                VaccinLogger.log().warn(campagne.toStringLong());
                VaccinLogger.log().warn("-".repeat(Globals.dashes));
                for (Observer observer: campagne.getObservers()) {
                    VaccinLogger.log().warn(observer);
                }
                VaccinLogger.log().warn("-".repeat(Globals.dashes));
                VaccinLogger.log().warn("");
            }

        }
        catch (Exception e) {
            if (campagneNr != 0) {
                VaccinLogger.log().warn("Foutief campagnenummer");
                JOptionPane.showMessageDialog (null, "Het campagnenummer is ongeldig.");
            }
        }
    }

    private static void menuShowCampagnes() {
        int i = 1;
        VaccinLogger.log().warn("");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("Huidige lijst met lokale campagnes waar personen zich voor kunnen registreren");
        VaccinLogger.log().warn("  er zijn momenteel " + campagnes.stream().count() + " gekende campagnes");
        VaccinLogger.log().warn("  daarvan hebben er " + campagnes.stream().filter(p->p.getObservers().stream().count()>0).count() + " reeds 1 of meerdere registraties van personen");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
        VaccinLogger.log().warn("");
        for (Campagne aCampagne: campagnes) {
            VaccinLogger.log().warn(String.format("%2d",i++) + ". " + aCampagne.toStringLong());
        }
        VaccinLogger.log().warn("");
        VaccinLogger.log().warn("-".repeat(Globals.dashes));
    }

}
