package test;

import database.dao.DAOTicket;

import java.util.GregorianCalendar;
import java.util.Random;

public class TicketFactory {
	private static final String DESCRIPTIONS[]={"Monitor", "Moederbord", "Modem", "Router", "Voeding", "PC", "Laptop","BlackBerry"};
	private static final int STATUS[]={10,20,30};
		
		
	private static int number = 1;

	public static DAOTicket getTicket(Random rand, int customerNumber, int responsable){
		DAOTicket ticket= new DAOTicket();
			ticket.setDescription(DESCRIPTIONS[rand.nextInt(DESCRIPTIONS.length)]);
			ticket.setStatus(STATUS[rand.nextInt(STATUS.length)]);
			ticket.setDate(new GregorianCalendar());
			ticket.setResponsable(responsable);
			ticket.setCustomerNumber(customerNumber);
			ticket.setNumber(number++);
			return ticket;
	}

}
