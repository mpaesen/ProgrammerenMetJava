package behavioral.strategy.duck;

/**
 * Write a description of class MallardDuck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MallardDuck extends Duck {
    /**
     * Constructor for objects of class MallardDuck
     */
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public String toString() {
        return "MallardDuck{}";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public void display() {
        System.out.println("Ik ben een echte wilde eend");
    }
}
