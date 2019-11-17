import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Test basis functionaliteiten Schip in Nood
 * 
 * @author Mathy Paesen 
 * @version 10/01/2015
 */
public class Rescue
{
	private static List<Actor> verkeerstorens;
	private static List<Actor> hulpdiensten;
	private static List<Actor> schepen;

	public static void main(final String[] args)
	{
		hulpdiensten = new ArrayList<Actor>();
		verkeerstorens = new ArrayList<Actor>();
		schepen = new ArrayList<Actor>();

		GenerateTestData.randomHulpdiensten(hulpdiensten);
		GenerateTestData.randomVerkeerstoren(verkeerstorens, hulpdiensten);
		GenerateTestData.randomSchepen(verkeerstorens, schepen);

		final Schip schipInNood = (Schip) schepen.get(GenerateTestData.random.nextInt(schepen.size()));
		schipInNood.stuurBericht();
		final Verkeerstoren controle = schipInNood.getVerkeerstoren();
		controle.notifyObservers(schipInNood);
		System.out.println("\nReddings Coördinatie: ");
		System.out.println(controle);

		//alle verkeerstorens
		//System.out.println("\nVerkeerstorens: ");
		//printList(verkeerstorens);
		//alle hulpdiensten
		//System.out.println("Hulpdiensten: ");
		//printList(hulpdiensten);
		//alle schepen
		//System.out.println("Schepen: ");
		//printList(schepen);

	}

	public static void printList(final List<Actor> list)
	{
		final ListIterator<Actor> iterator = list.listIterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}