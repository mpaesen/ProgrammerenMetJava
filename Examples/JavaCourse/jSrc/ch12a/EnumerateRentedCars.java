package jSrc.ch12a;

import jSrc.ch12a.cars.CarLot;

import java.util.Enumeration;

public class EnumerateRentedCars implements Enumeration
{
    CarLot carlot;
    int    pos = -1;
    int    currCount = 0;
    int    totalCount = 0;

    public EnumerateRentedCars(CarLot carlot)
    {
        this.carlot = carlot;
        pos = -1;
        totalCount = carlot.getRentedCarCount();
    }

    public boolean hasMoreElements()
    {
        return (currCount < totalCount);
    }

    public Object nextElement()
    {
        currCount++;
        pos = carlot.nextRentedCar(pos);
        System.out.println("new pos = " + pos);
        return carlot.displayCarInfo(pos,true);
    }
} // end EnumerateRentedCars class
