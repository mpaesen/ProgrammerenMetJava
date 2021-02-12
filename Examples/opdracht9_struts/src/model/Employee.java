package model;

import java.io.Serializable;

/**
 * @author Erwin Aernouts
 */


public class Employee implements Serializable{
	
	
	private int personID;
	private String name;
	private String address;
	private int role;
	private static final long serialVersionUID = 1L;
	
	public Employee()
	{
		this.setPersonID(0);
		this.setName("");
		this.setRole(0);
		this.setAddress("");
	}
	
	public Employee(int i, String name, int role)
	{
		this.setPersonID(i);
		this.setName(name);
		this.setRole(role);
	}
	
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public int getPersonID() {
		return personID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public String toString()
	{
		return this.getName();
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
