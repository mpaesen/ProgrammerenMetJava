package model.pricing;

import model.Sale;

import java.io.Serializable;

/**
 * @author Rudy Nelen & Erwin Aernouts
 */


public class MondaysDiscount implements ISalePricingStrategy, Serializable
{
	private static final long serialVersionUID = 1L;
	private String description = "elke maandag -20%";

	/**
	 * elke maandag zijn alle producten aan -20%
	 */
	@Override
	public void calculateDiscount(Sale sale) {
		double discount;
		discount = sale.getTotalCost()*0.2; // korting = 20% van het totaalbedrag
		sale.setDiscount(discount); // kortingsbedrag wordt ingevuld
		sale.setDiscountDescription(description);
	}

	@Override
	public String getDiscountDescription() {
		
		return description;
	}
	
	
	

}
