/**
 * Write a description of class Mobile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobile implements BasisFuncties
{
	public double getSnelheid()
	{
		return 15.0 + 15.0 * random.nextDouble();
	}

	public double getReactieTijd()
	{
		return 10.0 * random.nextDouble();
	}

	public double getWendbaarheid(final double graden)
	{
		return 5.0 * random.nextDouble();
	}

	public double getGrootte()
	{
		return 100.0 * random.nextDouble();
	}

	public int getCapaciteit()
	{
		return (int) (50.0 * random.nextDouble());
	}

	public double getKoers()
	{
		return 20.0 * random.nextDouble();
	}

	@Override
	public String toString()
	{
		return String.format("[%s %.2fknopen, %s %.2f', %s %.2fm2, %s %d personen, %s %.2f]", "Snelheid=", getSnelheid(), " ReactieTijd=", getReactieTijd(), " Grootte=", getGrootte(), " Capaciteit=", getCapaciteit(), " Koers=", getKoers());
	}
}
