package patterns;

import utilities.Currency;
import utilities.Language;

public class SwedishNationality extends Nationality
{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Swedish " + super.toString();
	}

	public SwedishNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
