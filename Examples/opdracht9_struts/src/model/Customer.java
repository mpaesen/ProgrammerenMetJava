package model;

import java.io.Serializable;

/**
 * @author Erwin Aernouts
 */


public class Customer implements Comparable<model.Customer>, Serializable
{
	
	private int personID;
	private String name;
	private String address;
	private static final long serialVersionUID = 1L;
	
	
	public Customer()
	{
		this.setPersonID(0);
		this.setName("geen");
		this.setAddress("geen");
	}
	
	public Customer(int id, String name, String addr)
	{
		this.setPersonID(id);
		this.setName(name);
		this.setAddress(addr);

	}
	
	@Override
	public int compareTo(Customer c) 
	{
		if (this.getPersonID() == c.getPersonID())
			return 0;
		else if (this.getPersonID() < c.getPersonID())
			return -1;
		else
			return 1;
	}
	
	public String toString()
	{
		return this.getName();
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	
}
