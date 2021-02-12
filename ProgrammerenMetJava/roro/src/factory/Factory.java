package factory;

import model.Vehicle;
import model.Car;
import model.Van;
import model.Schip;

/**
 * Write a description of class Factory here.
 * 
 * @author Mathy 
 * @version januari 3, 2008
 */
public class Factory
{
    /**
     * Generates a Vehicle
     * @return     the vehicle 
     */
    public static Vehicle getVehicle(int type)
    {
        switch (type){
            case Vehicle.CAR: return new Car();
            case Vehicle.VAN: return new Van();
        
            default: return null;
        }
    }
}
