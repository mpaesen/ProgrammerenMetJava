package sms.utils;

import sms.model.Campagne;
import sms.model.Person;

import java.util.ArrayList;
import java.util.Random;

public class ObserverGenerator {

    public static void createRandomObservers(Campagne campagne, ArrayList<Person> persons) {
        // we doen x aantal registraties van personen voor deze campagne
        // een persoon mag maar 1x registreren voor een campagne maar mag bij meerdere campagnes geregistreerd zijn
        int aantalRegistraties = new Random().nextInt((int) (persons.stream().count() / 5));
        for (int j = 0; j < aantalRegistraties; j++) {
            int person = new Random().nextInt((int) persons.stream().count());
            campagne.attach(persons.get(person));
        }
    }
}
