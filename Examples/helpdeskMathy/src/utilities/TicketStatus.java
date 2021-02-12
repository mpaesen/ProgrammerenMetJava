package utilities;

public enum TicketStatus implements Status{
	open(10,"Open"),
	closed(20,"Closed"),
	waitingForInfo(30, "Refused"),
	waitingForSpareParts(40, "WaitingForSpareParts"),
	analysis(50, "Cancelled"),
	repair(60, "Cancelled");
	private final int code;
	private final String description;
	
	TicketStatus(int code, String description){
		this.code = code;
		this.description = description;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
