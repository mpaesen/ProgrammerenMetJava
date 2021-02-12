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
public class DAOEmployee {
	private String name;
	private int number;
	private int role;
	public DAOEmployee(){
		
	}
	public DAOEmployee(ResultSet rs) throws SQLException{
		this();
		name = rs.getString("NAME");
		role = rs.getInt("ROLE");
		number = rs.getInt("NUMBER");
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
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
}
