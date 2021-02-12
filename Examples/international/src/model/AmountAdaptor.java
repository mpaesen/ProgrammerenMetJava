package model;

import patterns.CurrencyConverter;
import patterns.IAmountAdapter;
import test.TestPerson;
import utilities.Currency;

import java.io.File;
import java.io.IOException;

public class AmountAdaptor implements IAmountAdapter
{
	private Amount amount;

	public AmountAdaptor(final Amount amount)
	{
		super();
		this.amount = amount;
	}

	@Override
	public Amount getAmount(final Currency currency)

	{
		final Amount conversion = new Amount(this.amount.getAmount());
		conversion.setAmount(convertFromEuroToCurrency(currency));
		return conversion;
	}

	@Override
	public void setAmount(final Amount amount)
	{
		this.amount = amount;
	}

	@Override
	public double convertFromEuroToCurrency(final Currency currency)
	{
		try
		{
			if (currency.getIsoCode().equals("EUR"))
			{
				return amount.getAmount();
			}
			return amount.getAmount() * getAmount(currency.getIsoCode());
		}
		catch (final NumberFormatException | NullPointerException e)
		{
			TestPerson.logger.error("Exchange rate for " + currency + " not found!");
		}
		return 0.0;

	}

	@Override
	public double convertFromCurrencyToEuro(final Currency currency)
	{
		try
		{
			if (currency.getIsoCode().equals("EUR"))

			{
				return amount.getAmount();
			}
			return 1.0 / amount.getAmount() * getAmount(currency.getIsoCode());
		}
		catch (final NumberFormatException | NullPointerException e)
		{
			TestPerson.logger.error("Exchange rate for " + currency + " not found!");
		}

		return 0.0;

	}

	private double getAmount(final String currency)
	{
		try
		{
			setCurrencyConverter();
			return Double.valueOf(CurrencyConverter.getProperty(currency));
		}
		catch (NumberFormatException | IOException e)
		{
			TestPerson.logger.error("Exchange rate for " + currency + " not found!");

			//			e.printStackTrace();
		}

		return 0.0;
	}

	private void setCurrencyConverter()
	{
		try
		{

			CurrencyConverter.setProperties(new File("rates.properties"));

		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

	}
}
