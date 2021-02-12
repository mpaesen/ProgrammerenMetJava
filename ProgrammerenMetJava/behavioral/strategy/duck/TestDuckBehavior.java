package behavioral.strategy.duck;

import java.util.Random;

public class TestDuckBehavior {
    private final static Random random = new Random();

    public static void main(String[] args) {
        Duck[] ducks = new Duck[15];
        for (int i = 0; i < ducks.length; i++) {
            ducks[i] = createDuck(1 + random.nextInt(2));
            ducks[i].setFlyBehavior(createFlyBehavior(1 + random.nextInt(3)));
            ducks[i].setQuackBehavior(createQuackBehavior(1 + random.nextInt(3)));
        }

        for (Duck duck : ducks) {
            //details of a Duck
            System.out.println(duck);
            duck.performFly();
            duck.performQuack();
            duck.swim();
            System.out.println();
        }
    }

    private static Duck createDuck(int duck) {
        switch (duck) {
            case 1:
                return new ModelDuck();
            case 2:
                return new MallardDuck();
        }
        return null;
    }

    private static FlyBehavior createFlyBehavior(int fly) {
        switch (fly) {
            case 1:
                return new FlyNoWay();
            case 2:
                return new FlyRocketPowered();
            case 3:
                return new FlyWithWings();
        }
        return null;
    }

    private static QuackBehavior createQuackBehavior(int quack) {
        switch (quack) {
            case 1:
                return new Quack();
            case 2:
                return new Squeak();
            case 3:
                return new MuteQuack();
        }
        return null;
    }
}
