package patterns;

import utilities.Currency;
import utilities.Language;

public class SwissNationality extends Nationality
{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Swiss " + super.toString();
	}

	public SwissNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
