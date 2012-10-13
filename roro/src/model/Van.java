package model; 
/**
 * Van class.
 * 
 * @author Mathy 
 * @version januari 4, 2008
 */
public class Van extends Vehicle
{
	private static final int VAN_WEIGHT = 1500;
    public Van()
    {
        setWeight(VAN_WEIGHT);
        setParking(Vehicle.VAN_PARKING);
        setNumber(++Vehicle.count);
    }

    public String toString(){
    	return "Van "+super.toString()+"s";
    }
}
