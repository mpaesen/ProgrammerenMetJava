/**
 * 
 */
package database.connection;

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
public class TicketLineDBController extends DBController{

	private ArrayList<DAOTicketLine> ticketLines;
	private ResultSet rs;
	private PreparedStatement pstmt;

	
	
	public DAOTicketLine getTicketLine(int id) throws SQLException {
		if (ticketLines.isEmpty()) {
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
		pstmt.setInt(2, id.getLineNumber());
		pstmt.setDate(3, new Date(id.getBegin().getTimeInMillis()));
		pstmt.setDate(4, new Date(id.getEnd().getTimeInMillis()));
		pstmt.setInt(5, id.getOperator());
		pstmt.setInt(6, id.getStatus());		
		pstmt.setString(7, id.getDescription().toString());		
		pstmt.setInt(8, id.getNumberOfHours());
		

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

	public TicketLineDBController() {
		
		ticketLines = new ArrayList<DAOTicketLine>();
	}
}
