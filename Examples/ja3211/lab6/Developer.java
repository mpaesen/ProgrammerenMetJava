package lab6;
public class Developer extends Person {

	/**
	 * Constructor for Developer
	 */
	public Developer() {
		super();
	}

	/**
	 * Constructor for Developer
	 */
	public Developer(String theName, String theEMail) {
		super(theName, theEMail);
	}

	/**
	 * @see Person#createProfile(String, String)
	 */
	public void createProfile(String theUserId, String thePassword) {
		Profile theProfile = new Profile(theUserId, thePassword);
		theProfile.setPrivilege(Profile.DEVELOPER);
		setProfile(theProfile);
	}
}

