package creational.factory;

public class SalutationFactory {
    public static void main(String args[]) {
        SalutationFactory factory = new SalutationFactory();
        factory.getPerson(args[0], args[1]);
    }

    public Person getPerson(String name, String gender) {
        if (gender.equals("M"))
            return new Male(name);
        else if (gender.equals("F"))
            return new Female(name);
        else
            return null;
    }
}// End of class