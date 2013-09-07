package business;

import java.util.ArrayList;

public class Customer
{
	private String name;
	private final ArrayList<Account> accounts;

	public Customer(final String name)
	{
		super();
		this.name = name;
		accounts = new ArrayList<Account>();
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}

	public void addAccount(final Account account)
	{
		accounts.add(account);
	}

	@Override
	public String toString()
	{
		return "Customer [getName()=" + getName() + ", getAccounts()=" + getAccounts() + "]";
	}

}
