import java.util.Random;
/**
 *  A class for retrieving a random animal name,
 *  given the number of legs it has
 */
public class Animals
{
    // private instance variables...
    private static String[] fourLegs =
    {"horse","cow","sheep","ewe","yak","couple of ducks","goat","llama"};
    private static String[] twoLegs =
    {"human","duck","goose","rooster","chicken","kangaroo","flamingo"};
    private static String[] oneLeg =
    {"pogo stick","half duck","unicycle","bar stool"};
    private Random random;

    /**
     * default constructor
     */
    public Animals()
    {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    } // end of ctor for Animals

    // methods...

    /**
     * return a four legged animal
     */
    public String getRandomFourLegAnimal()
    {
        int index = Math.abs(random.nextInt());
        index = index % fourLegs.length;
        return fourLegs[index];
    }

    /**
     * return a two legged animal
     */
    public String getRandomTwoLegAnimal()
    {
        int index = Math.abs(random.nextInt());
        index = index % twoLegs.length;
        return twoLegs[index];
    }

    /**
     * return a one legged animal
     */
    public String getRandomOneLegAnimal()
    {
        int index = Math.abs(random.nextInt());
        index = index % oneLeg.length;
        return oneLeg[index];
    }

} // end of class Animals