package model.pricing;

import model.Sale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CompositePricingStrategy implements ISalePricingStrategy, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract void calculateDiscount(Sale sale);
	@Override
	public abstract String getDiscountDescription();
	
	protected List<ISalePricingStrategy> pricingStrategies = new ArrayList<ISalePricingStrategy>();
	
	public void add(ISalePricingStrategy s){
		pricingStrategies.add(s);
	}
	public void remove (ISalePricingStrategy s){
		pricingStrategies.remove(s);
	}

	public void clear(){
		pricingStrategies.clear();
	}
}
