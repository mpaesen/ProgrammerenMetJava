package model.pricing;

import model.Sale;
import model.SalesLineItem;

import java.io.Serializable;

public class FridayEveningDiscount implements ISalePricingStrategy, Serializable {

	/**
	 * op vrijdagavond zijn alle produkten aan 1 EUR per stuk
	 */
	
	private static final long serialVersionUID = 1L;
	private String description = "alles aan 1 EUR";

	@Override
	public void calculateDiscount(Sale sale) {
		double discount;
		int aantalStuks=0;
		for (SalesLineItem item : sale.getSalesLineItems()) {
			aantalStuks += (int)item.getAantal();//aantal stuks wordt opgevraagd
												// bij kiloproduct wordt bijv 2kg als 2 stuks geteld 

		}
		double totalCost = sale.getTotalCost();
		
		discount = totalCost-aantalStuks*1.00; // korting = alle produkten kosten 1 EUR
		sale.setTotalCost(aantalStuks);
		
		sale.setDiscount(discount); // kortingsbedrag wordt ingevuld
		sale.setDiscountDescription(description);
	}

	@Override
	public String getDiscountDescription() {
		return description ;
	}

}
