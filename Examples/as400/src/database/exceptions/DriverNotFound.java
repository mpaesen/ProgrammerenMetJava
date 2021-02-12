package database.exceptions;

import java.sql.SQLException;

public class DriverNotFound extends SQLException {
	private String driver;
	/**
	 * Constructor for DriverNotFound
	 */
	public DriverNotFound(String driver) {
		super("Driver "+driver+" not found");
		setDriver(driver);
	}

	/**
	 * Gets the driver
	 * @return Returns a String
	 */
	public String getDriver() {
		return driver;
	}
	
	/**
	 * Sets the driver
	 * @param driver The driver to set
	 */
	private void setDriver(String driver) {
		this.driver = driver;
	}
}

