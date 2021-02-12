package geocache.model;

public class Schat
{
	private String omschrijving;
	private Adres vindplaats;

	public String getOmschrijving()
	{
		return omschrijving;
	}

	public void setOmschrijving(final String omschrijving)
	{
		this.omschrijving = omschrijving;
	}

	public Adres getVindplaats()
	{
		return vindplaats;
	}

	public void setVindplaats(final Adres vindplaats)
	{
		this.vindplaats = vindplaats;
	}

	@Override
	public String toString()
	{
		return "Schat [Omschrijving=" + getOmschrijving() + ", Vindplaats=" + getVindplaats() + "]";
	}

}
