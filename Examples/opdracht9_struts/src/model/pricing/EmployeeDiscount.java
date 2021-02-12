package model.pricing;

import model.Sale;

import java.io.Serializable;

/**
 * @author Rudy Nelen
 */


public class EmployeeDiscount implements ISalePricingStrategy, Serializable
{
	private static final long serialVersionUID = 1L;
	private String description = "werknemerskorting -10%";

	/**
	 * employees krijgen -10%
	 */
	@Override
	public void calculateDiscount(Sale sale) {
		double discount;
		discount = sale.getTotalCost()*0.1; // korting = 10% van het totaalbedrag
		sale.setDiscount(discount); // kortingsbedrag wordt ingevuld
		sale.setDiscountDescription(description);
	}

	@Override
	public String getDiscountDescription() {
		
		return description;
	}
	
	

}
