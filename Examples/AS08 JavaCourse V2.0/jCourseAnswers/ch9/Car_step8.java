import java.util.GregorianCalendar;
/**
 *  Represents a car in a car rental lot
 */
public class Car
{
    // private instance variables...
    private int  carPlate;
    private char carStatus;
    private GregorianCalendar carRentalStart;
    private GregorianCalendar carRentalEnd;
    public  static final char STATUS_RENTED   = 'R';
    public  static final char STATUS_NOTRENTED= 'A';

    /**
     * Constructor
     */
    public Car(int plate)
    {
        carPlate = plate;
        carStatus = STATUS_NOTRENTED;
        carRentalStart = null;
        carRentalEnd = null;
    } // end of ctor for CarLot

    public void rent()
    {
        carStatus = STATUS_RENTED;
        carRentalStart = new GregorianCalendar();
    }

    public DateDelta returnIt()
    {
        carStatus = STATUS_NOTRENTED;
        carRentalEnd = new GregorianCalendar();
        DateDelta elapsed = new DateDelta(carRentalStart, carRentalEnd);
        return elapsed;
    }

    public void display()
    {
        System.out.println("  Car plate : " + carPlate);
        if (carStatus == STATUS_RENTED)
          {
            DatFmt datfmt = new DatFmt();
            System.out.println("   Rented on: " + datfmt.format(carRentalStart.getTime()));
          }
    }

    public int getPlate()
    {
        return carPlate;
    }

    public char getStatus()
    {
        return carStatus;
    }

    public boolean isRented()
    {
        return carStatus==STATUS_RENTED;
    }
} // end of class CarLot
