package geocache.persist;

import geocache.model.GeoCaching;
import geocache.util.Datum;
import geocache.util.DummyGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ZoekTochten
{
	private final ArrayList<GeoCaching> list = new ArrayList<GeoCaching>();

	public int aantalTochtenTussen(final Datum van, final Datum tot)
	{
		int aantal = 0;
		final Iterator<GeoCaching> it = list.iterator();
		GeoCaching current;
		while (it.hasNext())
		{
			current = it.next();
			if ((current.getDatum().compareTo(van) > 0) && (current.getDatum().compareTo(tot) < 0))
			{
				aantal++;
			}
		}
		return aantal;

	}

	public double gemiddeldeScoreOmgeving(final String omgeving)
	{
		int totaal = 0;
		int aantal = 0;
		final Iterator<GeoCaching> it = list.iterator();
		GeoCaching current;
		while (it.hasNext())
		{
			current = it.next();
			if ((it.next()).getOmgeving().equalsIgnoreCase(omgeving))
			{
				try
				{
					totaal += current.getScore();
					aantal++;
				}
				catch (final NoSuchElementException e)
				{
					System.err.println(current);
				}
			}
		}
		return totaal / ((aantal > 0) ? aantal : 1.0); //niet delen door 0

	}

	public int totaleTijdTochtenInMinuten()
	{
		int totaal = 0;
		final Iterator<GeoCaching> it = list.iterator();
		while (it.hasNext())
		{
			totaal += (it.next()).getBenodigdeTijd();

		}
		return totaal;
	}

	public int totaleTijdTochtenInUren()
	{
		return totaleTijdTochtenInMinuten() / 60;
	}

	public int aantalTochtenInOmgving(final String omgeving)
	{
		int aantal = 0;
		final Iterator<GeoCaching> it = list.iterator();
		while (it.hasNext())
		{
			if ((it.next()).getOmgeving().equalsIgnoreCase(omgeving))
			{
				aantal++;
			}
		}
		return aantal;
	}

	public int aantalTochtenMetMinimumScore(final int score)
	{
		int aantal = 0;
		final Iterator<GeoCaching> it = list.iterator();
		while (it.hasNext())
		{
			if ((it.next()).getScore() == score)
			{
				aantal++;
			}
		}
		return aantal;
	}

	public void lijstZoektochten(final int aantalZoektochten)
	{
		for (int i = 0; i < aantalZoektochten; i++)
		{
			list.add(DummyGenerator.generateGeoCaching());
		}
	}

	public void printGeocaching()
	{
		for (final GeoCaching tocht : list)
		{
			System.out.printf("\n%s", tocht);
		}
	}

}
