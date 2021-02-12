package lab6.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 4:07:44 PM)
 * @author: ILS User
 */
public class Test {
	private java.lang.String area;
	private java.lang.String name;
	private int idNumber;
	private static int nextTestIdNumber = 1;
	private java.lang.String status;
	public final static java.lang.String DEVELOPMENT = "DEVELOPMENT";
	public final static java.lang.String PRODUCTION = "PRODUCTION";
/**
 * Test constructor comment.
 */
public Test() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:11:23 PM)
 * @param theName java.lang.String
 * @param theArea java.lang.String
 */
public Test(String theName, String theArea) {
	setName(theName);
	setArea(theArea);
	setIdNumber(getNextTestIdNumber());
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:09:51 PM)
 * @return java.lang.String
 */
public java.lang.String getArea() {
	return area;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:10:29 PM)
 * @return int
 */
public int getIdNumber() {
	return idNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:10:16 PM)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:13:24 PM)
 * @return int
 */
private static int getNextTestIdNumber() {
	return nextTestIdNumber++;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 5:01:15 PM)
 * @return java.lang.String
 */
public java.lang.String getStatus() {
	return status;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:09:51 PM)
 * @param newArea java.lang.String
 */
public void setArea(java.lang.String newArea) {
	area = newArea;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:10:29 PM)
 * @param newIdNumber int
 */
public void setIdNumber(int newIdNumber) {
	idNumber = newIdNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 4:10:16 PM)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (2/27/2002 5:01:15 PM)
 * @param newStatus java.lang.String
 */
public void setStatus(java.lang.String newStatus) {
	status = newStatus;
}
}
