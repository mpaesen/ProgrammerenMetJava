package lab8.model;
public class Customer extends Person {

	/**
	 * Constructor for Customer
	 */
	public Customer() {
		super();
	}

	/**
	 * Constructor for Customer
	 */
	public Customer(String theName, String theEMail) {
		super(theName, theEMail);
	}

	/**
	 * @see Person#createProfile(String, String)
	 */
	public void createProfile(String theUserId, String thePassword) {
		Profile theProfile = new Profile(theUserId, thePassword);
		theProfile.setPrivilege(Profile.USER);
		setProfile(theProfile);
	}

}

