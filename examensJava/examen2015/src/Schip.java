/**
 * Write a description of class Schip here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Schip extends MobileActor
{
	private Verkeerstoren verkeerstoren;
	private Bericht laatsteBericht;

	/**
	 * Constructor for objects of class Schip
	 */
	public Schip(final Locatie locatie)
	{
		super(locatie);
		setName("Schip");
	}

	public void stuurBericht()
	{
		//meld locatie en koers aan verkeerstoren om de 10'
		setLaatsteBericht();
		verkeerstoren.updateLocatie(this);
		System.out.printf("%s", "\nBericht verzonden");
	}

	public Verkeerstoren getVerkeerstoren()
	{
		return verkeerstoren;
	}

	public void setVerkeerstoren(final Verkeerstoren verkeerstoren)
	{
		this.verkeerstoren = verkeerstoren;
		verkeerstoren.registerObserver(this);
	}

	private void setLaatsteBericht()
	{
		laatsteBericht = new Bericht(this.getLocatie(), this.getFuncties().getKoers());

	}

	public void help()
	{
		setLaatsteBericht();
		laatsteBericht.sendSOS();
	}

	public boolean isGeschikt(final Schip schipInNood)
	{
		//test of schip voldoet om hulp te bieden
		//op basis van capaciteit, afstand, grootte en reactietijd
		if (this.getFuncties().getCapaciteit() >= schipInNood.getFuncties().getCapaciteit())
		{
			return true;
		}
		return false;
	}

	public boolean equals(final Schip schip)
	{
		if (this.getLocatie().equals(schip.getLocatie()))
		{
			return true;
		}
		return false;
	}

}