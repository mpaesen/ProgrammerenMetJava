package test;

import controller.Register;
import db.FileIO;
import db.Store;
import model.Customer;
import model.Employee;
import model.Product;
import model.pricing.ISalePricingStrategy;
import view.*;

/**
 * @author Erwin Aernouts & Rudy Nelen
 */


public class NextGenPOSTest 
{

	/**
	 * kassa test
	 */
	

	public static void main(String[] args) 
	{

		int scanID = 1; //ingescande produkt ID
		double aantal = 1; //aantal van het ingescande produkt
		
		
		/**
		 * Een nieuwe winkel (Store) - kassa (Register) aanmaken
		 */
		Register testRegister = new Register();
				
		/**
		 * De winkel voorzien van data (Manager, kassiers, klanten en produkten)
		 */
		
		FileIO.serializeShopStart1();
		FileIO.serializeShopStart();

		
		
		//test Print
		System.out.println("De manager van deze winkel:");
		System.out.printf("%s\n", Register.getStore().getManager());
		System.out.println("De kassiers van deze winkel:");
		for(Employee kassier : Register.getStore().getKassiers().values())
			System.out.printf("%s\n", kassier);
		System.out.println("De klanten van deze winkel:");
		for(Customer klant : Register.getStore().getCustomers().values())
			System.out.printf("%s\n", klant);
		System.out.println("De produkten verkrijgbaar in deze winkel:");
		for(Product produkt : Store.getProductCatalog().getProductCatalog().values())
					System.out.printf("%s\n", produkt);
		
		/**
		 * De Manager start het systeem
		 */

		testRegister.startRegister(Register.getStore().getManager().getPersonID());
		
		/**
		 * de Manager kan accountingAdapter en businessRules bepalen
		 */
		String[] accountingAdaptersNames = new String[] { "SpecialAccountingAdapter", "SAPAccountingAdapter" };
		String[] businessRulesNames = new String[] { "OrganisationBusinessRules", "OtherBusinessRules" };
		JFrameEnterServices serviceFrame = new JFrameEnterServices(testRegister, accountingAdaptersNames, businessRulesNames);
		serviceFrame.setVisible(true);
		serviceFrame.setAlwaysOnTop(true);
		
		// sluit het frame nadat de Services bepaald zijn (is set)
		while (!testRegister.isServicesSet())
		{}
		serviceFrame.dispose();
		
		/**
		 * De Kassier start met werken
		 * en steekt voor 100 EURO wisselgeld in de kassa
		 */
		int kassierID = 9002;
		testRegister.setKassier(kassierID);
		testRegister.setMoney(100);
		
		/**
		 * De Kassier start een verkoop
		 * door een klantenkaart in te lezen
		 */
		int klantID = 1001;
		testRegister.newSale(klantID);
		
		/**
		 * producten worden nu op 2 verschillende displays getoond
		 * eerst via Console en JOptionPane
		 * daarna via JFrame en JOptionPane
		 * en op 2 verschillende manieren ingebracht
		 */
		SaleDisplay saleDisplay = new SaleDisplay(testRegister);
		JOptionSaleDisplay frameSaleDisplay = new JOptionSaleDisplay(testRegister);
		
		/**
		 * 1) De Kassier scant de producten in 
		 * en geeft eventueel ook het aantal of het gewicht mee in
		 */
		scanID = 26179;
		aantal = 2; // in te geven aantal
		testRegister.scanProdukt(scanID, aantal);
		
		scanID = 26172;
		aantal = 1;	// default aantal
		testRegister.scanProdukt(scanID, aantal);
		
		scanID = 29602;
		aantal = 1;	// default aantal
		testRegister.scanProdukt(scanID, aantal);
		
		scanID = 28776;
		aantal = 1.21;	// in te geven gewicht (1,21 kg)
		testRegister.scanProdukt(scanID, aantal);
		
		/**
		 * 2) de kassierster geeft ook enkele producten in via JFrame
		 */
		JFrameEnterItems frame = new JFrameEnterItems(testRegister);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		
		while (scanID != 0) 
		{
			scanID = frame.getItemId();
		}
		frame.dispose();
		
		
		/**
		 * tonen van JFrame met de plugins om een discountStrategy te bepalen
		 * voor deze Sale
		 */
		String[] discountStrategiesNames = new String[Register.getStore().getDiscountStrategies().size()];
		int i = 0;
		for (ISalePricingStrategy discount : Register.getStore().getDiscountStrategies())
		{
			discountStrategiesNames[i] = discount.getClass().getName();
			i++;
		}
		JFramePlugins jframePlugins = new JFramePlugins(discountStrategiesNames, testRegister);
		jframePlugins.setVisible(true);
		jframePlugins.setAlwaysOnTop(true);
		jframePlugins.setTitle("Plugins: Discount Strategy");
		
		// sluit het frame nadat de DiscountStrategy bepaald is (is set)
		while (!testRegister.isDiscountStrategySet()){
			
		}
		jframePlugins.dispose();
		
		
		/**
		 * De Kassier sluit het scannen af,
		 * toont de totale prijs
		 * en vraagt de klant te betalen 
		 */
		testRegister.getSaleTotal();
		
		/**
		 * De Klant betaalt cash, gepast
		 */
		testRegister.cashMoney(testRegister.getSale().calculateFinalTotal());
		//test Print
		System.out.printf("\n%8.2f EURO in kassa\n", testRegister.getMoney());
		
		/**
		 * De Kassier sluit de verkoop af
		 * en print het kassaticket af en geeft het aan de klant
		 */
		testRegister.endSale();
		testRegister.printReceipt();
		
		/**
		 * De Kassier sluit de kassa af
		 */
		FileIO.serializeKassaStop();
		FileIO.serializeKassaStop1();
				
	}
	

}
