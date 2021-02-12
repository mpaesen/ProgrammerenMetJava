package ch12;

import ch12.cars.CarLot;

import java.util.Enumeration;

public class EnumerateRentedCars implements Enumeration {
    CarLot carlot;
    int pos = -1;
    int currCount = 0;
    int totalCount = 0;

    public EnumerateRentedCars(CarLot carlot) {
        this.carlot = carlot;
        pos = -1;
        totalCount = carlot.getRentedCarCount();
    }

    public boolean hasMoreElements() {
        return (currCount < totalCount);
    }

    public Object nextElement() {
        currCount++;
        pos = carlot.nextRentedCar(pos);
        return carlot.displayCarInfo(pos, true);
    }
} // end EnumerateRentedCars class
