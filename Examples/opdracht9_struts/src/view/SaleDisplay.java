package view;

import db.Store;
import model.*;

/**
 * @author Rudy Nelen
 */


public class SaleDisplay implements IObserver, IDisplaySale {
	
	private int itemId;
	private double amount;
	private Sale sale;
	private Product product;
	private ISubject saleData;
	
	/**
	 * deze display aanmelden als observer
	 * @param saleData
	 */
	public SaleDisplay (ISubject saleData){
		this.saleData = saleData;
		saleData.registerObserver(this);
	}

	@Override
	public void update(int itemId, double amount, Sale sale) {
		this.itemId = itemId;
		this.amount = amount;
		this.sale = sale;
		
		//zoekt produktbeschrijving op
		this.product = Store.getProductCatalog().getProductCatalog().get(itemId);

		
		displaySale();
	}

	@Override
	public void displaySale() {
		//toon verkoopslijn op scherm
		System.out.printf("%-7d %-30s %7.2f %7.2f %7.2f %8.2f toegevoegd\n", 
				itemId, this.product, amount, this.product.getPrice(), (this.product.getPrice()*amount), sale.getTotalCost()+this.product.getPrice()*amount);				
	}

}
