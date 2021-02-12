package patterns;

import utilities.Currency;
import utilities.Language;

public class AmericanNationality extends Nationality
{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "American " + super.toString();
	}

	public AmericanNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
