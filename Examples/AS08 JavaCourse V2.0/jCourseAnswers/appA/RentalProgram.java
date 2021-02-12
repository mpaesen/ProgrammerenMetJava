public class RentalProgram
{
    private static final char REQUEST_QUIT = 'Q';
    private static final char REQUEST_RENT = 'R';
    private static final char REQUEST_RETURN = 'A';
    private static final char REQUEST_DISPLAY = 'D';
    private RentalConnection ourDB = null;

    public RentalProgram()
    {
        String system = null;
        String library = "CARDB";
        String file = "CARDB";
        ourDB = new RentalConnection(system,library,file); // prompt or default everything
        if (ourDB.getLastError() == null)
          {
            System.out.println("Preparing...");
            ourDB.connect(null,null); // use *current for UserId and Password
          }
        if (ourDB.getLastError() == null)
          {
            System.out.println("Preparing...");
            ourDB.prepare(); // prepare SQL
          }
        if (ourDB.getLastError() == null)
          {
            System.out.println("Running...");
            runApp();
          }
    }

    public void runApp()
    {
        Console console = new Console();
        String plateString;
        Car     currCar = null;
        char cmdChar = ' ';

        while (cmdChar != REQUEST_QUIT)
        {
           cmdChar = console.readChar("What do you want to do? ('R': rent a car, 'A': return a rented car, 'D': display rented cars, 'Q': quit)");
           cmdChar = Character.toUpperCase(cmdChar);
           switch(cmdChar)
           {
              case REQUEST_RENT:
                  char charAnswer = ' ';
                  String classString=null;
                  while (charAnswer == ' ')
                  {
                    charAnswer = console.readChar(" Rent: What class ('E'conomy, 'M'idsize or 'L'uxury)?");
                    if ((charAnswer == 'E')||(charAnswer == 'e'))
                      classString = "Economy";
                    else if ((charAnswer == 'M') || (charAnswer == 'm'))
                      classString = "Midsize";
                    else if ((charAnswer == 'L') || (charAnswer == 'l'))
                      classString = "Luxury";
                    else
                      charAnswer = ' ';
                  }
                  String colorString = null;
                  charAnswer = console.readChar(" Rent: Color Preference (Y/N)? ");
                  if ((charAnswer == 'Y') || (charAnswer == 'y'))
                    colorString = console.readLine(" Rent: specify color: ");
                  String makeString = null;
                  charAnswer = console.readChar(" Rent: Make Preference (Y/N)? ");
                  if ((charAnswer == 'Y') || (charAnswer == 'y'))
                    makeString = console.readLine(" Rent: specify make (eg GM,Ford,Chrysler,Nissan,etc): ");
                  currCar = Car.rentACar(ourDB,classString,colorString,makeString);
                  if (currCar != null)
                    {
                      System.out.println(" Rent: A car has been rented for you...");
                      System.out.println("   " + currCar.getDisplayInfo(true));
                      System.out.println();
                    }
                  else
                    {
                      System.out.println(" Rent: No car is available for you at this time");
                    }
                  break;
              case REQUEST_RETURN:
                  plateString = console.readLine(" Return: What is the plate number?");
                  currCar = Car.createCar(ourDB,plateString);
                  if (currCar == null)
                    System.out.println(" Return: error, plate number not found or rented!");
                  else
                    {
                      DateDelta elapsed = currCar.returnIt();
                      if (elapsed != null)
                         System.out.println(" Car returned successfully.");
                    }
                  break;
              case REQUEST_DISPLAY:
                  Car.displayRentedCars(ourDB);
                  break;
              case REQUEST_QUIT:
                  System.out.println();
                  System.out.println("User requested end.");
                  System.out.println();
                  break;
              default:
                  System.out.println("Unknown request. Try again.");
                  break;
           } // end switch
           System.out.println();
        } // end while loop
        System.out.println("Bye");
    } // end run

    public static void main(String args[])
    {
        RentalProgram rp = new RentalProgram();
        System.exit(0);
    }

} // end class RentalProgram
