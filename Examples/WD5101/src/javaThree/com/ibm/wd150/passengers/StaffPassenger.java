package javaThree.com.ibm.wd150.passengers;

import javaThree.com.ibm.wd150.ticketing.Discountable;

public class StaffPassenger extends Passenger implements Discountable
{

	private final String employeeId;

	public StaffPassenger(final PassengerName pName, final String employeeId)
	{
		super(pName);
		this.employeeId = employeeId;
	}

	public double discountPrice(final double price)
	{
		return price / 2.0;
	}

	public String getEmployeeId()
	{
		return employeeId;
	}
}