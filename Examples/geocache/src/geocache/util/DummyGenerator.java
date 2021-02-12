package geocache.util;

import geocache.model.Adres;
import geocache.model.GeoCaching;
import geocache.model.Schat;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;


public class DummyGenerator
{
	private final static String[] GEMEENTE = { "Oudsbergen", "Leuven", "Genk", "Kessel-lo", "Overhespen", "Kasterlee", "Zwijnaarde", "Brussel", "Diepenbeek" };
	private final static String[] STRAAT = { "Riekskensweg", "Dorpstraat", "Hoogstraat", "Achter\'t heukske", "Tessenstraat", "Bondgenotenlaan", "Diestsestraat", "Meeuwenlaan", "Weg op bocholt", "Brusselsesteenweg", "Mechelsesteenweg", "Gemeentestraat", "Weg op bree", "Weg naar genk",
			"Peerderstraat", "Diestesteenweg" };

	private final static String SCHAT_OMSCHRIJVING[] = { "GSM", "ring", "horloge", "armband", "100 euro", "fietsslot", "iPhone" };
	private final static String OMGEVING[] = { "landelijk", "stedelijk", "bergen", "duinen", "bos" };

	private final static Random random = new Random();

	public static Adres generateAdres()
	{
		final Adres adres = new Adres();
		adres.setGemeente(GEMEENTE[random.nextInt(GEMEENTE.length)]);
		adres.setNummer(1 + random.nextInt(1000));
		adres.setStraat(STRAAT[random.nextInt(STRAAT.length)]);
		return adres;
	}

	public static Schat generateSchat()
	{
		final Schat schat = new Schat();
		schat.setOmschrijving(SCHAT_OMSCHRIJVING[random.nextInt(SCHAT_OMSCHRIJVING.length)]);
		schat.setVindplaats(generateAdres());
		return schat;
	}

	/**
	 * @return correcte datum tussen 2014 - 2017
	 */
	public static Datum generateDatum()
	{
		final Datum datum = new Datum();
		datum.setJaar(new GregorianCalendar().get(Calendar.YEAR)  + random.nextInt(3));
		datum.setMaand(1 + random.nextInt(11));
		int dag = 1 + random.nextInt(30); //max 31
		switch (datum.getMaand())
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		{
			dag = dag % 31;
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11:
		{
			dag = dag % 30;
			break;
		}
		default:
		{
			final int leap = (((datum.getJaar() % 4 == 0) && !(datum.getJaar() % 100 == 0)) || (datum.getJaar() % 400 == 0)) ? 29 : 28; //schrikkeljaar of niet
			dag %= leap;
		}
		}

		datum.setDag(dag);
		return datum;
	}

	public static String generateOmgeving()
	{
		return OMGEVING[random.nextInt(OMGEVING.length)];
	}

	public static GeoCaching generateGeoCaching()
	{
		final GeoCaching zoektocht = new GeoCaching();
		zoektocht.setDatum(generateDatum());
		zoektocht.setOmgeving(generateOmgeving());
		zoektocht.setSchat(generateSchat());
		zoektocht.setStart(generateAdres());
		zoektocht.setBenodigdeTijd(generateTijd());
		zoektocht.setScore(generateScore());
		return zoektocht;
	}

	public static int generateTijd()
	{
		//min 1 uur, max 8 uren
		return 60 + random.nextInt(480);
	}

	public static int generateScore()
	{
		//min 0, max 10
		return random.nextInt(11);
	}
}
