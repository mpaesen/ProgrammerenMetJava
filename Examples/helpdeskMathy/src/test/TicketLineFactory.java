package test;

import database.dao.DAOTicketLine;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class TicketLineFactory {
	private static final String DESCRIPTIONS[] = { "Herstelling", "Vervanging",
			"Vervanging Wisselstuk", "Herstelling Wisselstuk", "Administratief" };

	private static final int STATUS[] = { 10, 20, 30 };
	private static  int lineNumber = 1;

	public static DAOTicketLine getTicketLine(Random rand, int ticket, int operator) {
		DAOTicketLine ticketLine = new DAOTicketLine();
		ticketLine.setDescription(new StringBuffer(DESCRIPTIONS[rand
				.nextInt(DESCRIPTIONS.length)]));
		ticketLine.setStatus(STATUS[rand.nextInt(STATUS.length)]);
		ticketLine.setBegin(new GregorianCalendar());		
		GregorianCalendar date =new GregorianCalendar();
		date.add(Calendar.DAY_OF_MONTH, 1);
		ticketLine.setEnd(date);
		
		
		ticketLine.setNumberOfHours(1+rand.nextInt(25) );
		ticketLine.setNumber(ticket);
		ticketLine.setOperator(operator);
		ticketLine.setLineNumber(lineNumber++);
		return ticketLine;
	}

}
