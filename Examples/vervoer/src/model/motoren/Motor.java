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
	 * Change the motor Type
	 * 
	 * @param  motor type

	 */
	public void setType(final String type)
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
	@Override
	public String toString()
	{
		return getType();
	}
}
