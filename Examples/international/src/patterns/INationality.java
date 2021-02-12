package patterns;

import utilities.Currency;
import utilities.Language;

public interface INationality
{
	Currency getCurrency();

	Language getLanguage();

	void setCurrency(Currency currency);

	void setLanguage(Language language);

	String getMessage(String name);
}
