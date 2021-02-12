package behavioral.strategy.duck;

/**
 * Write a description of class Quack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quack implements QuackBehavior {

    public Quack() {
    }

    public void quack() {
        System.out.println("Kwaak");
    }
}
