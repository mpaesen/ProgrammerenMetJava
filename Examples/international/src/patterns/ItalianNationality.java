package patterns;

import utilities.Currency;
import utilities.Language;

public class ItalianNationality extends Nationality
{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Italian " + super.toString();
	}

	public ItalianNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
