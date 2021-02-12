package geocache.model;

public class Adres
{
	private String gemeente;
	private String straat;
	private int nummer;

	public String getGemeente()
	{
		return gemeente;
	}

	public void setGemeente(final String gemeente)
	{
		this.gemeente = gemeente;
	}

	public String getStraat()
	{
		return straat;
	}

	public void setStraat(final String straat)
	{
		this.straat = straat;
	}

	public int getNummer()
	{
		return nummer;
	}

	public void setNummer(final int nummer)
	{
		this.nummer = nummer;
	}

	@Override
	public String toString()
	{
		return "Adres [Gemeente=" + getGemeente() + ", Straat=" + getStraat() + ", Nummer=" + getNummer() + "]";
	}

}
