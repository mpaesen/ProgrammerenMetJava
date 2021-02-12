package model.pricing;

import model.Sale;

/**
 * @author Rudy Nelen & Erwin Aernouts
 */


public interface ISalePricingStrategy {
	
	public void calculateDiscount(Sale sale);
	
	public String getDiscountDescription();
	
	
}
