import java.util.Vector;
/**
 *  Represents a car rental lot
 */
public class CarLot
{
    // private instance variables...
    private Vector carPlates;
    private Vector carStatus;
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
    } // end of ctor for CarLot

    private int getAvailableRental()
    {
        return carStatus.indexOf(STATUS_NOTRENTED);
    } // end getAvailableRental

    public void addCarToLot(int plate)
    {
        carPlates.addElement(new Integer(plate));
        carStatus.addElement(STATUS_NOTRENTED);
    }

    public int rentACar()
    {
        int nextrental = getAvailableRental();
        carStatus.setElementAt(STATUS_RENTED,nextrental);
        Integer temp = (Integer)carPlates.elementAt(nextrental);
        return temp.intValue();
    }

    public boolean returnACar(int plate)
    {
        int plateidx = carPlates.indexOf(new Integer(plate));
        if (plateidx != -1)
          carStatus.setElementAt(STATUS_NOTRENTED,plateidx);
        return (plateidx != -1);
    }

    public void displayRentedCars()
    {
        System.out.println("Rented cars: ");
        for (int idx=0; idx < carStatus.size(); idx++)
        {
           if (carStatus.elementAt(idx) == STATUS_RENTED)
             System.out.println("  Car plate: " + carPlates.elementAt(idx));
        }

    }
} // end of class CarLot