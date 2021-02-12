package model;

import java.io.Serializable;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */


public class SalesLineItem implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int salesLineID;
	private double aantal;
	private double subTotal;
	private int productID;
	private int saleID;
	
	
	public SalesLineItem()
	{
	
	}

	public SalesLineItem(Product prod, double aantal, int saleID)
	{
		this.setProductID(prod.getProductID());
		this.setAantal(aantal);
		this.setSubTotal(prod.getPrice() * aantal);
		this.saleID = saleID;
	}
	
	public void setAantal(double aantal) {
		this.aantal = aantal;
	}

	public double getAantal() {
		return aantal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getSalesLineID() {
		return salesLineID;
	}

	public void setSalesLineID(int salesLineID) {
		this.salesLineID = salesLineID;
	}
	

}