package lab5;
public class Customer {
	private String name;
	private String eMail;
	private Profile profile;


	/**
	 * Constructor for Customer
	 */
	public Customer() {
		super();
	}

	/**
	 * Create a new Customer from the specified parameters
	 * @param theName The name to set
	 * @param theEMail The eMail to set
	 */
	public Customer(String theName, String theEMail) {
		super();
		setName(theName);
		setEMail(theEMail);
	}
	
	/**
	 * Gets the name
	 * @return Returns a String
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the eMail
	 * @return Returns a String
	 */
	public String getEMail() {
		return eMail;
	}
	/**
	 * Sets the eMail
	 * @param mail The eMail to set
	 */
	public void setEMail(String mail) {
		eMail = mail;
	}


	/**
	 * Gets the profile
	 * @return Returns a Profile
	 */
	public Profile getProfile() {
		return profile;
	}
	/**
	 * Sets the profile
	 * @param profile The profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Log in with the specified user ID and password.
	 * @param theUserId User ID to use for the login request
	 * @param thePassword Password to use for the login request
	 * @return boolean True if login was a success.
	 */
	public boolean login(String theUserId, String thePassword) {
		return profile.authenticate(theUserId, thePassword);
	}
	
	/**
	 * Create a profile for the Customer
	 * @param theUserId User ID of the customer
	 * @param thePasswork Password of the customer
	 * @param thePrivilege Customer's privilege
	 */
	public void createProfile(String theUserId, String thePassword, String thePrivilege) {
		Profile profile = new Profile(theUserId,thePassword);
		profile.setPrivilege(thePrivilege);
		setProfile(profile);
	}
}


