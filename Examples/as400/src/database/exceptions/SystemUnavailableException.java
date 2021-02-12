package database.exceptions;


public class SystemUnavailableException extends Exception {
	private Exception nestedException;


	/**
	 * Constructor for SystemUnavailableException
	 */
	public SystemUnavailableException(Exception nestedException) {
		super("System is currently unavailable");
		setNestedException(nestedException);
	}
	
	/**
	 * Gets the nestedException
	 * @return Returns a Exception
	 */
	public Exception getNestedException() {
		return nestedException;
	}
	/**
	 * Sets the nestedException
	 * @param nestedException The nestedException to set
	 */
	private void setNestedException(Exception nestedException) {
		this.nestedException = nestedException;
	}


}


