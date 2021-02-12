package javaThree.com.ibm.wd150.ticketing;

import javaThree.com.ibm.wd150.passengers.Passenger;

public class Ticket
{
	private Passenger passenger;

	private Seat seat;

	private double price;

	private long ticketNo;

	public Passenger getPassenger()
	{
		return passenger;
	}

	public void setPassenger(final Passenger passenger)
	{
		this.passenger = passenger;
	}

	public double getPrice()
	{
		return price;
	}

	private static long count = 0;

	public Ticket(final Passenger passenger, final Seat seat, final double price)
	{
		this.passenger = passenger;
		this.price = price;
		this.seat = seat;
		this.ticketNo = ++count + 1000000;
	}

	public void setPrice(final double price)
	{
		this.price = price;
	}

	public Seat getSeat()
	{
		return seat;
	}

	public void setSeat(final Seat seat)
	{
		this.seat = seat;
	}

	public long getTicketNo()
	{
		return ticketNo;
	}

	public void setTicketNo(final long ticketNo)
	{
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString()
	{
		return ticketNo + " for seat " + seat.getRow() + seat.getLetter() + " at $" + price;
	}
}
