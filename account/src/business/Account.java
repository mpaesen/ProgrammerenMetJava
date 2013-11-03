package business;

import java.util.ArrayList;

public abstract class Account
{
	private final int number;
	private ArrayList<Amount> transactions;
	private Amount beginSaldo;
	private static int sequence;

	public Account(final Amount beginSaldo)
	{
		super();
		this.number = ++sequence;
		this.transactions = new ArrayList<Amount>();
		this.beginSaldo = beginSaldo;
	}

	public Account()
	{
		this(new Amount());
	}

	public static int getSequence()
	{
		return sequence;
	}

	public int getNumber()
	{
		return number;
	}

	public ArrayList<Amount> getTransactions()
	{
		return transactions;
	}

	public void setBeginSaldo(final Amount beginSaldo)
	{
		this.beginSaldo = beginSaldo;
	}

	public Amount getBeginSaldo()
	{
		return beginSaldo;
	}

	public Amount getCurrentValue()
	{
		Amount value = getBeginSaldo();
		value.modify(Amount.Transaction.DEPOSIT, totalTransactions());
		return value;
	}

	public abstract void addTransaction(final Amount amount);

	public Amount totalTransactions()
	{
		Amount value = new Amount();
		for (final Amount amount : getTransactions())
		{
			//total of transactions
			value.modify(Amount.Transaction.DEPOSIT, amount);
		}
		return value;
	}

	public void updateAccount()
	{
		this.beginSaldo = getCurrentValue();
		//empty transactions list
		this.transactions = new ArrayList<Amount>();
	}

	@Override
	public String toString()
	{
		return "Account [getNumber()=" + getNumber() + ", getTransactions()=" + getTransactions() + ", \n\t\tgetBeginSaldo()=" + getBeginSaldo() + ", \n\t\tgetCurrentValue=" + getCurrentValue() + "]";
	}

}
