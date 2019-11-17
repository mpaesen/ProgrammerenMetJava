import java.util.List;

/**
 * Abstract class Actor - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Actor
{
	// instance variables - replace the example below with your own
	private BasisFuncties functies;
	private List<Verkeerstoren> verkeerstorens;
	private final Locatie locatie;

	private String name;
	private final int number;
	public static int count;

	public Actor(final Locatie locatie)
	{
		this.locatie = locatie;
		number = ++count;
	}

	public void setFuncties(final BasisFuncties functies)
	{
		this.functies = functies;
	}

	public BasisFuncties getFuncties()
	{
		return functies;
	}

	public double getAfstand(final Actor actor)
	{
		return 1.0;
	}

	public Locatie getLocatie()
	{
		return locatie;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	@Override
	public String toString()
	{
		//return "Actor [functies=" + functies + ", verkeerstorens=" + verkeerstorens + ", locatie=" + locatie + "]";
		return String.format("%s %d op locatie: %s\n\t", getName(), getNumber(), getLocatie());
	}

}
