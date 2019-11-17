/**
 * Write a description of class Bericht here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bericht
{
	private final Locatie locatie;
	private final double koers;

	public Bericht(final Locatie locatie, final double koers)
	{
		this.locatie = locatie;
		this.koers = koers;
	}

	public double getKoers()
	{
		return koers;
	}

	public Locatie getLocatie()
	{
		return locatie;
	}

	public void sendSOS()
	{
		System.out.printf("%s", "\nHelp we zinken!");
	}

	@Override
	public String toString()
	{
		return "Bericht [locatie=" + locatie + ", koers=" + koers + "]";
	}

}
