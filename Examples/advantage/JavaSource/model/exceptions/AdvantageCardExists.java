/*
 * Created on Feb 17, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.exceptions;

import model.AdvantageCard;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdvantageCardExists extends Exception {
	private AdvantageCard advantageCard;


	/**
	 * Gets the advantageCard
	 * @return Returns a String
	 */
	public AdvantageCard getAdvantageCard() {
		return advantageCard;
	}
	
	/**
	 * Sets the advantageCard
	 * @param advantageCard The advantageCard to set
	 */
	private void setAdvantageCard(AdvantageCard advantageCard) {
		this.advantageCard = advantageCard;
	}
	/**
	 * 
	 */
	public AdvantageCardExists() {
		this("AdvantageCard not found");
	}

	/**
	 * @param arg0
	 */
	public AdvantageCardExists(String arg0) {
		super("AdvantageCard "+arg0+" not found");
		setAdvantageCard(null);
	}
	/**
	 * @param arg0
	 */
	public AdvantageCardExists(String arg0, AdvantageCard advantageCard) {
		super("AdvantageCard "+arg0+" not found");
		setAdvantageCard(advantageCard);
	}

}
