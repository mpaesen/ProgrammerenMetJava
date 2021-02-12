package model.pricing;

import model.Sale;

import java.io.Serializable;
import java.util.Iterator;

public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description = "korting in het voordeel van de winkel";

	@Override
	public void calculateDiscount(Sale sale) {
		double lowestDiscount = 0;
		
		for(Iterator i = pricingStrategies.iterator();i.hasNext();){
		
			ISalePricingStrategy strategy = (ISalePricingStrategy)i.next();
			strategy.calculateDiscount(sale);
			lowestDiscount = Math.min(sale.getDiscount(), lowestDiscount);
		}
			sale.setDiscount(lowestDiscount);
			sale.setDiscountDescription(getDiscountDescription());
	}

	@Override
	public String getDiscountDescription() {
		return description ;
	}
}
