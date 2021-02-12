package javaTwo.com.ibm.wd150.utilities;

import javaTwo.com.ibm.wd150.passengers.Passenger;
import javaTwo.com.ibm.wd150.passengers.PassengerName;
import javaTwo.com.ibm.wd150.ticketing.Seat;
import javaTwo.com.ibm.wd150.ticketing.SeatingPlan;
import javaTwo.com.ibm.wd150.ticketing.Ticket;

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
		numSeats = plan.getNumRows() * plan.getNumSeatsPerRow();
		numSeatsSold = 0;
	}

	private Passenger getPassenger()
	{
		Passenger passenger = null;
		final String firstName = new UserPrompter("First name?").getAnswer();
		final String lastName = new UserPrompter("Last name?").getAnswer();
		final String initial = new UserPrompter("Initial?").getAnswer();
		final PassengerName pName = new PassengerName(firstName, initial, lastName);
		passenger = new Passenger(pName);

		return passenger;
	}

	private Seat assignSeat()
	{
		int seatNumber;
		// seat assignment from random number generator
		seatNumber = seatFinder.nextInt(numSeats);
		final ArrayList<Seat> seats = plan.getSeats();
		// random numbers may issue same seat twice.
		// if that happens take first available seat in section
		Seat seat = seats.get(seatNumber);
		if (seat.getTicket() != null)
		{
			seat = findFirstEmptySeat(seats);
			if (seat == null)
			{
				return null;
			}
		}
		numSeatsSold++;
		return seat;
	}

	private Seat findFirstEmptySeat(final ArrayList<Seat> seats)
	{
		final int first = 0;
		final int last = numSeats;
		Seat seat = null;
		for (int i = first; i < last; i++)
		{
			seat = seats.get(i);
			if (seat.getTicket() == null)
			{
				return seat;
			}
		}
		return null;
	}

	public boolean sellTicket()
	{
		final double price = 500.0;
		if (numSeats == numSeatsSold)
		{
			System.out.println("This flight is sold out.");
			return false;
		}
		final UserPrompter prompter = new UserPrompter("Do you want to purchace a ticket?");
		if (!prompter.getYesNoAnswer())
		{
			return false;
		}
		final Passenger passenger = getPassenger();
		final Seat seat = assignSeat();
		if (seat == null)
		{
			System.out.println("Unable to assign seat, flight closed.");
			return false;
		}
		final Ticket ticket = new Ticket(passenger, seat, price);
		seat.setTicket(ticket);
		System.out.println("Seat assignment: " + seat);
		System.out.println();
		return true;
	}
}