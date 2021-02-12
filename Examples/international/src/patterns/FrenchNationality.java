package patterns;

import utilities.Currency;
import utilities.Language;

public class FrenchNationality extends Nationality
{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "French " + super.toString();
	}

	public FrenchNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}
}
