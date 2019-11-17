public abstract class MobileActor extends Actor implements Observer
{
	private double koers;
	private double snelheid;
	private int capaciteit;
	private double grootte;
	private Locatie bestemming;

	public MobileActor(final Locatie locatie)
	{
		super(locatie);
	}

	public void send(final Schip schipInNood)
	{
		this.setKoers(schipInNood.getFuncties().getKoers());
	}

	public double getKoers()
	{
		return koers;
	}

	public void setKoers(final double koers)
	{
		this.koers = koers;
	}

	public double getSnelheid()
	{
		return snelheid;
	}

	public void setSnelheid(final double snelheid)
	{
		this.snelheid = snelheid;
	}

	public int getCapaciteit()
	{
		return capaciteit;
	}

	public void setCapaciteit(final int capaciteit)
	{
		this.capaciteit = capaciteit;
	}

	public double getGrootte()
	{
		return grootte;
	}

	public void setGrootte(final double grootte)
	{
		this.grootte = grootte;
	}

	public Locatie getBestemming()
	{
		return bestemming;
	}

	public void setBestemming(final Locatie bestemming)
	{
		this.bestemming = bestemming;
	}

	public void update(final Schip schip)
	{
		//stuur locatie van schip in nood
		setBestemming(schip.getLocatie());
	}

	@Override
	public String toString()
	{
		final StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		//buffer.append(getName());
		buffer.append(getFuncties());
		buffer.append("\n\t[bestemming=" + getBestemming() + "]");
		return buffer.toString();
	}

}
