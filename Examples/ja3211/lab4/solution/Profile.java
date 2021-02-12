package lab4.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 1:32:32 PM)
 * @author: ILS User
 */
public class Profile {
	private java.lang.String userId;
	private java.lang.String password;
/**
 * Profile constructor comment.
 */
public Profile() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 2:54:16 PM)
 * @param theUserId java.lang.String
 * @param thePassword java.lang.String
 */
public Profile(String theUserId, String thePassword) {
	setUserId(theUserId);
	setPassword(thePassword);
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 3:00:24 PM)
 * @return boolean
 * @param theUserid java.lang.String
 * @param thePassword java.lang.String
 */
public boolean authenticate(String theUserId, String thePassword) {
	if (theUserId == null || thePassword == null) {
		return false;
	}

	return ((theUserId.equals(userId)) &&
			(thePassword.equals(password)));
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:47:57 PM)
 * @return java.lang.String
 */
public java.lang.String getPassword() {
	return password;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:47:27 PM)
 * @return java.lang.String
 */
public java.lang.String getUserId() {
	return userId;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:47:57 PM)
 * @param newPassword java.lang.String
 */
public void setPassword(java.lang.String newPassword) {
	password = newPassword;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 1:47:27 PM)
 * @param newUserId java.lang.String
 */
public void setUserId(java.lang.String newUserId) {
	userId = newUserId;
}
}
