package model;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * @author Erwin Aernouts
 */


public class ProductCatalog implements Serializable
{
	private TreeMap<Integer, Product> productCatalog = new TreeMap<Integer, Product>();
	private static final long serialVersionUID = 1L;
	
	public ProductCatalog()
	{
		productCatalog = new TreeMap<Integer, Product>();
	}
	
	public ProductCatalog(TreeMap<Integer, Product> products)
	{
		productCatalog = products;
	}
	
	public void setProductCatalog(TreeMap<Integer, Product> productCatalogn) 
	{
		this.productCatalog = productCatalogn;
	}

	public TreeMap<Integer, Product> getProductCatalog() 
	{
		return this.productCatalog;
	}
}
