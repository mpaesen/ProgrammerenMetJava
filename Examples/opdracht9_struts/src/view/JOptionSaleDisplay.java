package view;

import db.Store;
import model.*;

import javax.swing.*;

/**
 * @author Rudy Nelen
 */


public class JOptionSaleDisplay implements IObserver, IDisplaySale {
	
	private int itemId;
	private double amount;
	private Sale sale;
	private Product product;
	private ISubject saleData;
	
	/**
	 * deze display aanmelden als observer
	 * @param saleData
	 */
	public JOptionSaleDisplay (ISubject saleData){
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
		String lijn = "toegevoegd:";
		lijn 	+= "\nitemId " + itemId
				+ "\nproduct " + this.product
				+ "\naantal "+ amount
				+ "\neenheidsprijs " + this.product.getPrice()
				+ "\npijs "+(this.product.getPrice()*amount)
				+ "\nsubtotaal "+(sale.getTotalCost()+this.product.getPrice()*amount);
		//toon verkoopslijn op scherm
		JOptionPane.showMessageDialog(null, lijn);
	}

}
