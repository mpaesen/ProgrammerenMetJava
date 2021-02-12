package patterns;

import utilities.Currency;
import utilities.Language;

public class BritishNationality extends Nationality
{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "British " + super.toString();
	}

	public BritishNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
