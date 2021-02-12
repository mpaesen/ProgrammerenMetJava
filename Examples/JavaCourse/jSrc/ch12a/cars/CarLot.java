package jSrc.ch12a.cars;

import jSrc.ch12a.dates.DateDelta;

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

    public DateDelta returnACar(String plate)
    {
        Car rentalCar = getMatchingPlate(plate);
        if ((rentalCar != null) && rentalCar.isRented())
          return rentalCar.returnIt();
        return null;
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

    public String displayCarInfo(String plate, boolean rentalInfo)
    {
        Car rentalCar = getMatchingPlate(plate);
        if (rentalCar != null)
          return rentalCar.getDisplayInfo(rentalInfo);
        else
          return null;
    }

    public String displayCarInfo(int pos, boolean rentalInfo)
    {
        Car rentalCar = (Car)cars.elementAt(pos);
        if (rentalCar != null)
          return rentalCar.getDisplayInfo(rentalInfo);
        else
          return null;
    }

    public int getRentedCarCount()
    {
        Car nextCar = null;
        int count = 0;
        for (int idx = 0; idx < cars.size(); idx++)
           {
              nextCar = (Car)cars.elementAt(idx);
              if (nextCar.isRented())
                count++;
           }
        return count;
    }

    public int nextRentedCar(int pos)
    {
        Car nextCar = null;
        boolean done = false;
        int newPos = -1;
        for (int pos2 = pos+1; !done && pos2 < cars.size(); pos2++)
           {
              nextCar = (Car)cars.elementAt(pos2);
              if (nextCar.isRented())
                {
                  done = true;
                  newPos = pos2;
                }
           }
        return newPos;
    }

} // end of class CarLot