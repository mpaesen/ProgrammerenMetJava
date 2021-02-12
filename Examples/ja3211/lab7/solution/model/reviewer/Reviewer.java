package lab7.solution.model.reviewer;

import lab7.solution.model.Profile;
/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 9:52:17 PM)
 * @author: ILS User
 */
public class Reviewer extends lab7.solution.model.Person {
/**
 * Reviewer constructor comment.
 */
public Reviewer() {
	super();
}
/**
 * Reviewer constructor comment.
 * @param theName java.lang.String
 * @param theEMail java.lang.String
 */
public Reviewer(String theName, String theEMail) {
	super(theName, theEMail);
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 9:52:17 PM)
 * @param theUserId java.lang.String
 * @param thePassword java.lang.String
 */
public void createProfile(String theUserId, String thePassword) {
	Profile theProfile = new Profile(theUserId, thePassword);
	theProfile.setPrivilege(Profile.REVIEWER);
	setProfile(theProfile);
}
}
