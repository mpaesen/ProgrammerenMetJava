package test;

import java.util.ArrayList;
import java.util.Random;

import business.Account;
import business.AccountFactory;
import business.Amount;
import business.Customer;
import exceptions.NoNegativeAmountAllowed;

public class GenerateTestData
{
	private static Random random = new Random();
	private static final int MAX_CUSTOMERS_GENERATED = 10;
	private static final int MAX_TRANSACTIONS_GENERATED = 50;
	private static final int MAX_ACCOUNTS_GENERATED = 5;
	private static final double INITIAL_VALUE = 20.0;
	private static final double INITIAL_BEGIN_SALDO = 1000.0;
	

	public static ArrayList<Customer> createCustomers(ArrayList<Customer> customers)
	{
		final int MAX_CUSTOMERS = 1 + random.nextInt(MAX_CUSTOMERS_GENERATED);
		customers = new ArrayList<Customer>();
		Customer customer;
		for (int i = 0; i < MAX_CUSTOMERS; i++)
		{
			customer = new Customer(getRandomName());
			customers.add(createAccounts(customer));
		}
		return customers;
	}

	public static Customer createAccounts( Customer customer)
	{

		final int MAX_ACCOUNTS = 1 + random.nextInt(MAX_ACCOUNTS_GENERATED);
		Account account;
		final AccountFactory factory = new AccountFactory();
		for (int i = 0; i < MAX_ACCOUNTS; i++)
		{
			//random account generation
			account = factory.createAccount(AccountFactory.Type.values()[random.nextInt(AccountFactory.Type.values().length)]);
			//ZERO <= Begin saldo < INITIAL_BEGIN_SALDO
			account.setBeginSaldo(new Amount(INITIAL_BEGIN_SALDO * random.nextDouble()));
			//random transaction generation
			account = createTransactions(account);
			customer.addAccount(account);
		}
		return customer;
	}

	public static String getRandomName()
	{
		final String names[] = { "Paesen", "Hameed", "Schoofs", "Westhovens", "Geybels", "Vicari", "Lambrechts" };
		final String fnames[] = { "Mathy", "Shahul", "Odon", "Els", "Johan", "Gino", "Geert", "Tom", "Stefan", "Frank", "Patricia", "Imran", "Antonio", "Ingrid" };

		final StringBuffer name = new StringBuffer(names[random.nextInt(names.length)]);
		name.append(", ");
		name.append(fnames[random.nextInt(fnames.length)]);
		return name.toString();
	}

	public static Account createTransactions( Account account)
	{
		final int MAX_TRANSACTIONS = 1 + random.nextInt(MAX_TRANSACTIONS_GENERATED);
		Amount amount;
		for (int i = 0; i < MAX_TRANSACTIONS; i++)
		{
			//ZERO <= transaction < INITIAL_VALUE
			amount = new Amount(INITIAL_VALUE * random.nextDouble());
			//for every 4th amount inverse the sign (CREDIT)
			if (i % 4 == 0)
			{
				amount.inverseSign();
			}
			try
			{
				//-20.0 < amount < 20.0
				account.addTransaction(amount);
			}
			catch (final NoNegativeAmountAllowed e)
			{
				//only error if SavingAccount
				System.err.printf("%s\n", e);
			}
		}
		return account;
	}
}
