package lab8.solution.model;

/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 6:15:44 PM)
 * @author: ILS User
 */
public class Developer extends Person {
/**
 * Customer constructor comment.
 */
public Developer() {
	super();
}
/**
 * Customer constructor comment.
 * @param theName java.lang.String
 * @param theEMail java.lang.String
 */
public Developer(String theName, String theEMail) {
	super(theName, theEMail);
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 6:15:44 PM)
 * @param theUserId java.lang.String
 * @param thePassword java.lang.String
 * @param thePrivilege java.lang.String
 */
public void createProfile(String theUserId, String thePassword) {
	Profile theProfile = new Profile(theUserId, thePassword);
	theProfile.setPrivilege(Profile.DEVELOPER);
	setProfile(theProfile);
}
}
