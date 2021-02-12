package lab5;
public class Profile {
	public final static String USER = "USER";
	public final static String DEVELOPER = "DEVELOPER";
	
	private String userId;
	private String password;
	private String privilege;
	/**
	 * Constructor for Profile
	 */
	public Profile() {
		super();
	}
	
	/**
	 * Create the Profile
	 * @param theUserId The user id to set
	 * @param thePassword The password to set.
	 */
	public Profile(String theUserId, String thePassword) {
		super();
		setUserId(theUserId);
		setPassword(thePassword);
	}

	/**
	 * Gets the userId
	 * @return Returns a String
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * Sets the userId
	 * @param userId The userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * Gets the password
	 * @return Returns a String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the password
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Authenticate the user ID and password
	 * @param theUserId The user ID to be authenticated
	 * @param thePassword The password to be authenticated
	 * @return Returns true if the user ID and password are valid
	 */
	public boolean authenticate(String theUserId, String thePassword) {
		if (theUserId == null || thePassword == null) {
			return false;
		}
		
		return (theUserId.equals(userId) &&
			    thePassword.equals(password));
	}
	/**
	 * Gets the privilege
	 * @return Returns a String
	 */
	public String getPrivilege() {
		return privilege;
	}
	/**
	 * Sets the privilege
	 * @param privilege The privilege to set
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}


}

