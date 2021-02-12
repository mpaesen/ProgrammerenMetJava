package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Erwin Aernouts
 */


public class Product implements Comparable<model.Product>, Serializable
{
	private int productID;
	private String description;
	private double price;
	private int taxType = 1;
	private int aantal;
	private static final long serialVersionUID = 1L;
	
	DecimalFormat df = new DecimalFormat ("0.00");
	
	public Product()
	{
		this.productID = 0;
		this.description = "";
		this.price = 0;
		this.taxType = 0;
		this.aantal = 0;
	}
	
	public Product(int ID, String descr, double pri, int taxT, int tal )
	{
		this.setProductID(ID);
		this.setDescription(descr);
		this.setPrice(pri);
		this.setTaxType(taxT);
		this.setAantal(tal);
	}
	
	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTaxType() {
		return this.taxType;
	}

	public void setTaxType(int taxType) {
		this.taxType = taxType;
	}

	public int getAantal() {
		return this.aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	@Override
	public int compareTo(Product o) {
		if (this.productID == o.productID)
			return 0;
		else if (this.productID < o.productID)
			return -1;
		else
			return 1;
	}
	
	public String toString()
	{
		return this.getDescription();
	}
	
	public String toFullString(){
		String productOmschrijving = "";
		productOmschrijving += this.getProductID() + "\t"
							+ this.getDescription() + "\t"
							+ df.format (this.getPrice()) + "\t"
							+ this.getAantal() + "\t\n";
		return productOmschrijving;
	}
}