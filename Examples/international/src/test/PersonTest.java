package test;

import model.Amount;
import model.AmountAdaptor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import patterns.BritishNationality;
import patterns.IAmountAdapter;
import patterns.INationality;
import utilities.Currency;
import utilities.Language;

public class PersonTest
{
	private IAmountAdapter amount;
	private INationality nationality;

	@Before
	public void setUp() throws Exception
	{
		//test data for British nationality
		amount = new AmountAdaptor(new Amount(10000.0));
		nationality = new BritishNationality(Currency.GBP, Language.ENGLISH);

	}

	@Test
	public void testGetAmountInGPB()
	{
		Assert.assertTrue(amount.convertFromEuroToCurrency(nationality.getCurrency()) == amount.getAmount(nationality.getCurrency()).getAmount());
	}

	@Test
	public void testGetBritishNationality()
	{
		Assert.assertTrue(nationality.getCurrency().equals(Currency.GBP));
	}

	@Test
	public void testGetBritishLanguage()
	{
		Assert.assertTrue(nationality.getLanguage().equals(Language.ENGLISH));
	}

	@Test
	public void testCurrencyChange()
	{
		nationality.setCurrency(Currency.SEK);
		Assert.assertTrue(amount.convertFromEuroToCurrency(nationality.getCurrency()) == amount.getAmount(nationality.getCurrency()).getAmount());

	}

	@Test
	public void testLanguageChange()
	{
		nationality.setLanguage(Language.DUTCH);
		Assert.assertFalse(nationality.getLanguage().equals(Language.ENGLISH));
	}

	@Test
	public void testAmountChange()
	{
		amount.setAmount(new Amount(20000));
		Assert.assertTrue(amount.convertFromEuroToCurrency(nationality.getCurrency()) == amount.getAmount(nationality.getCurrency()).getAmount());
	}
}
