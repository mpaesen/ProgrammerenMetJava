package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */


public class Sale implements Serializable
{
	private Employee kassier;
	private int kassierID;
	private Customer klant;
	private int klantID;
	private DateTime dateTime;
	private String dateString="";
	private ArrayList<SalesLineItem> salesLineItems;
	private ArrayList<TaxLineItem> taxLineItems;
	private int saleID=0;
	public static int lastSaleID;
	private String receiptLines;
	private double totalCost;
	private double totalTax;
	private double discount;
	private boolean isComplete;
	private Payment payment;
	private String discountDescription = "";
	private static final long serialVersionUID = 1L;
	
	public Sale()
	{
	}
	
	public Sale(Employee ca, Customer cu)
	{
		this.saleID = lastSaleID;
		this.saleID++;
		this.setKassier(ca);
		this.setKassierID(ca.getPersonID());
		this.setKlant(cu);
		this.setKlantID(cu.getPersonID());
		this.setDateTime(new DateTime());
		this.setSalesLineItems(new ArrayList<SalesLineItem>());
		this.setTaxLineItems(new ArrayList<TaxLineItem>());
		this.setReceiptLines(String.format("\nKassier: %s", ca) 
				+ String.format("\nAankopen van klant %d\n%s\n", 
						cu.getPersonID(), "datum en tijd " + this.getDateTime().toonHuidigeDatumEnUur())
				+ String.format("\n%-8s %-30s %12s %14s %7s %10s\n", 
						"Produkt", "Beschrijving", "Hoeveelheid", "Eenheidsprijs", "Prijs", "Subtotaal"));
		this.setTotalCost(0);
		this.setTotalTax(0);
		this.setDiscount(0);
		this.setIsComplete(false);
		this.setPayment(new Payment(0));
		this.setDateString(this.getDateTime().toonHuidigeDatumEnUur());
		
	}

	public void scanProdukt(Product prod, double amount) 
	{
		SalesLineItem verkoopProdukt = new SalesLineItem(prod, amount, this.saleID);
		this.salesLineItems.add(verkoopProdukt);
		
		TaxLineItem verkoopProduktTax = new TaxLineItem(prod, amount);
		this.taxLineItems.add(verkoopProduktTax);
		
		//voegt toe aan subtotaal
		addToTotal(verkoopProdukt.getSubTotal());
		addToTaxTotal(verkoopProduktTax.getSubTaxTotal());
		//OUDthis.setTotalTax(verkoopProduktTax.getTaxAmount());
		
		//tekstlijn toevoegen aan String voor kassaticket
		setReceiptLines(getReceiptLines() + String.format("%-8d %-30s %12.2f %14.2f %7.2f %10.2f\n", 
						prod.getProductID(), prod, amount, prod.getPrice(), verkoopProdukt.getSubTotal(), getTotalCost()));
	}
	
	
	public void addTotalLine()
	{
		//totaallijn toevoegen aan String voor kassaticket
		this.setReceiptLines(this.getReceiptLines() + 
					String.format("\nTotaal:     %8.2f EURO (excl. btw)" +
								  "\nBTW:        %8.2f EURO" +
								  "\nKorting:    %8.2f EURO %s" +
								  "\nTe betalen: %8.2f EURO",
							getTotalCost(), getTotalTax(), getDiscount(), getDiscountDescription(), calculateFinalTotal()));
	}
	
	/**
	 * bereken het eindtotaal zonder tax
	 * @param d
	 */
	
	public void addToTotal(double d)
	{
		this.totalCost += d;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	/**
	 * berekening van het eindbedrag dat de klant uiteindelijk moet betalen
	 * @return
	 */
	public double calculateFinalTotal(){
		return totalCost + totalTax - discount;
	}
	
	/**
	 * bereken het totaal van de taxen
	 * @param subTaxTotal
	 */
	private void addToTaxTotal(double subTaxTotal) {

		this.totalTax += subTaxTotal;
	}

	
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public DateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(DateTime value) {
		dateTime = value;
	}


	public void setKassier(Employee kassier) {
		this.kassier = kassier;
		this.kassierID = kassier.getPersonID();
	}
	public Employee getKassier() {
		return kassier;
	}


	public void setKlant(Customer klant) {
		this.klant = klant;
		this.setKlantID(klant.getPersonID());
	}
	public Customer getKlant() {
		return klant;
	}

	public void setReceiptLines(String receiptLines) {
		this.receiptLines = receiptLines;
	}
	public String getReceiptLines() {
		return receiptLines;
	}

	public void setSalesLineItems(ArrayList<SalesLineItem> salesLineItems) {
		this.salesLineItems = salesLineItems;
	}
	public ArrayList<SalesLineItem> getSalesLineItems() {
		return salesLineItems;
	}

	public void setTaxLineItems(ArrayList<TaxLineItem> taxLineItems) {
		this.taxLineItems = taxLineItems;
	}
	public ArrayList<TaxLineItem> getTaxLineItems() {
		return taxLineItems;
	}

	public boolean isIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean value) {
		isComplete = value;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}
	@Override
	public String toString()
	{
		return String.format("Aankopen van klant %d\n%s", 
				this.getKlant().getPersonID(), this.getDateTime()/*.getDatumtijd().toLocaleString()*/);
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscountDescription(String description){
		this.discountDescription = description;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public int getKlantID() {
		return klantID;
	}

	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}

	public int getKassierID() {
		return kassierID;
	}

	public void setKassierID(int kassierID) {
		this.kassierID = kassierID;
	}
	
}