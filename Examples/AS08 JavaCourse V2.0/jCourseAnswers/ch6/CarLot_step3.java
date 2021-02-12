/**
 *  Represents a car rental lot
 */
public class CarLot
{
    // private instance variables...
    private int  carPlates[];
    private char carStatus[];
    private int  maxCars;
    public  static final int  PLATES_NOTSET   = -999999;
    public  static final char STATUS_RENTED   = 'R';
    public  static final char STATUS_NOTRENTED= 'A';
    public  static final char STATUS_NOTSET   = ' ';

    /**
     * Constructor
     */
    public CarLot(int maxCars)
    {
        this.maxCars = maxCars;
        carPlates = new int[maxCars];
        carStatus = new char[maxCars];
        for (int idx=0; idx<maxCars; idx++)
        {
           carPlates[idx] = PLATES_NOTSET;
           carStatus[idx] = STATUS_NOTSET;
        }
    } // end of ctor for CarLot

    private int getAvailableSlot()
    {
        int retidx = -1;
        for (int idx = 0; idx < maxCars && retidx == -1; idx++)
        {
           if (carStatus[idx] == STATUS_NOTSET)
             retidx = idx;
        }
        return retidx;
    } // end getAvailableSlot

    private int getAvailableRental()
    {
        int retidx = -1;
        for (int idx = 0; idx < maxCars && retidx == -1; idx++)
        {
           if (carStatus[idx] == STATUS_NOTRENTED)
             retidx = idx;
        }
        return retidx;
    } // end getAvailableRental

    public void addCarToLot(int plate)
    {
        int nextslot = getAvailableSlot();
        carPlates[nextslot] = plate;
        carStatus[nextslot] = STATUS_NOTRENTED;
    }

    public int rentACar()
    {
        int nextrental = getAvailableRental();
        carStatus[nextrental] = STATUS_RENTED;
        return carPlates[nextrental];
    }

    public boolean returnACar(int plate)
    {
        int plateidx = -1;
        for (int idx=0; idx<maxCars && plateidx==-1; idx++)
        {
           if (carPlates[idx] == plate)
             plateidx = idx;
        }
        if (plateidx != -1)
          carStatus[plateidx] = STATUS_NOTRENTED;
        return (plateidx != -1);
    }

    public void displayRentedCars()
    {
        System.out.println("Rented cars: ");
        for (int idx=0; idx<maxCars; idx++)
        {
           if (carStatus[idx] == STATUS_RENTED)
             System.out.println("  Car plate: " + carPlates[idx]);
        }

    }
} // end of class CarLot