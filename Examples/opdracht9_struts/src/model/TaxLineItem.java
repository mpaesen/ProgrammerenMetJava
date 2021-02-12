package model;

import java.io.Serializable;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */


public class TaxLineItem implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int percentage;
	private double subTaxTotal;
	
	public TaxLineItem(Product prod, double aantal)//(int taxtype, double prodprice, double prodamount)
	{

		if(prod.getTaxType() == 1){
			this.setSubTaxTotal(aantal*prod.getPrice()*0.21);
		}
		else{
			this.setPercentage(6);
			this.setSubTaxTotal(aantal*prod.getPrice()*this.getPercentage()/100);
		}
	}
	
	
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int value) {
		percentage = value;
	}

	
	public void setSubTaxTotal(double subTaxTotal) {
		this.subTaxTotal = subTaxTotal;

	}

	public double getSubTaxTotal() {
		return subTaxTotal;
	}
	
	

}
