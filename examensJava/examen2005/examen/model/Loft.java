package model;

import exceptions.MaximumAantalKamers;

public class Loft extends Woning {
	public static final int MAX = 1;
	private final static int SUPPLEMENT = 5;
	private boolean balkon;
	private static final int EENHEID = 20;

	public Loft() {		
		this(EENHEID);
	}

	/**
	 * @param eenheidsPrijs
	 */
	private Loft(int eenheidsPrijs) {
		super(eenheidsPrijs);
	}

	/**
	 * @return Returns the balkon.
	 */
	public boolean isBalkon() {
		return balkon;
	}

	/**
	 * @param balkon
	 *            The balkon to set.
	 */
	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}

	public double berekenKostPrijs() {
		if (balkon) {
			return super.berekenKostPrijs()
					+ (super.berekenKostPrijs() * SUPPLEMENT / 100.0);
		}
		return super.berekenKostPrijs();
	}

	
	public String toString(){
		return "Deze Loft heeft "+ (balkon?"een ":"geen")+" balkon en "+super.toString();
	}
}
