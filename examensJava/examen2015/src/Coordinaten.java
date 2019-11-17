/**
 * Write a description of class Coordinaten here.
 * 
 * @author Mathy Paesen 
 * @version 10/01/2015
 */
public class Coordinaten
{
	// instance variables - replace the example below with your own
	private final double breedte;
	private final double lengte;

	/**
	 * Constructor for objects of class Coordinaten
	 */
	public Coordinaten(final double breedte, final double lengte)
	{
		// initialise instance variables
		this.lengte = lengte;
		this.breedte = breedte;
	}

	public double getBreedte()
	{
		// put your code here
		return breedte;
	}

	public double getLengte()
	{
		// put your code here
		return lengte;
	}

	@Override
	public String toString()
	{
		return String.format("(%s %.2f, %s %.2f)", "Breedte=", getBreedte(), " Lengte=", getLengte());
	}
}
