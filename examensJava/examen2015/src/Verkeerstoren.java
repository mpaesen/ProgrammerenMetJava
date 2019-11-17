import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Verkeerstoren here.
 * 
 * @author Mathy Paesen
 * @version 1.0
 */
public class Verkeerstoren extends Actor implements Subject
{
	private final List<Actor> schepenOnderKontrole;
	private List<Actor> hulpDiensten;

	public Verkeerstoren(final Locatie locatie)
	{
		super(locatie);
		setName("Verkeerstoren");
		schepenOnderKontrole = new ArrayList<Actor>();
		hulpDiensten = new ArrayList<Actor>();
	}

	public void registerObserver(final Schip schip)
	{
		schepenOnderKontrole.add(schip);
	}

	public void removeObserver(final Schip schip)
	{
		schepenOnderKontrole.remove(schip);
	}

	public void notifyObservers(final Schip schipInNood)
	{
		System.out.printf("%s", "\nSchip in nood, coördinaten :" + schipInNood.getLocatie());

		//alle hulpdiensten worden automatisch verwittigd
		for (final Actor hulpdienst : hulpDiensten)
		{

			((Hulpdienst) hulpdienst).send(schipInNood);
			((Hulpdienst) hulpdienst).update(schipInNood);
			System.out.printf("%s", "\n" + hulpdienst + "\n\tverwittigd over schip in nood!");

		}

		//enkel schepen die in aanmerking komen worden gestuurd
		for (final Actor schip : schepenOnderKontrole)
		{

			if (!schip.equals(schipInNood) && ((Schip) schip).isGeschikt(schipInNood))
			{
				((Schip) schip).send(schipInNood);
				((Schip) schip).update(schipInNood);
				System.out.printf("%s", "\n" + schip + "\n\tgestuurd naar schip in nood!");
			}
		}

	}

	public void updateLocatie(final Schip schip)
	{
		schepenOnderKontrole.set(schepenOnderKontrole.indexOf(schip), schip);
	}

	public List<Actor> getHulpDiensten()
	{
		return hulpDiensten;
	}

	public void setHulpDiensten(final List<Actor> hulpdiensten)
	{
		this.hulpDiensten = hulpdiensten;
	}

	@Override
	public String toString()
	{
		return getName() + " " + getNumber() + ": met schepen Onder Kontrole=" + schepenOnderKontrole + ", \n\tmet als hulpdiensten=" + hulpDiensten + "]";
	}
}
