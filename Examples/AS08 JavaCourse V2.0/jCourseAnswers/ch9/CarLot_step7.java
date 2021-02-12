import java.util.Vector;
/**
 *  Represents a car rental lot
 */
public class CarLot
{
    // private instance variables...
    private Vector cars;
    private int  maxCars;

    /**
     * Constructor
     */
    public CarLot(int maxCars)
    {
        this.maxCars = maxCars;
        cars = new Vector(maxCars);
    } // end of ctor for CarLot

    private Car getAvailableRental()
    {
        Car currCar   = null;
        Car rentalCar = null;
        for (int idx = 0; idx<cars.size(); idx++)
           {
            currCar = (Car)cars.elementAt(idx);
            if (!currCar.isRented())
              {
                rentalCar = currCar;
                break;
              }
           }
        return rentalCar;
    } // end getAvailableRental

    private Car getMatchingPlate(int plate)
    {
        Car currCar   = null;
        Car rentalCar = null;
        for (int idx = 0; idx<cars.size(); idx++)
           {
            currCar = (Car)cars.elementAt(idx);
            if (currCar.getPlate() == plate)
              {
                rentalCar = currCar;
                break;
              }
           }
        return rentalCar;
    } // end getMatchingPlate

    public void addCarToLot(int plate)
    {
        cars.addElement(new Car(plate));
    }

    public int rentACar()
    {
        Car nextRental = getAvailableRental();
        if (nextRental != null)
          {
            nextRental.rent();
            return nextRental.getPlate();
          }
        else
          return 0;
    }

    public boolean returnACar(int plate)
    {
        Car rentalCar = getMatchingPlate(plate);
        if ((rentalCar != null) && rentalCar.isRented())
          {
             DateDelta elapsed = rentalCar.returnIt();
             System.out.println(" Car rented for " + elapsed);
             return true;
          }
        return false;
    }

    public void displayRentedCars()
    {
        System.out.println("Rented cars: ");
        Car currCar = null;
        for (int idx=0; idx < cars.size(); idx++)
        {
           currCar = (Car)cars.elementAt(idx);
           if (currCar.isRented())
             currCar.display();
        }
    }
} // end of class CarLot
