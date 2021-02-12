/**
 * 
 */
package model.vaartuigen;

import model.VervoerMiddel;
import utilities.Category;

import java.math.BigDecimal;


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
