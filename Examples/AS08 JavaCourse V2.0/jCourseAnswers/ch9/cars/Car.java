package cars;

import dates.DatFmt;
import dates.DateDelta;

import java.util.GregorianCalendar;
/**
 *  Represents a car in a car rental lot
 */
class Car
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
    Car(int plate)
    {
        carPlate = plate;
        carStatus = STATUS_NOTRENTED;
        carRentalStart = null;
        carRentalEnd = null;
    } // end of ctor for CarLot

    protected void rent()
    {
        carStatus = STATUS_RENTED;
        carRentalStart = new GregorianCalendar();
    }

    protected DateDelta returnIt()
    {
        carStatus = STATUS_NOTRENTED;
        carRentalEnd = new GregorianCalendar();
        DateDelta elapsed = new DateDelta(carRentalStart, carRentalEnd);
        return elapsed;
    }

    protected void display()
    {
        System.out.println("  Car plate : " + carPlate);
        if (carStatus == STATUS_RENTED)
          {
            DatFmt datfmt = new DatFmt();
            System.out.println("   Rented on: " + datfmt.format(carRentalStart.getTime()));
          }
    }

    protected int getPlate()
    {
        return carPlate;
    }

    protected char getStatus()
    {
        return carStatus;
    }

    protected boolean isRented()
    {
        return carStatus==STATUS_RENTED;
    }
} // end of class CarLot
