package behavioral.strategy.duck;

/**
 * Write a description of class FlyNoWay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlyNoWay implements FlyBehavior {

    /**
     * Constructor for objects of class FlyNoWay
     */
    public FlyNoWay() {

    }

    public void fly() {
        System.out.println("Ik kan niet vliegen");
    }
}
