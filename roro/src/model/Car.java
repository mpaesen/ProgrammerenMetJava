package model;
/**
 * Class Car
 * 
 * @author Mathy 
 * @version januari 4, 2008
 */
public class Car extends Vehicle
{
	private static final int CAR_WEIGHT = 1000;
    /**
     * Constructor for objects of class Van
     */
    public Car()
    {
        setWeight(CAR_WEIGHT);
        setParking(CAR_PARKING);
        setNumber(++Vehicle.count);
        
    }

    public String toString(){
    	return "Car "+super.toString();
    }
}
