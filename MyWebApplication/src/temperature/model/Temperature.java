// FrontEnd Plus GUI for JAD
// DeCompiled : Temperature.class

package temperature.model;

import java.math.BigDecimal;

public abstract class Temperature {
	public static final int SCALE = 3;

	public static final char CELCIUS = 67;

	public static final char KELVIN = 75;

	public static final char FARENHEIT = 70;

	public static final String DEGREES = "\260";

	public static final char CONVERSION = 'C';

	public static final char ADDITION = 'A';

	private BigDecimal temp;

	private char symbol;

	/**
	 * Constructor
	 * 
	 * @param double
	 */
	public Temperature(double temp) {
		this.temp = (new BigDecimal(temp)).setScale(SCALE,
				BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Get the value of the actual temperature
	 * 
	 * @param none
	 * @return char
	 */
	public BigDecimal getTemperature() {
		return this.temp;
	}

	/**
	 * Set the value of the actual temperature
	 * 
	 * @param double
	 * @return none
	 */
	public void setTemperature(double temp) {
		setTemperature(new BigDecimal(temp));
	}

	/**
	 * Set the value of the actual temperature
	 * 
	 * @param BigDecimal
	 * @return none
	 */
	public void setTemperature(BigDecimal temp) {
		this.temp = temp;
		this.temp.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Set the symbol of the actual temperature
	 * 
	 * @param double
	 * @return none
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Get the symbol of the actual temperature
	 * 
	 * @param none
	 * @return char
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * method toString
	 * 
	 * @return String representation of any temperature
	 */
	public String toString() {
		return "" + getTemperature() + " " + DEGREES + getSymbol();
	}
}