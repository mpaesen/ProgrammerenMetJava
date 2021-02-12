package javaThree.com.ibm.wd150.ticketing;

import javaThree.com.ibm.wd150.utilities.SeatReserver;

import java.util.ArrayList;

public class SeatingPlan
{
	private final ArrayList<Seat> seats;

	private final SeatReserver seatReserver;

	private int totalRows = 0;

	private static String seatLetters = "ABCDEFGHJK";

	public SeatingPlan()
	{
		seats = new ArrayList<Seat>();
		Seat seat;
		for (final SeatingClass sClass : SeatingClass.values())
		{
			for (int r = 0; r < sClass.getRows(); r++)
			{
				totalRows++;
				for (int s = 0; s < sClass.getSeatsAcross(); s++)
				{
					seat = new Seat();
					seat.setRow(totalRows);
					seat.setLetter(seatLetters.charAt(s));
					seats.add(seat);
				}
			}
		}
		System.out.println("Seating plan has " + SeatingClass.getTotalSeats() + " seats.");
		seatReserver = new SeatReserver(this);
	}

	public SeatReserver getSeatReserver()
	{
		return seatReserver;
	}

	public ArrayList<Seat> getSeats()
	{
		return seats;
	}

	public int getTotalRows()
	{
		return totalRows;
	}

	public int getTotalSeats()
	{
		return SeatingClass.getTotalSeats();
	}

}
