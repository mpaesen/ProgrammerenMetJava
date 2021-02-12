/**
 * 
 */
package database.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;


/**
 * @author bempn
 *
 */
public class DAOTicket {
	private int customerNumber;
	private GregorianCalendar date;
	private String description;	
	private int status;
	private int responsable;
	private int number;
	public DAOTicket(){
		
	}
	public DAOTicket(ResultSet rs) throws SQLException{
		this();
		customerNumber = rs.getInt("CUSTOMER");
		Date dateTicket = rs.getDate("DATE");
		date = new GregorianCalendar(dateTicket.getYear(),dateTicket.getMonth(),dateTicket.getDate());
		description = rs.getString("DESCRIPTION");
		status = rs.getInt("STATUS");
		responsable = rs.getInt("RESPONSABLE");
		number = rs.getInt("NUMBER");
	}
	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the lineNumber
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setNumber(int lineNumber) {
		this.number = lineNumber;
	}
	/**
	 * @return the responsable
	 */
	public int getResponsable() {
		return responsable;
	}
	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(int responsable) {
		this.responsable = responsable;
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

}
