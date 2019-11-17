import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Genereer test data Schip in Nood
 * 
 * @author Mathy Paesen 
 * @version 10/01/2015
 */
public class GenerateTestData
{
	public static Random random = new Random();
	private static final int AANTAL = 20;
	private static final double RECHT = 90.0;

	public static void randomVerkeerstoren(final List<Actor> list, final List<Actor> hulpdiensten)
	{
		Verkeerstoren verkeerstoren;

		for (int i = 0; i < 1 + random.nextInt(AANTAL); i++)
		{
			verkeerstoren = (Verkeerstoren) ActorFactory.createActor(1, randomLocatie());
			// alle verkeerstorens kunnen alle hulpdiensten bereiken
			verkeerstoren.setHulpDiensten(hulpdiensten);
			list.add(verkeerstoren);
		}

	}

	public static void randomSchepen(final List<Actor> verkeerstorens, final List<Actor> list)
	{
		final ListIterator<Actor> iterator = verkeerstorens.listIterator();
		Verkeerstoren verkeerstoren;
		Schip schip;

		while (iterator.hasNext())
		{
			verkeerstoren = (Verkeerstoren) iterator.next();
			for (int i = 0; i < 1 + random.nextInt(AANTAL); i++)
			{
				schip = (Schip) ActorFactory.createActor(2, randomLocatie());
				schip.setVerkeerstoren(verkeerstoren);
				schip.setBestemming(randomLocatie());
				list.add(schip);
			}
		}
	}

	public static void randomHulpdiensten(final List<Actor> list)
	{
		Hulpdienst hulpDienst;

		for (int i = 0; i < 1 + random.nextInt(AANTAL); i++)
		{
			hulpDienst = (Hulpdienst) ActorFactory.createActor(3, randomLocatie());
			list.add(hulpDienst);
		}
	}

	private static Coordinaten randomCoordinaten()
	{
		return new Coordinaten(random.nextDouble() * RECHT, random.nextDouble() * RECHT);
	}

	private static Locatie randomLocatie()
	{
		Coordinaten coordinaten;
		final Locatie locatie = new Locatie();
		coordinaten = randomCoordinaten();
		locatie.setLocatie(coordinaten);
		return locatie;
	}
}
