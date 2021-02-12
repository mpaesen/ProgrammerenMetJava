/**
 * 
 */
package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author bempn
 *
 */
public class DAOTicketLine {
	private GregorianCalendar begin;
	private GregorianCalendar end;
	private int operator;
	private int status;
	private StringBuffer description;
	private int numberOfHours;
	private int lineNumber;
	private int number;
	public DAOTicketLine(){
		
	}
	public DAOTicketLine(ResultSet rs) throws SQLException{
		this();
		Date date = rs.getDate("BEGINDATE");
		begin = new GregorianCalendar(date.getYear(),date.getMonth(),date.getDate());
		date = rs.getDate("ENDDATE");
		end = new GregorianCalendar(date.getYear(),date.getMonth(),date.getDate());
		operator = rs.getInt("OPERATOR");
		status = rs.getInt("STATUS");
		numberOfHours = rs.getInt("NUMBEROFHOURS");
		lineNumber = rs.getInt("LINENUMBER");
		number = rs.getInt("NUMBER");
	}
	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	/**
	 * @return the begin
	 */
	public GregorianCalendar getBegin() {
		return begin;
	}
	/**
	 * @param begin the begin to set
	 */
	public void setBegin(GregorianCalendar begin) {
		this.begin = begin;
	}
	/**
	 * @return the description
	 */
	public StringBuffer getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(StringBuffer description) {
		this.description = description;
	}
	/**
	 * @return the end
	 */
	public GregorianCalendar getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(GregorianCalendar end) {
		this.end = end;
	}
	/**
	 * @return the numberOfHours
	 */
	public int getNumberOfHours() {
		return numberOfHours;
	}
	/**
	 * @param numberOfHours the numberOfHours to set
	 */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	/**
	 * @return the operator
	 */
	public int getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(int operator) {
		this.operator = operator;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
