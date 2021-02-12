package geocache.util;

public class Datum implements Comparable<Datum>
{
	private int jaar;
	private int maand;
	private int dag;

	public Datum()
	{
		this(0, 0, 0);
	}

	public Datum(final int jaar, final int maand, final int dag)
	{
		this.jaar = jaar;
		this.maand = maand;
		this.dag = dag;
	}

	public int getJaar()
	{
		return jaar;
	}

	public void setJaar(final int jaar)
	{
		this.jaar = jaar;
	}

	public int getMaand()
	{
		return maand;
	}

	public void setMaand(final int maand)
	{
		this.maand = maand;
	}

	public int getDag()
	{
		return dag;
	}

	public void setDag(final int dag)
	{
		this.dag = dag;
	}

	/* 
	 * Vergelijkt 2 datums
	 * @return
	 * 	Indien gelijk: 0
	 * 	Indien jaar verschillend: -1, +1
	 * 	Indien maand verschillend in hetzelfde jaar: -2, +2
	 * 	Indien dag verschillend in dezelfde maand en jaar: -3, +3
	 */
	@Override
	public int compareTo(final Datum datum)
	{
		if (this.getJaar() < datum.getJaar())
		{
			return -1;
		}

		if (this.getJaar() > datum.getJaar())
		{
			return +1;
		}

		if (this.getMaand() < datum.getMaand())
		{
			return -2;
		}
		if (this.getMaand() > datum.getMaand())
		{
			return +2;
		}
		if (this.getDag() < datum.getDag())
		{
			return -3;
		}
		if (this.getDag() > datum.getDag())
		{
			return +3;
		}

		return 0;
	}

	public long getDatum()
	{
		long datum = jaar * 10000;
		datum += maand * 100;
		datum += dag;
		return datum;
	}

	@Override
	public String toString()
	{
		return String.format("%d", getDatum());
	}

}
