package database.sql;

public interface SQLStatements {
	String CUSTOMERS = "Select * from customer";
	String CUSTOMER = "Select * from customer where number = ?";
	String UCUSTOMER = "Update customer set where number = ?";
	String ICUSTOMER = "Insert into customer (name, address, telephone, email, contactperson) values(?, ?, ?, ?, ?)";
	String DCUSTOMER = "Delete from customer where number = ?";
	
	String TICKETS = "Select * from ticket";
	String TICKET = "select * from ticket where number = ?";
	String UTICKET = "update ticket set where number = ?";
	String ITICKET = "Insert into ticket (customer, date, description, status, responsable) values(?, ?, ?, ?, ?)";
	String DTICKET = "Delete from ticket where number = ?";
	
	String TICKETLINES = "Select * from TICKETLINE";
	String TICKETLINE = "select * from TICKETLINE where number = ?";
	String UTICKETLINE = "update TICKETLINE set where number = ?";
	String ITICKETLINE = "Insert into TICKETLINE (number, begindate, enddate, operator, status, description, hours) values(?, ?, ?, ?, ?, ?, ?)";
	String DTICKETLINE = "Delete from TICKETLINE where number = ?";
	
	String EMPLOYEES = "Select * from employee";
	String EMPLOYEE = "select * from employee where number = ?";
	String UEMPLOYEE = "update employee set where number = ?";
	String IEMPLOYEE = "Insert into  employee (name, role) values(?, ?)";	
	String DEMPLOYEE = "Delete from employee where number = ?";
}
