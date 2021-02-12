package ch9;

import ch9.dates.DateDelta;

import java.util.Vector;

/** Represents a car rental lot */
public class CarLot {
    // private instance variables...
    private Vector cars;
    private int maxCars;
    
	/** Constructor */
    public CarLot(int maxCars) {
        this.maxCars = maxCars;
        cars = new Vector(maxCars);
    } // end of ctor for CarLot

    public int getMaxCars() {
		return maxCars;
	}

	public void setMaxCars(int maxCars) {
		this.maxCars = maxCars;
	}


    private Car getAvailableRental() {
        Car rentalCar = null;
        Car currCar = null;
        for (int i = 0; i < cars.size() - 1; i++) {
            currCar = (Car)cars.elementAt(i);
            if (!currCar.isRented()) {
                rentalCar = currCar;
                break;
            }
        }
        return rentalCar;
    } // end getAvailableRental

    private Car getMatchingPlate(int plate) {
        Car rentalCar = null;
        Car currCar = null;
        for (int i = 0; i < cars.size() - 1; i++) {
            currCar = (Car)cars.elementAt(i);
            if (currCar.getPlate() == plate) {
                rentalCar = currCar;
                break;
            }
        }
        return rentalCar;
    } // end getMatchingPlate

    public void addCarToLot(int plate) {
        cars.addElement(new Car(plate));
    }

    public int rentACar() {
        Car nextRental = getAvailableRental();
        if (nextRental != null) {
            nextRental.rent();
            return nextRental.getPlate();
        }
        return 0;
    }

    public boolean returnACar(int plate) {
        Car rentalCar = getMatchingPlate(plate);
        if ((rentalCar != null) && (rentalCar.isRented())) {
            DateDelta elapsed = rentalCar.returnIt();
            System.out.println(elapsed);
            return true;
        }
        return false;
    }

    public void displayRentedCars() {
        System.out.println("Rented cars: ");
        for (int idx = 0; idx < cars.size(); idx++) {
            Car currCar = (Car)cars.elementAt(idx);
            if (currCar.isRented())
                currCar.display();
        }
    }
} // end of class CarLot
