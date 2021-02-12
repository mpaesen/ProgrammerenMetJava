package javaTwo.com.ibm.wd150.ticketing;

import javaTwo.com.ibm.wd150.utilities.SeatReserver;

import java.util.ArrayList;

public class Manifest
{
	SeatingPlan plan;

	public Manifest(final SeatingPlan plan)
	{
		this.plan = plan;
	}

	public void printOut()
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
		int rows = 10;
		int seats = 4;
		if (args.length < 2 || args[0].length() < 1 || args[1].length() < 1)
		{
			System.out.println("Usage: manifiest number_of_rows seats_per_row");
		}
		else
		{
			rows = Integer.parseInt(args[0]);
			if (rows < 1 || rows > 100)
			{
				System.out.println("Impossible seat layout, please try again.");
				System.exit(0);
			}
			seats = Integer.parseInt(args[1]);
			if (seats < 1 || seats > 10)
			{
				System.out.println("Impossible seat layout, please try again.");
				System.exit(0);
			}
		}
		System.out.println("Flight open ticket sales.");
		System.out.println("This plane has " + rows + " rows and " + seats + " seats across.");
		final SeatingPlan plan = new SeatingPlan(rows, seats);
		final Manifest manifest = new Manifest(plan);
		final SeatReserver reserver = plan.getSeatReserver();
		do
		{
		}
		while (reserver.sellTicket());
		manifest.printOut();

	}
}