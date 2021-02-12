package model.pricing;

import model.Sale;

import java.io.Serializable;
import java.util.Iterator;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description = "korting in het voordeel van de klant";

	@Override
	public void calculateDiscount(Sale sale) {
		double highestDiscount = 0;
		
		for(Iterator i = pricingStrategies.iterator();i.hasNext();){
		
			ISalePricingStrategy strategy = (ISalePricingStrategy)i.next();
			strategy.calculateDiscount(sale);
			highestDiscount = Math.max(sale.getDiscount(), highestDiscount);
		}
			sale.setDiscount(highestDiscount);
			sale.setDiscountDescription(getDiscountDescription());
	}

	@Override
	public String getDiscountDescription() {
		return description ;
	}

}
