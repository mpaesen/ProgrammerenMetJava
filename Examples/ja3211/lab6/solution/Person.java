package lab6.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 1:29:35 PM)
 * @author: ILS User
 */
public abstract class Person {
	private java.lang.String name;
	private java.lang.String eMail;
	private Profile profile;
/**
 * Customer constructor comment.
 */
public Person() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 2:50:01 PM)
 * @param theName java.lang.String
 * @param theEMail java.lang.String
 */
public Person(String theName, String theEMail) {
	setName(theName);
	setEMail(theEMail);	
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 5:16:54 PM)
 * @param theUserId java.lang.String
 * @param thePassword java.lang.String
 * @param thePrivilege java.lang.String
 */
public abstract void createProfile(String theUserId, String thePassword);
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:46:20 PM)
 * @return java.lang.String
 */
public java.lang.String getEMail() {
	return eMail;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:43:56 PM)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:46:44 PM)
 * @return lab4.Profile
 */
public Profile getProfile() {
	return profile;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 3:11:42 PM)
 * @return boolean
 * @param theUserId java.lang.String
 * @param thePassword java.lang.String
 */
public boolean login(String theUserId, String thePassword) {
	return profile.authenticate(theUserId, thePassword);
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:46:20 PM)
 * @param newEMail java.lang.String
 */
public void setEMail(java.lang.String newEMail) {
	eMail = newEMail;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:43:56 PM)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:46:44 PM)
 * @param newProfile lab4.Profile
 */
public void setProfile(Profile newProfile) {
	profile = newProfile;
}
}
