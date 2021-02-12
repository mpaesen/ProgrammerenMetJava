package jSrc.ch9;

import java.util.GregorianCalendar;
import java.util.Vector;
/**
 *  Represents a car rental lot
 */
public class CarLot
{
    // private instance variables...
    private Vector carPlates;
    private Vector carStatus;
    private Vector carRentalStart;
    private Vector carRentalEnd;
    private int  maxCars;
    public  static final Character STATUS_RENTED   = new Character('R');
    public  static final Character STATUS_NOTRENTED= new Character('A');

    /**
     * Constructor
     */
    public CarLot(int maxCars)
    {
        this.maxCars = maxCars;
        carPlates = new Vector(maxCars);
        carStatus = new Vector(maxCars);
        carRentalStart = new Vector(maxCars);
        carRentalEnd = new Vector(maxCars);
    } // end of ctor for CarLot

    private int getAvailableRental()
    {
        return carStatus.indexOf(STATUS_NOTRENTED);
    } // end getAvailableRental

    public void addCarToLot(int plate)
    {
        carPlates.addElement(new Integer(plate));
        carStatus.addElement(STATUS_NOTRENTED);
        carRentalStart.addElement(null);
        carRentalEnd.addElement(null);
    }

    public int rentACar()
    {
        int nextrental = getAvailableRental();
        carStatus.setElementAt(STATUS_RENTED,nextrental);
        carRentalStart.setElementAt(new GregorianCalendar(),nextrental);
        Integer temp = (Integer)carPlates.elementAt(nextrental);
        return temp.intValue();
    }

    public boolean returnACar(int plate)
    {
        int plateidx = carPlates.indexOf(new Integer(plate));
        if (plateidx != -1)
          {
           carStatus.setElementAt(STATUS_NOTRENTED,plateidx);
           carRentalEnd.setElementAt(new GregorianCalendar(), plateidx);
           GregorianCalendar start = (GregorianCalendar)carRentalStart.elementAt(plateidx);
           GregorianCalendar end = (GregorianCalendar)carRentalEnd.elementAt(plateidx);
           DateDelta elapsed = new DateDelta(start, end);
           System.out.println(" Car rented for " + elapsed);
          }
        return (plateidx != -1);
    }

    public void displayRentedCars()
    {
        System.out.println("Rented cars: ");
        for (int idx=0; idx < carStatus.size(); idx++)
        {
           if (carStatus.elementAt(idx) == STATUS_RENTED)
             {
              System.out.println("  Car plate : " + carPlates.elementAt(idx));
              GregorianCalendar rentedDate = (GregorianCalendar)carRentalStart.elementAt(idx);
              DatFmt datfmt = new DatFmt();
              System.out.println("   Rented on: " + datfmt.format(rentedDate.getTime()));
             }
        }

    }
} // end of class CarLot
