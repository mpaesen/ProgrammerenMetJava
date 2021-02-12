package javaTwo.com.ibm.wd150.ticketing;

public class Seat {
	private int row;

	private char letter;

	private Ticket ticket;

	public String toString() {
		String seatName = new Integer(row).toString();
		seatName += letter;
		seatName += (ticket == null) ? " Available" : " "
				+ ticket.getPassenger().getPName();
		return seatName;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
