package cars;

import dates.DatFmt;
import dates.DateDelta;

import java.util.GregorianCalendar;
/**
 *  Represents a car in a car rental lot
 */
public class Car
{
    // private instance variables...
    private String  carPlate;
    private char carStatus;
    private String carClass;
    private String carMake;
    private String carColor;
    private GregorianCalendar carRentalStart;
    private GregorianCalendar carRentalEnd;
    public  static final char STATUS_RENTED   = 'R';
    public  static final char STATUS_NOTRENTED= 'A';

    /**
     * Constructor
     */
    public Car(String plate, String classification, String make, String color)
    {
        carPlate = plate;
        carClass = classification;
        carMake  = make;
        carColor = color;
        carStatus = STATUS_NOTRENTED;
        carRentalStart = null;
        carRentalEnd = null;
    } // end of ctor for CarLot

    void rent()
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

    public void display(boolean displayRentalDate)
    {
        System.out.println("  Car plate : " + carPlate);
        System.out.println("  ------------------");
        System.out.println("      class : " + carClass);
        System.out.println("      make  : " + carMake);
        System.out.println("      color : " + carColor);
        System.out.println("      status: " + (carStatus==STATUS_NOTRENTED ? "Not rented" : "Rented"));
        if (displayRentalDate && (carStatus == STATUS_RENTED))
          {
            DatFmt datfmt = new DatFmt();
            System.out.println("          on: " + datfmt.format(carRentalStart.getTime()));
          }
    }

    public String getDisplayInfo(boolean displayRentedInfo)
    {
        String display = "Plate: " + carPlate;
        display += " class: " + carClass;
        display += " make: " + carMake;
        display += " color: " + carColor;
        if (displayRentedInfo && (carStatus == STATUS_RENTED))
          {
            DatFmt datfmt = new DatFmt();
            display += " Rented: " + datfmt.format(carRentalStart.getTime());
          }
        return display;
    }

    public String getPlate()
    {
        return carPlate;
    }

    public char getStatus()
    {
        return carStatus;
    }

    public String getClassification()
    {
        return carClass;
    }

    public String getMake()
    {
        return carMake;
    }

    public String getColor()
    {
        return carColor;
    }

    public boolean isRented()
    {
        return carStatus==STATUS_RENTED;
    }

    public String getRentalDate()
    {
        DatFmt datfmt = new DatFmt();
        String retDate = datfmt.format(carRentalStart.getTime());
        return retDate;
    }
} // end of class CarLot