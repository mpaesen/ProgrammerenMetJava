package business;

public class AccountFactory
{
	public enum Type {
		SAVING, BANK
	}

	public Account createAccount(final Type type)
	{
		switch (type)
		{
		case SAVING:
			return new SavingAccount(new Amount());
		case BANK:
			return new BankAccount(new Amount());
		default:
			return null;
		}
	}
}
