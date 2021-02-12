package test;

import model.Amount;
import model.AmountAdaptor;
import model.Person;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import patterns.*;
import utilities.Currency;
import utilities.Language;

public class TestPerson
{
	public static Logger logger = Logger.getLogger("Log");

	public static void main(final String[] args)
	{
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");
		// Set log4j level to log
		// Implemented levels: INFO, DEBUG, ERROR, ALL

		// logger.setLevel(Level.INFO);
		// logger.setLevel(Level.DEBUG);
		logger.setLevel(Level.ERROR);
		// logger.setLevel(Level.ALL);

		final IAmountAdapter amount = new AmountAdaptor(new Amount(10000.0));
		final INationality nationality = new FrenchNationality(Currency.EUR, Language.FRENCH);
		final Person person = new Person("John", amount, nationality);
		person.speak();

		person.setNationality(new AmericanNationality(Currency.USD, Language.ENGLISH));
		person.speak();

		person.setNationality(new BelgianNationality(Currency.EUR, Language.DUTCH));
		person.speak();

		person.setNationality(new BelgianNationality(Currency.EUR, Language.GERMAN));
		person.speak();

		person.setNationality(new SwissNationality(Currency.CHF, Language.GERMAN));
		person.speak();

		person.setNationality(new SwedishNationality(Currency.SEK, Language.SWEDISH));
		person.speak();

		person.setNationality(new SpanishNationality(Currency.EUR, Language.SPANISH));
		person.speak();

		person.setNationality(new ItalianNationality(Currency.EUR, Language.ITALIAN));
		person.speak();

		person.setNationality(new BritishNationality(Currency.GBP, Language.ENGLISH));
		person.speak();

		person.setNationality(new SwissNationality(Currency.CHF, Language.ITALIAN));
		person.speak();

	}

}
