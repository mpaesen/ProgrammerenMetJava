package javaThree.com.ibm.wd150.passengers;

public class Passenger {
	private PassengerName pName;
	
	public Passenger() {
		this.pName = new PassengerName("T.", "B.", "A.");
	}
	
	public Passenger(PassengerName pName) {
		this();
		this.pName = pName;
	}

	public PassengerName getPName() {
		return pName;
	}

	public void setPName(PassengerName name) {
		pName = name;
	}
}


