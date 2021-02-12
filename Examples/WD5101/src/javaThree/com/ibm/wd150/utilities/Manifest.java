package javaThree.com.ibm.wd150.utilities;

import javaThree.com.ibm.wd150.ticketing.Seat;
import javaThree.com.ibm.wd150.ticketing.SeatingClass;
import javaThree.com.ibm.wd150.ticketing.SeatingPlan;

import java.util.ArrayList;

public class Manifest
{
	SeatingPlan plan;

	public Manifest(final SeatingPlan plan)
	{
		this.plan = plan;
	}

	private void printOut()
	{
		final ArrayList<Seat> seats = plan.getSeats();
		System.out.println("Flight manifest");
		for (final Seat s : seats)
		{
			System.out.println(s);
		}
	}

	public static void main(final String[] args)
	{
		System.out.println("Flight open for ticket sales.");
		final SeatingPlan plan = new SeatingPlan();
		final Manifest manifest = new Manifest(plan);
		final SeatReserver reserver = plan.getSeatReserver();
		final int seatsSold = 0;
		final UserPrompter prompter = new UserPrompter("Do you want to purchace a ticket?");
		while (prompter.getYesNoAnswer() && seatsSold < plan.getTotalSeats())
		{
			for (int c = 0; c < SeatingClass.values().length; c++)
			{
				final SeatingClass sClass = SeatingClass.values()[c];
				if (sClass.getNumSeatsSold() < sClass.getNumSeats())
				{
					final UserPrompter prompt2 = new UserPrompter(" Do you want " + sClass + " class? ");
					if (prompt2.getYesNoAnswer())
					{
						reserver.sellTicket(sClass);
						break;
					}
				}
			}
		}
		manifest.printOut();
	}
}