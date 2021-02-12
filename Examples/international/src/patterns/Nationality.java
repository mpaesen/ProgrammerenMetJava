package patterns;

import utilities.Currency;
import utilities.Language;

public abstract class Nationality implements INationality
{

	private Currency currency;
	private Language language;

	@Override
	public Currency getCurrency()
	{
		return currency;
	}

	@Override
	public void setCurrency(final Currency currency)
	{
		this.currency = currency;
	}

	@Override
	public Language getLanguage()
	{
		return language;
	}

	@Override
	public void setLanguage(final Language language)
	{
		this.language = language;
	}

	public Nationality(final Currency currency, final Language language)
	{
		super();
		this.currency = currency;
		this.language = language;
	}

	@Override
	public String getMessage(final String name)
	{
		final StringBuffer buffer = new StringBuffer();
		getName(buffer);
		buffer.append(name);
		getCapital(buffer);
		return buffer.toString();
	}

	/**
	 * @param buffer
	 */
	private void getName(final StringBuffer buffer)
	{
		switch (getLanguage())
		{
		case DUTCH:
			buffer.append("Hallo, mijn naam is ");
			break;
		case ENGLISH:
			buffer.append("Hello my Name Is ");
			break;
		case FRENCH:
			buffer.append("Bonjour, je m'appelle ");
			break;
		case GERMAN:
			buffer.append("Hallo, mein Name ist ");
			break;
		case ITALIAN:
			buffer.append("Ciao, mi chiamo ");
			break;
		case SPANISH:
			buffer.append("Hola, el meu nom és ");
			break;
		default:
			buffer.append("Hello my Name Is ");
			break;
		}
	}

	/**
	* @param buffer
	*/
	private void getCapital(final StringBuffer buffer)
	{
		switch (getLanguage())
		{
		case DUTCH:
			buffer.append(", mijn kapitaal is: ");
			break;
		case ENGLISH:
			buffer.append(", my capital is: ");
			break;
		case FRENCH:
			buffer.append(", mon capital est ");
			break;
		case GERMAN:
			buffer.append(", mein Kapital ist ");
			break;
		case ITALIAN:
			buffer.append(", la mia capitale è");
			break;
		case SPANISH:
			buffer.append(", mi capital es ");
			break;
		default:
			buffer.append(", my capital is: ");
			break;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "[Currency=" + getCurrency() + ", Language=" + getLanguage() + "]";
	}

}
