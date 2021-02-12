package model;

public class Person {

	private string name;
	private string firstName;
	private Address address;
	private int ID;

	public string getName() {
		return this.name;
	}

	public void setName(string name) {
		this.name = name;
	}

	public string getFirstName() {
		return this.firstName;
	}

	public void setFirstName(string firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}