/*
 * Created on Dec 8, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lotto.ui;

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
	private static final long serialVersionUID = 7504440169931846560L;

	/**
	 * 
	 */
	public BadLimitException() {
		this("To many figures in the combination for the given limits");

	}

	public BadLimitException(int min, int max) {
		this("To many figures in the combination for the given limits min:"
				+ min + " and max:" + max);
	}

	/**
	 * @param arg0
	 */
	public BadLimitException(String arg0) {
		super(arg0);
	}

}
