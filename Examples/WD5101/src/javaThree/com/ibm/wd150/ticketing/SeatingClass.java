package javaThree.com.ibm.wd150.ticketing;

public enum SeatingClass {
	BUSINESS(1, 2, 750.0), 
	ECONOMY(3, 4, 500.0);

	private int rows;

	private int seatsAcross;

	private double price;

	private int numSeats, numSeatsSold;

	private int indexFirstSeat;

	private static int totalSeats = -1;

	private SeatingClass(int rows, int seatsAcross, double price) {
		this.rows = rows;
		this.seatsAcross = seatsAcross;
		this.price = price;
		numSeats = rows * seatsAcross;
		numSeatsSold = 0;
		indexFirstSeat = -1;
	}

	public int getNumSeatsSold() {
		return numSeatsSold;
	}

	public void setNumSeatsSold(int numSeatsSold) {
		this.numSeatsSold = numSeatsSold;
	}

	public int getIndexFirstSeat() {
		if (indexFirstSeat < 0) {
			setIndexSeats();
		}
		return indexFirstSeat;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public double getPrice() {
		return price;
	}

	public int getRows() {
		return rows;
	}

	public int getSeatsAcross() {
		return seatsAcross;
	}

	public static int getTotalSeats() {
		if (totalSeats < 0) {
			setIndexSeats();
		}
		return totalSeats;
	}

	private static void setIndexSeats() {
		totalSeats = 0;
		for (int i = 0; i < values().length; i++) {
			SeatingClass sClass = values()[i];
			sClass.indexFirstSeat = totalSeats;
			totalSeats += sClass.getNumSeats();
		}
	}
}
