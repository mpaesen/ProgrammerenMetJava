package patterns;

import utilities.Currency;
import utilities.Language;

public class BelgianNationality extends Nationality
{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Belgian " + super.toString();
	}

	public BelgianNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
