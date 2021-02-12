package behavioral.strategy.duck;

/**
 * Write a description of class FlyWithWings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I fly");
    }
}
