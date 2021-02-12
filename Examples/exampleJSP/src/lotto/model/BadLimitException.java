/*
 * Created on Dec 8, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto.model;

/**
 * @author bempn
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BadLimitException extends Exception {

	/**
	 * 
	 */
	public BadLimitException() {
		this("To many figures in the combination for the given limits");
		// TODO Auto-generated constructor stub
	}

	public BadLimitException(int min, int max) {
		this("To many figures in the combination for the given limits min:"
				+ min + " and max:" + max);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public BadLimitException(String arg0) {
		super(arg0);
	}

}
