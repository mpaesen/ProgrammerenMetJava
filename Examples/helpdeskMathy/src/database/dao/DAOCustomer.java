/**
 * 
 */
package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bempn
 *
 */
public class DAOCustomer {
	private String name;
	private String address;
	private String telephone;
	private String email;
	private String contactPersoon;
	private int number;
	public DAOCustomer(){
		
	}
	public DAOCustomer(ResultSet rs) throws SQLException{
		this();
		name = rs.getString("NAME");
		address = rs.getString("ADDRESS");
		telephone = rs.getString("TELEPHONE");
		email = rs.getString("EMAIL");
		contactPersoon = rs.getString("CONTACTPERSOON");
		number = rs.getInt("NUMBER");
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contactPersoon
	 */
	public String getContactPersoon() {
		return contactPersoon;
	}
	/**
	 * @param contactPersoon the contactPersoon to set
	 */
	public void setContactPersoon(String contactPersoon) {
		this.contactPersoon = contactPersoon;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
