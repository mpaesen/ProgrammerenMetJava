package javaOne.com.ibm.wd150.ticketing;

import javaOne.com.ibm.wd150.passengers.Passenger;
import javaOne.com.ibm.wd150.passengers.PassengerName;
import javaOne.com.ibm.wd150.utilities.UserPrompter;

public class TicketIssuer
{

	private Ticket ticket;

	private Passenger getPassenger()
	{
		final String firstName = new UserPrompter("First name?").getAnswer();
		final String lastName = new UserPrompter("Last name?").getAnswer();
		final String initial = new UserPrompter("Initial?").getAnswer();
		final PassengerName pName = new PassengerName(firstName, initial, lastName);
		return new Passenger(pName);
	}

	private Seat assignSeat()
	{
		final Seat seat = new Seat();
		int row = 0;
		while (row < 1)
		{
			row = Integer.parseInt(new UserPrompter("Select row (1-37)").getAnswer());
			if (row < 1 || row > 37)
				row = -1;
		}
		seat.setRow(row);
		char letter = 'Z';
		final UserPrompter up = new UserPrompter("Select seat in range ABCDEFGH");
		while (letter == 'Z')
		{
			letter = up.getAnswer().charAt(0);
			if (letter < 'A' || letter > 'H')
				letter = 'Z';
		}
		seat.setLetter(letter);
		return seat;
	}

	public boolean issueTicket()
	{
		final UserPrompter prompter = new UserPrompter("Do you want to purchace a ticket?");
		if (!prompter.getYesNoAnswer())
		{
			return false;
		}
		final Passenger passenger = getPassenger();
		final Seat seat = assignSeat();
		ticket = new Ticket(passenger, seat, 500.0);
		seat.setTicket(ticket);
		System.out.println("Ticket Issued:");
		return true;
	}

	public static void main(final String[] args)
	{
		final TicketIssuer ti = new TicketIssuer();
		if (ti.issueTicket())
		{
			System.out.println("       " + ti.getTicket());
		}
		else
		{
			System.out.println("No ticket issued.");
		}
	}

	public Ticket getTicket()
	{
		return ticket;
	}

	public void setTicket(final Ticket ticket)
	{
		this.ticket = ticket;
	}
}
