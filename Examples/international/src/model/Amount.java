package model;

public class Amount
{

	private double amount;

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(final double amount)
	{
		this.amount = amount;
	}

	public Amount(final double amount)
	{
		super();
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return "Amount [amount=" + getAmount() + "]";
	}
}
