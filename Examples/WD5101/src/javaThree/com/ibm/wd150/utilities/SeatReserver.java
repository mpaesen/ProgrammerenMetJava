package javaThree.com.ibm.wd150.utilities;

import javaThree.com.ibm.wd150.passengers.FrequentFlyer;
import javaThree.com.ibm.wd150.passengers.Passenger;
import javaThree.com.ibm.wd150.passengers.PassengerName;
import javaThree.com.ibm.wd150.passengers.StaffPassenger;
import javaThree.com.ibm.wd150.ticketing.*;

import java.util.ArrayList;
import java.util.Random;

public class SeatReserver
{
	private final Random seatFinder;

	private final SeatingPlan plan;

	private final int numSeats;

	private int numSeatsSold;

	public SeatReserver(final SeatingPlan plan)
	{
		this.plan = plan;
		seatFinder = new Random(this.hashCode());
		numSeats = plan.getTotalSeats();
		numSeatsSold = 0;
	}

	private Passenger getPassenger()
	{
		Passenger passenger = null;
		final String firstName = new UserPrompter("First name?").getAnswer();
		final String lastName = new UserPrompter("Last name?").getAnswer();
		final String initial = new UserPrompter("Initial?").getAnswer();
		final PassengerName pName = new PassengerName(firstName, initial, lastName);
		if (new UserPrompter("Are you a frequent flyer?").getYesNoAnswer())
		{
			final String fFlyerId = new UserPrompter("Frequent flyer number?").getAnswer();
			passenger = new FrequentFlyer(pName, fFlyerId);
		}
		else if (new UserPrompter("Are you an airline employee?").getYesNoAnswer())
		{
			final String employeeId = new UserPrompter("Employee ID?").getAnswer();
			passenger = new StaffPassenger(pName, employeeId);
		}
		else
		{
			passenger = new Passenger(pName);
		}
		return passenger;
	}

	private Seat assignSeat(final SeatingClass sClass)
	{
		int seatNumber;
		// seat assignment from random number generator
		seatNumber = seatFinder.nextInt(sClass.getNumSeats()) + sClass.getIndexFirstSeat();
		final ArrayList<Seat> seats = plan.getSeats();
		// random numbers may issue same seat twice.
		// if that happens take first available seat in section
		Seat seat = seats.get(seatNumber);
		if (seat.getTicket() != null)
		{
			seat = findFirstEmptySeat(seats, sClass);
			if (seat == null)
			{
				return null;
			}
		}
		numSeatsSold++;
		sClass.setNumSeatsSold(sClass.getNumSeatsSold() + 1);
		return seat;
	}

	private Seat findFirstEmptySeat(final ArrayList<Seat> seats, final SeatingClass sClass)
	{
		Seat seat = null;
		final int firstSeat = 0;
		for (int i = 0; i < sClass.getNumSeats(); i++)
		{
			seat = seats.get(i + firstSeat);
			if (seat.getTicket() == null)
			{
				return seat;
			}
		}
		return null;
	}

	public boolean sellTicket(final SeatingClass sClass)
	{
		double price = sClass.getPrice();
		if (numSeats == numSeatsSold)
		{
			System.out.println("This flight is sold out.");
			return false;
		}
		final Passenger passenger = getPassenger();
		final Seat seat = assignSeat(sClass);
		if (seat == null)
		{
			System.out.println("Unable to assign seat, flight closed.");
			return false;
		}
		if (passenger instanceof Discountable)
		{
			price = ((Discountable) passenger).discountPrice(price);
		}
		final Ticket ticket = new Ticket(passenger, seat, price);
		seat.setTicket(ticket);
		System.out.println("Ticket issued: " + ticket);
		System.out.println();
		return true;
	}
}