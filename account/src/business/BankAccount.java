package business;

public class BankAccount extends Account
{

	public BankAccount(final Amount beginSaldo)
	{
		super(beginSaldo);
	}

	@Override
	public void addTransaction(final Amount amount)
	{
		super.getTransactions().add(amount);
	}

	@Override
	public String toString()
	{
		return "\n\tBankAccount [" + super.toString() + "]";
	}

}
