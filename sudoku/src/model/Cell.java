package model;

import utilities.Constants;

public class Cell implements Comparable {
	private int value;

	/**
	 * @return Returns the value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            The value to set.
	 */
	public void setValue(int value) {
		if ((value % (Constants.DIMENSION * Constants.DIMENSION) < ((int)Math.pow(Constants.DIMENSION, 2.0))) && (value % ((int)Math.pow(Constants.DIMENSION, 2.0)) >= 0)) {
			this.value = value;
		}
	}

	/**
	 * @return Returns the string value of a Cell object.
	 */
	public String toString() {
		return "|" + getValue() + "|";
	}

	/**
	 * @param cell
	 * @return 0=equals, 1=greater then, -1=lesser then
	 */
	public int compareTo(Object cell) {
		if(this.getValue() == ((Cell)cell).getValue()){
			
			return 0;		 
		}
		if(this.getValue() > ((Cell)cell).getValue()){
			
			return +1;		 
		}
		
		return -1;
	}
}
