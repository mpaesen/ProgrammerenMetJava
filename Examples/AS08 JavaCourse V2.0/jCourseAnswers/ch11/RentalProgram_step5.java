import java.io.*;
import java.util.StringTokenizer;

public class RentalProgram implements Runnable
{
    private static final char REQUEST_QUIT = 'Q';
    private static final char REQUEST_RENT = 'R';
    private static final char REQUEST_RETURN = 'A';
    private static final char REQUEST_DISPLAY = 'D';
    private static final String CAR_FILE = "cars.dat";
    private CarLot carlot;
    private Thread thread;

    public void setThreadReference(Thread thread)
    {
        this.thread = thread;
    }

    public void run()
    {
        populateLotFromFile(CAR_FILE);
    }

    public boolean populateLotFromFile(String file)
    {
        System.out.println("Loading...");
        File inFile = new File(file);
        BufferedReader inFileStream = null;
        try
        {
           inFileStream = new BufferedReader(new InputStreamReader (new FileInputStream(inFile) ) );
        }
        catch (Exception exc)
        {
           System.out.println("error opening file " + file + ": " + exc.getMessage());
           return false;
        }
        carlot = new CarLot(1000); // initial guess at capacity
        String newLine = null;
        boolean done = false;
        Car nextcar = null;
        StringTokenizer tokens = null;
        String plate, classification, make, color;
        while (!done)
        {
           try
           {
             newLine = inFileStream.readLine();
           }
           catch (IOException exc)
           {
              newLine = null;
           }
           if (newLine != null)
             {
              tokens = new StringTokenizer(newLine);
              // word1: plate number
              // word2: classification
              // word3: make
              // word4: color
              plate = tokens.nextToken();
              classification = tokens.nextToken();
              make = tokens.nextToken();
              color = tokens.nextToken();
              carlot.addCarToLot(plate, classification, make, color);
              // this runs too fast still!! Slow it down for the
              // exercise...
              try {
                Thread.sleep(5);
              } catch (InterruptedException exc) {}
             }
           else
             done = true;
        } // end while-loop
        try {
          inFileStream.close();
        } catch (IOException exc) {}
        System.out.println("Database loaded");
        return true;
    } // end populateLotFromFile

    public RentalProgram()
    {
    }

    public void runApp()
    {
        Console console = new Console();
        String plateString;
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
                  plateString = carlot.rentACar(classString,colorString,makeString);
                  if (plateString != null)
                    {
                      System.out.println(" Rent: A car has been rented for you...");
                      System.out.println();
                      carlot.displayCarInfo(plateString);
                    }
                  else
                    {
                      System.out.println(" Rent: No car is available for you at this time");
                    }
                  break;
              case REQUEST_RETURN:
                  plateString = console.readLine(" Return: What is the plate number?");
                  if (!carlot.returnACar(plateString))
                    System.out.println(" Return: error, plate number not found or rented!");
                  else
                    System.out.println(" Car returned successfully.");
                  break;
              case REQUEST_DISPLAY:
                  carlot.displayRentedCars();
                  break;
              case REQUEST_QUIT:
                  if (thread.isAlive())
                    thread.stop();
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
        //rp.populateLotFromFile(CAR_FILE);
        Thread thread = new Thread(rp);
        thread.start();
        rp.setThreadReference(thread);
        rp.runApp();
        System.exit(0);
    }

} // end class RentalProgram
