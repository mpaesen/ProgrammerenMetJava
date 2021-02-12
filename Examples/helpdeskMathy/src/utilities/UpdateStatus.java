package utilities;

public enum UpdateStatus implements Status{
	open(10,"Open"),
	closed(20,"Closed"),
	refused(30, "Refused"),
	cancelled(40, "Cancelled");
	private final int code;
	private final String description;
	UpdateStatus(int code, String description){
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
