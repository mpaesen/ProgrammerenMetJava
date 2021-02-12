/**
 * 
 */
package model.vaartuigen;

import java.math.BigDecimal;

import utilities.Category;

import model.VervoerMiddel;


/**
 * @author WEBINST
 *
 */
public abstract class Vaartuig extends VervoerMiddel {

	/**
	 * @param cat
	 * @param waarde
	 */
	public Vaartuig(Category cat, BigDecimal waarde) {
		super(cat, waarde);
	}
}
