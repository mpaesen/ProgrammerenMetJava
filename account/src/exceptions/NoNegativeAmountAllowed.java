package exceptions;

public class NoNegativeAmountAllowed extends IllegalArgumentException
{

	public NoNegativeAmountAllowed(final String arg0)
	{
		super(arg0);
	}

	public NoNegativeAmountAllowed(final Throwable arg0)
	{
		super(arg0);
	}

	public NoNegativeAmountAllowed(final String arg0, final Throwable arg1)
	{
		super(arg0, arg1);
	}

}
