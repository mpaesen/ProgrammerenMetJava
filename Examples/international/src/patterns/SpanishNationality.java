package patterns;

import utilities.Currency;
import utilities.Language;

public class SpanishNationality extends Nationality
{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Spanish " + super.toString();
	}

	public SpanishNationality(final Currency currency, final Language language)
	{
		super(currency, language);
	}

}
