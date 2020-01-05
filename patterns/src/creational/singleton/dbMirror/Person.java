package creational.singleton.dbMirror;

public class Person implements Comparable<Person> {
    private String name;
    private String firstName;

    public Person(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public int compareTo(Person person) {
        if (person.getName().equals(this.getName()))
            return 0;
        return (person.getName().compareToIgnoreCase(this.getName()));
    }
}
