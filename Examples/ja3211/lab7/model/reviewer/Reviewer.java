package lab7.model.reviewer;

import lab7.model.Person;
import lab7.model.Profile;

public class Reviewer extends Person {

	/**
	 * Constructor for Reviewer
	 */
	public Reviewer() {
		super();
	}

	/**
	 * Constructor for Reviewer
	 */
	public Reviewer(String theName, String theEMail) {
		super(theName, theEMail);
	}

	/**
	 * @see Person#createProfile(String, String)
	 */
	public void createProfile(String theUserId, String thePassword) {
		Profile theProfile = new Profile(theUserId, thePassword);
		theProfile.setPrivilege(Profile.REVIEWER);
		setProfile(theProfile);
	}

}

