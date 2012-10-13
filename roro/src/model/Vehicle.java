package model; 
/**
 * Vehicle interface.
 * 
 * @author Mathy 
 * @version januari 4, 2008
 */

public abstract class Vehicle
{
    private int weight;
    private int parking;
    public static int count=0;
    public static final int CAR = 0;
    public static final int VAN = 1;
    public static final int SCHIP = 2;
    public static final int CAR_PARKING = 1;
    public static final int VAN_PARKING = 2;
    private int number;
        
    public  int getWeight(){
        return weight;
    }
    
    public  int getParking(){
        return parking;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public void setParking(int parking){
        this.parking = parking;
    }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("it weights "+getWeight());
		buffer.append(" and uses "+getParking());
		buffer.append(" parking");
		return buffer.toString();
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
