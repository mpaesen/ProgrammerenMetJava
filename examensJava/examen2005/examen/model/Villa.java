/**
 * 
 */
package model;

/**
 * @author bempn
 * 
 */
public class Villa extends Woning {
	private boolean tuin;

	private final static int SUPPLEMENT = 10;
	private static final int EENHEID = 15;
	public static final int MAX = 8;

	/**
	 * @return Returns the tuin.
	 */
	public boolean isTuin() {
		return tuin;
	}

	/**
	 * @param tuin
	 *            The tuin to set.
	 */
	public void setTuin(boolean tuin) {
		this.tuin = tuin;
	}

	public double berekenKostPrijs() {
		if (tuin) {
			return super.berekenKostPrijs()
					+ (super.berekenKostPrijs() * SUPPLEMENT / 100.0);
		}
		return super.berekenKostPrijs();
	}

	public Villa() {
		this(EENHEID);
	}

	private Villa(int eenheidsPrijs) {
		super(eenheidsPrijs);
	}
	
	public String toString(){
		return "Deze Villa heeft "+ (tuin?"een":"geen")+" tuin "+super.toString();
	}
}
