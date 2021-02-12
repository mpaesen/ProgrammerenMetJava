package geocache.view;

import geocache.persist.ZoekTochten;
import geocache.util.Datum;
import geocache.util.DummyGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ZoekTochtDemo
{
	static final int AANTAL_ZOEKTOCHTEN = 50;
	static final String omgeving = DummyGenerator.generateOmgeving();
	static final Datum VAN = new Datum(new GregorianCalendar().get(Calendar.YEAR), 01, 01);
	static final Datum TOT = new Datum(2020, 12, 31);
	static final int SCORE = 3;

	public static void main(final String[] args)
	{

		final ZoekTochten mijnZoekTochten = new ZoekTochten();
		//maak lijst zoektochten
		mijnZoekTochten.lijstZoektochten(AANTAL_ZOEKTOCHTEN);
		System.out.println("Statistieken Geocaching:");

		//gemiddelde score voor omgeving x
		System.out.printf("\nGemiddelde score voor omgeving \"%s\" : %.2f ", omgeving, mijnZoekTochten.gemiddeldeScoreOmgeving(omgeving));

		//aantal zoektochten tussen x & y
		System.out.printf("\nAantal tochten tussen %d en %d : %d", VAN.getDatum(), TOT.getDatum(), mijnZoekTochten.aantalTochtenTussen(VAN, TOT));

		//totale tijd van alle zoektochten samen
		System.out.printf("\nTotale tijd van alle zoektochten (uren, minuten): %du, %dmin", mijnZoekTochten.totaleTijdTochtenInUren(), mijnZoekTochten.totaleTijdTochtenInMinuten() % mijnZoekTochten.totaleTijdTochtenInUren());

		//aantal tochten met minimumscore x
		System.out.printf("\nAantal tochten met minimum score %d: %d ", SCORE, mijnZoekTochten.aantalTochtenMetMinimumScore(SCORE));

		//aantal tochten in omgeving x
		System.out.printf("\nAantal tochten in de omgeving %s : %d ", omgeving, mijnZoekTochten.aantalTochtenInOmgving(omgeving));
		System.out.println();

		//druk alle zoektochten af
		mijnZoekTochten.printGeocaching();

	}

}
