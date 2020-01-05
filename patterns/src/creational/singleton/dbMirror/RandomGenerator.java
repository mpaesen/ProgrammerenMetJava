package creational.singleton.dbMirror;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
    private static final String[] NAMES = {"Peeters", "Jansen", "Vanoosterhout", "Goethals", "Boesman", "Dirkx", "Paesen", "Maes", "Raskin", "Vanwezenbeek"};
    private static final String[] FIRST_NAMES = {"Roy", "Katrien", "Erik", "Wauter", "Wim", "Johan", "Chris", "Liv", "Martine", "Caroline", "Tony", "Luc"};
    public static ArrayList<Person> list;
    private static Random rand = new Random();

    private static String getName() {
        return NAMES[rand.nextInt(NAMES.length)];
    }

    private static String getFirstName() {
        return FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
    }

    public static ArrayList<Person> getList(int max) {
        if (list == null) {
            list = new ArrayList<>();

            Person person;
            for (int i = 0; i < max; i++) {
                person = getPerson();
                list.add(person);
            }
        }
        return list;
    }

    public static Person getPerson() {
        return new Person(getName(), getFirstName());
    }
}
