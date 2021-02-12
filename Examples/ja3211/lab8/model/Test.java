package lab8.model;
public class Test {
	public final static String DEVELOPMENT = "DEVELOPMENT";
	public final static String PRODUCTION = "PRODUCTION";
	
	private static int nextTestIdNumber = 1;
	
	private String status;
	private String area;
	private String name;
	private int idNumber;

	/**
	 * Constructor for Test
	 */
	public Test() {
		super();
	}
	
	/**
	 *  Constructor for Test.
	 * @param theName Test name
	 * @param theArea Test area
	 */
	public Test(String theName, String theArea) {
		setName(theName);
		setArea(theArea);
		setIdNumber(getNextTestIdNumber());	
	}

	/**
	 * Gets the area
	 * @return Returns a String
	 */
	public String getArea() {
		return area;
	}
	/**
	 * Sets the area
	 * @param area The area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	 * Gets the idNumber
	 * @return Returns a int
	 */
	public int getIdNumber() {
		return idNumber;
	}
	
	/**
	 * Sets the idNumber
	 * @param idNumber The idNumber to set
	 */
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

		
	/**
	 * Get the next test id
	 * @return next test id 
	 */
	private static int getNextTestIdNumber() {
		return nextTestIdNumber++;
	}

	/**
	 * Gets the status
	 * @return Returns a String
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status
	 * @param status The status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


}

