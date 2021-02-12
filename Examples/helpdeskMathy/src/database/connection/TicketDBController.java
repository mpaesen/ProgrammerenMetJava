/**
 * 
 */
package database.connection;

import database.dao.DAOTicket;
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
public class TicketDBController extends DBController{
	private ArrayList<DAOTicket> tickets;

	private ResultSet rs;
	private PreparedStatement pstmt;

	
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
		pstmt.setInt(1, id.getNumber());
		pstmt.setInt(2, id.getCustomerNumber());
		pstmt.setDate(3, new Date(id.getDate().getTimeInMillis()));
		pstmt.setString(4, id.getDescription());
		pstmt.setInt(5, id.getStatus());
		pstmt.setInt(6, id.getResponsable());
		
		pstmt.execute();
		//DatabaseConnectionController.closeResources(pstmt);
	}

		public TicketDBController() {
		tickets = new ArrayList<DAOTicket>();
	}
}
