package test;

import java.util.ArrayList;

import business.Customer;

public class TestAccounts
{

	private static ArrayList<Customer> customers;

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{

		//generate customers
		customers = GenerateTestData.createCustomers(customers);
		//print all accounts for all the customers
		for (final Customer customer : customers)
		{
			System.out.printf("%s\n", customer);
		}
	}

}
