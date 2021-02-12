package model.pricing;

import model.Sale;

import java.io.Serializable;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */

public class NoDiscount implements ISalePricingStrategy, Serializable
{
	private static final long serialVersionUID = 1L;
	private String description = "geen korting: 0%";
	
	/**
	 * er wordt geen korting gegeven
	 */
	@Override
	public void calculateDiscount(Sale sale) 
	{
		double discount;
		discount = sale.getTotalCost()*0; // korting = 0% van het totaalbedrag
		sale.setDiscount(discount); // kortingsbedrag wordt ingevuld
		sale.setDiscountDescription(description);
	}

	@Override
	public String getDiscountDescription() 
	{
		return description;
	}

}
