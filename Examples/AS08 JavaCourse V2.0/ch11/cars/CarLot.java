package ch11.cars;

import ch11.dates.DateDelta;

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

    private Car getAvailableRental(String carClass, String color, String make)
    {
        Car currCar   = null;
        Car rentalCar = null;

        System.out.println(" Searching... car class request: '" + carClass + "'");
        if (color != null)
          System.out.println(" Searchng... car color request: '" + color + "'");
        if (make != null)
          System.out.println(" Searching... car make request: '" + make + "'");
        System.out.println();

        for (int idx = 0; idx < cars.size(); idx++)
           {
            currCar = (Car)cars.elementAt(idx);
            if (!currCar.isRented() &&
                ((carClass==null) || (carClass.equalsIgnoreCase(currCar.getClassification()))) &&
                ((color==null) || (color.equalsIgnoreCase(currCar.getColor()))) &&
                ((make==null) || (make.equalsIgnoreCase(currCar.getMake()))) )
              {
                rentalCar = currCar;
                break;
              }
           }
        return rentalCar;
    } // end getAvailableRental

    private Car getMatchingPlate(String plate)
    {
        Car currCar   = null;
        Car rentalCar = null;
        for (int idx = 0; idx<cars.size(); idx++)
           {
            currCar = (Car)cars.elementAt(idx);
            if (currCar.getPlate().equals(plate))
              {
                rentalCar = currCar;
                break;
              }
           }
        return rentalCar;
    } // end getMatchingPlate

    public void addCarToLot(String plate, String classification,
                            String make,  String color)
    {
        cars.addElement(new Car(plate,classification,make,color));
    }

    public String rentACar(String carClass, String color, String make)
    {
        Car nextrental = getAvailableRental(carClass, color, make);
        if (nextrental != null)
          {
            nextrental.rent();
            return nextrental.getPlate();
          }
        else
          return null;
    }

    public boolean returnACar(String plate)
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
             {
              currCar.display(true);
              System.out.println();
             }
        }

    }

    public boolean displayCarInfo(String plate)
    {
        Car rentalCar = getMatchingPlate(plate);
        if (rentalCar != null)
          {
            rentalCar.display(false);
            return true;
          }
        else
          return false;
    }
} // end of class CarLot
