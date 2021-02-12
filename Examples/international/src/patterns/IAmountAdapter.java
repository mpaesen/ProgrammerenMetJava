package patterns;

import model.Amount;
import utilities.Currency;

public interface IAmountAdapter
{
	double convertFromEuroToCurrency(Currency currency);

	double convertFromCurrencyToEuro(Currency currency);

	void setAmount(Amount amount);

	Amount getAmount(Currency currency);
}
