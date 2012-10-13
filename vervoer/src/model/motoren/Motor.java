package model.motoren;
/**
 * Write a description of class Motor here.
 * 
 * @author (Mathy paesen) 
 * @version (21/09/2003)
 */
public class Motor
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Motor
     */
    public Motor()
    {
        // initialise instance variables
         switch((int)(Math.random()*2.0)){
            case 0: type = "diesel";break;
            case 1: type = "benzine";break;
            default: type = "H20";break;
        }
    }

    /**
     * Change the motor Type
     * 
     * @param  motor type

     */
    public void setType(String type)
    {
        // put your code here
        this.type = type;
    }
    
   /**
     * gives the motor type
     * 
     * @return     motor type
     */    
    public String getType()
    {
        // put your code here
        return type;
    }   
   /**
     * String value of a motor
     * 
     * @return     String value of this motor
     */        
    public String toString(){
        return getType();
    }    
}
