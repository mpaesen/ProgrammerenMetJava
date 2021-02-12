package javaTwo.com.ibm.wd150.ticketing;

import javaTwo.com.ibm.wd150.utilities.SeatReserver;

import java.util.ArrayList;

public class SeatingPlan
{
	private final ArrayList<Seat> seats;
	private int numSeatsPerRow = 0;
	private int numRows = 0;
	private int numBusRows = 0;
	private final SeatReserver seatReserver;

	private static String seatLetters = "ABCDEFGHJK";

	public SeatingPlan(final int rows, final int seatsAcross, final int businessRows)
	{
		seats = new ArrayList<Seat>();
		numSeatsPerRow = seatsAcross;
		numRows = rows;
		numBusRows = businessRows;
		seatReserver = new SeatReserver(this);
		// System.out.printf( "%3d%3d%3d", rows, seatsAcross, businessRows);
		Seat seat;
		for (int r = 0; r < rows; r++)
		{
			for (int s = 0; s < seatsAcross; s++)
			{
				seat = new Seat();
				seat.setRow(r + 1);
				seat.setLetter(seatLetters.charAt(s));
				seats.add(seat);
			}
		}
	}

	public SeatingPlan(final int rows, final int seatsAcross)
	{
		this(rows, seatsAcross, 0);
	}

	public int getNumBusRows()
	{
		return numBusRows;
	}

	public int getNumRows()
	{
		return numRows;
	}

	public int getNumSeatsPerRow()
	{
		return numSeatsPerRow;
	}

	public SeatReserver getSeatReserver()
	{
		return seatReserver;
	}

	public ArrayList<Seat> getSeats()
	{
		return seats;
	}

}
