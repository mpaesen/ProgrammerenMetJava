package business;

public class Employee
{
	private int uniqueNumber;
	private String name;
	private String firstName;
	private static int sequence = 0;

	@Override
	public String toString()
	{
		return "Employee [getUniqueNumber()=" + getUniqueNumber() + ", getName()=" + getName() + ", getFirstName()=" + getFirstName() + "]";
	}

	public static int getSequence()
	{
		return sequence;
	}

	public Employee(final String name, final String firstName)
	{
		super();
		uniqueNumber = ++sequence;
		this.name = name;
		this.firstName = firstName;
	}

	public int getUniqueNumber()
	{
		return uniqueNumber;
	}

	public void setUniqueNumber(final int uniqueNumber)
	{
		this.uniqueNumber = uniqueNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

}
