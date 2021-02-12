package geocache.model;

import geocache.util.Datum;

public class GeoCaching
{
	private Adres start;
	private Datum datum;
	private String omgeving;
	private Schat schat;
	private final int tocht;

	private static int count;

	public GeoCaching()
	{
		this.tocht = ++count;
	}

	public Schat getSchat()
	{
		return schat;
	}

	public void setSchat(final Schat schat)
	{
		this.schat = schat;
	}

	private int score;
	private int benodigdeTijd;

	public Adres getStart()
	{
		return start;
	}

	public void setStart(final Adres start)
	{
		this.start = start;
	}

	public Datum getDatum()
	{
		return datum;
	}

	public void setDatum(final Datum datum)
	{
		this.datum = datum;
	}

	public String getOmgeving()
	{
		return omgeving;
	}

	public void setOmgeving(final String omgeving)
	{
		this.omgeving = omgeving;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(final int score)
	{
		this.score = score;
	}

	public int getBenodigdeTijd()
	{
		return benodigdeTijd;
	}

	public void setBenodigdeTijd(final int benodigdeTijd)
	{
		this.benodigdeTijd = benodigdeTijd;
	}

	@Override
	public String toString()
	{
		return "Zoektocht " + tocht + ": [Schat=" + getSchat() + ", \n\t Start=" + getStart() + ", \n\t Datum=" + getDatum() + ", \n\t Omgeving=" + getOmgeving() + ", Score=" + getScore() + ", Benodigde Tijd=" + getBenodigdeTijd() + "min]";
	}

}
