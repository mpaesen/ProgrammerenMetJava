package javaThree.com.ibm.wd150.passengers;


public class FrequentFlyer extends Passenger {

	private String fFlyerId;
	
	public FrequentFlyer( PassengerName pName, String fFlyerId) {
		super(pName);
		this.fFlyerId = fFlyerId;
	}

	public String getFFlyerId() {
		return fFlyerId;
	}

}
