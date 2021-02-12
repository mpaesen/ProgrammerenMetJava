public class AnimalGame
{

    public static void main(String args[])
    {
        Animals animals = new Animals();
        int nbrLegs = 0;
        while (nbrLegs != -9999)
        {
           System.out.println("How many legs do you have?");
           nbrLegs = ReadIntegers.readNextInteger();
           switch(nbrLegs)
           {
             case 4:
                 System.out.println("You are a " + animals.getRandomFourLegAnimal());
                 break;
             case 2:
                 System.out.println("You are a " + animals.getRandomTwoLegAnimal());
                 break;
             case 1:
                 System.out.println("You are a " + animals.getRandomOneLegAnimal());
                 break;
             case -9999:
                 System.out.println("Bye, you animal");
                 break;
             default:
                 System.out.println("What kind of animal are you anyway!");
                 break;
           } // end switch
           System.out.println();
        } // end while loop
    } // end main method

} // end class AnimalGame