package model;

import patterns.IAmountAdapter;
import patterns.INationality;
import test.TestPerson;

public class Person
{
	private String name;
	private IAmountAdapter amount; //adaptor
	private INationality nationality; //state

	public Person(final String name, final IAmountAdapter amount, final INationality nationality)
	{
		super();
		this.name = name;
		this.amount = amount;
		this.nationality = nationality;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public IAmountAdapter getAmount()
	{
		return amount;
	}

	public void setAmount(final IAmountAdapter amount)
	{
		this.amount = amount;
	}

	public INationality getNationality()
	{
		return nationality;
	}

	public void setNationality(final INationality nationality)
	{
		this.nationality = nationality;
	}

	public void speak()
	{
		TestPerson.logger.info(String.format("%s\t%9.2f%s", nationality.getMessage(this.getName()), amount.getAmount(nationality.getCurrency()).getAmount(), nationality.getCurrency().symbol()));
		TestPerson.logger.debug(this.toString());
	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", amount=" + amount.getAmount(nationality.getCurrency()) + ", nationality=" + getNationality() + "]";
	}

}
