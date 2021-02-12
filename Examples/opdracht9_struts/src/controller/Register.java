package controller;

import db.Store;
import model.*;
import model.pricing.ISalePricingStrategy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */

public class Register implements Serializable, ISubject
{
	private static Store store = Store.getInstance();
	private Employee kassier;
	private double money;
	private Sale sale;
	private static final long serialVersionUID = 1L;
	private int itemId;
	private double amount;
	
	private boolean servicesSet = false;
	private ISalePricingStrategy discountStrategy;
	private boolean discountStrategySet = false;
	
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();

	public Register()
	{
		this.setKassier(new Employee());
		this.setMoney(0);
		this.setSale(null);
	}
	
	public void startRegister(int id)
	{
		if (id == store.getManager().getPersonID())
			System.out.println("\nStart OK");
	}
	
	public void newSale(int id) 
	{
		this.setDiscountStrategySet(false);
		Employee ca = this.getKassier();
		Customer cu = getStore().getCustomers().get(id);
		this.setSale(new Sale(ca, cu));
	
		//testprint
		System.out.printf("\nKassier: %s\n%s\n\n", ca, this.getSale());
	}

	public void scanProdukt(int id, double amount) 
	{
		
		//alle observers worden op de hoogte gebracht van het nieuwe item dat werd toegevoegd
		
		this.itemId = id;
		this.amount = amount;
		SaleChanged();
		
		//zoekt produktbeschrijving op
		Product ditProduct = Store.getProductCatalog().getProductCatalog().get(id);
		
		//werk verder af in expert Sale
		this.getSale().scanProdukt(ditProduct, amount);

	}

	

	public void getSaleTotal() 
	{
		getDiscountStrategy().calculateDiscount(this.getSale());
		this.getSale().addTotalLine();
		
		//toon totaal en inbegrepen btw op scherm
		System.out.printf("\nTotaal:     %8.2f EURO (excl.btw)" +
						  "\nBTW:        %8.2f EURO" +
						  "\nKorting:    %8.2f EURO %s" + 
						  "\nTe betalen: %8.2f EURO",
						this.getSale().getTotalCost(), getSale().getTotalTax(), getSale().getDiscount(),getDiscountStrategy().getDiscountDescription(), getSale().calculateFinalTotal());
	}

	public void cashMoney(double cash) 
	{
		// De kassier steekt het geld in de kassa
		this.setMoney(this.getMoney() + cash);
		this.sale.getPayment().setAmount(cash);
	}

	public void endSale() 
	{
		// log completed sale
		getStore().logSale(this.getSale());
		
		// send sale and payment info to external Accounting system and inventory
		Store.getServicesFactory().getAccountingAdapter().postReceivable(sale.getPayment());
		Store.getServicesFactory().getAccountingAdapter().postSale(sale);
	}
	
	public void printReceipt()
	{
		//kassaticket afprinten		
		System.out.println(this.getSale().getReceiptLines());
	}

	public static void setStore(Store storen) {
		store = storen;
	}

	public static Store getStore() {
		return store;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setKassier(int kassierID) {
		this.kassier = getStore().getKassiers().get(kassierID);
	}

	public void setKassier(Employee kassier) {
		this.kassier = kassier;
	}

	public Employee getKassier() {
		return kassier;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Sale getSale() {
		return sale;
	}

	/**
	 * registreren van een observer
	 */

	@Override
	public void registerObserver(IObserver o) {
		observers.add(o);
		
	}
	/**
	 * verwijderen van observer
	 */

	@Override
	public void removeObserver(IObserver o) {
		int i = observers.indexOf(o);
		if (i>=0){
			observers.remove(i);			
		}
	}
	
	/**
	 * alle observers worden op de hoogte gebracht
	 * en de parameters itemId en amount worden meegegeven
	 */
	
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			IObserver observer = (IObserver)observers.get(i);
			observer.update(this.itemId, this.amount, this.sale);
		}
	}
	
	/**
	 * bij toevoegen van een salesLineItem, worden de observers hiervan op
	 * de hoogte gebracht
	 */
	private void SaleChanged() {
		notifyObservers();		
	}
	
	public void setServicesSet(boolean servicesSet) {
		this.servicesSet = servicesSet;
	}

	public boolean isServicesSet() {
		return servicesSet;
	}

	/**
	 * soort strategy wordt gezet
	 * @param discountStrategy
	 */
	public void setDiscountStrategy(ISalePricingStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	
	public ISalePricingStrategy getDiscountStrategy() {
		return discountStrategy;
	}

	public void setDiscountStrategySet(boolean discountStrategySet) {
		this.discountStrategySet = discountStrategySet;
	}

	public boolean isDiscountStrategySet() {
		return discountStrategySet;
	}

	
	

}