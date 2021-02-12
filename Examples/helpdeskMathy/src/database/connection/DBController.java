/**
 * 
 */
package database.connection;

import database.dao.DAOCustomer;
import database.dao.DAOEmployee;
import database.dao.DAOTicket;
import database.dao.DAOTicketLine;
import database.sql.SQLStatements;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





/**
 * @author bempn
 * 
 */
public class DBController {
	private ArrayList<DAOTicket> tickets;
	private ArrayList<DAOCustomer> customers;
	private ArrayList<DAOEmployee> employees;
	private ArrayList<DAOTicketLine> ticketLines;
	private ResultSet rs;
	private PreparedStatement pstmt;

	/**
	 * @return the tickets
	 */
	public ArrayList<DAOTicket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(ArrayList<DAOTicket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @return the customers
	 */
	public ArrayList<DAOCustomer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(ArrayList<DAOCustomer> customers) {
		this.customers = customers;
	}

	/**
	 * @return the employees
	 */
	public ArrayList<DAOEmployee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(ArrayList<DAOEmployee> employees) {
		this.employees = employees;
	}

	/**
	 * @return the ticketLines
	 */
	public ArrayList<DAOTicketLine> getTicketLines() {
		return ticketLines;
	}

	/**
	 * @param ticketLines the ticketLines to set
	 */
	public void setTicketLines(ArrayList<DAOTicketLine> ticketLines) {
		this.ticketLines = ticketLines;
	}

	public ResultSet getList(String sql) throws SQLException {
		pstmt = DatabaseConnectionController.getStatement(sql);
		rs = pstmt.executeQuery();
		//DatabaseConnectionController.closeResources(pstmt);
		return rs;
	}

	public ResultSet getEntity(String sql, int id) throws SQLException {
		pstmt = DatabaseConnectionController.getStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		//DatabaseConnectionController.closeResources(pstmt);
		return rs;
	}

	public DAOTicket getTicket(int id) throws SQLException {
		if (tickets.isEmpty()) {
			DAOTicket ticket = null;
			rs = connectAndGetListOfEntities(SQLStatements.TICKETS, "tickets");
			while (rs.next()) {
				ticket = new DAOTicket(rs);
				tickets.add(ticket);
			}
			DatabaseConnectionController.closeResources(rs);
		}
		return tickets.get(id);
	}
	
	public void putTicket(DAOTicket id) throws SQLException {
		pstmt = DatabaseConnectionController.getStatement(SQLStatements.ITICKET);
		//"Insert into ticket values(?, ?, ?, ?, ?, ?)"
		//pstmt.setInt(1, id.getNumber());
		pstmt.setInt(1, id.getCustomerNumber());
		pstmt.setDate(2, new Date(id.getDate().getTimeInMillis()));
		pstmt.setString(3, id.getDescription());
		pstmt.setInt(4, id.getStatus());
		pstmt.setInt(5, id.getResponsable());
		
		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}

	public DAOCustomer getCustomer(int id) throws SQLException {
		if (customers.isEmpty()) {
			DAOCustomer customer = null;
			rs = connectAndGetListOfEntities(SQLStatements.CUSTOMERS,
					"customers");
			while (rs.next()) {
				customer = new DAOCustomer(rs);
				customers.add(customer);
			}
			DatabaseConnectionController.closeResources(rs);			
		}
		return customers.get(id);
	}
	
	public void putCustomer(DAOCustomer id) throws SQLException {
		pstmt = null;
		pstmt = DatabaseConnectionController.getStatement(SQLStatements.ICUSTOMER);
		//Insert into from customer values(?, ?, ?, ?, ?)
		//pstmt.setInt(1, id.getNumber());
		pstmt.setString(1, id.getName());
		pstmt.setString(2, id.getAddress());
		pstmt.setString(3, id.getTelephone());
		pstmt.setString(4, id.getEmail());
		pstmt.setString(5, id.getContactPersoon());
		
		
		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}

	
	public DAOEmployee getEmployee(int id) throws SQLException {
		if (employees.isEmpty()) {
			DAOEmployee employee = null;
			rs = connectAndGetListOfEntities(SQLStatements.EMPLOYEES,
					"employees");
			while (rs.next()) {
				employee = new DAOEmployee(rs);
				employees.add(employee);
			}
			DatabaseConnectionController.closeResources(rs);			
		}
		return employees.get(id);
	}

	public void putEmployee(DAOEmployee id) throws SQLException {
		pstmt = null;
		pstmt = DatabaseConnectionController.getStatement(SQLStatements.IEMPLOYEE);
		//Insert into from employee values(?, ?)
		//pstmt.setInt(1, id.getNumber());
		pstmt.setString(1, id.getName());
		pstmt.setInt(2, id.getRole());

		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}
	
	
	public DAOTicketLine getTicketLine(int id) throws SQLException {
		if (employees.isEmpty()) {
			DAOTicketLine ticketLine = null;
			rs = connectAndGetListOfEntities(SQLStatements.TICKETLINES,
					"ticketLines");
			while (rs.next()) {
				ticketLine = new DAOTicketLine(rs);
				ticketLines.add(ticketLine);
			}
			DatabaseConnectionController.closeResources(rs);			
		}
		return ticketLines.get(id);
	}

	public void putTicketLine(DAOTicketLine id, int ticketNumber) throws SQLException {				
		pstmt = null;
		pstmt = DatabaseConnectionController.getStatement(SQLStatements.ITICKETLINE);
		//Insert into from ticketline values(?,?,?,?,?,?,?)
		pstmt.setInt(1, ticketNumber);
		//pstmt.setInt(1, id.getLineNumber());
		pstmt.setDate(2, new Date(id.getBegin().getTimeInMillis()));
		pstmt.setDate(3, new Date(id.getEnd().getTimeInMillis()));
		pstmt.setInt(4, id.getOperator());
		pstmt.setInt(5, id.getStatus());		
		pstmt.setString(6, id.getDescription().toString());		
		pstmt.setInt(7, id.getNumberOfHours());
		

		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}
		
	/**
	 * Get the entity list from de DB
	 */
	public ResultSet connectAndGetListOfEntities(String sql, String text) {
		rs = null;
		try {
			rs = getList(sql);
		} catch (SQLException e) {
			DatabaseConnectionController.logger.debug("No " + text + " found!");
			// e.printStackTrace();
		}
		return rs;
	}

	public DBController() {
		tickets = new ArrayList<DAOTicket>();
		customers = new ArrayList<DAOCustomer>();
		employees = new ArrayList<DAOEmployee>();
		ticketLines = new ArrayList<DAOTicketLine>();
	}
}
