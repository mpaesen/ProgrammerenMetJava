package test;

import database.dao.DAOCustomer;

import java.util.Random;

public class CustomerFactory {
	private static final String NAMES[] = {"Belgacom", "Electrabel", "NMBS", "De Lijn", "MIVB", "GroepT"};
	private static final String ADDRESSES[] = {"Leuvensesteenweg", "Tessenstraat", "Brusselsestraat", "Mechelsestraat", "Diestsestraat"};
	private static final String TELEPHONES[] = {"123","456","789","147","258","369","987","654","321"};
	private static final String EMAILS[]={"a@b.com","c@d.com","e@f.com","g@h.com","i@j.com"};
	private static final String CONTACT_PERSONS[]={"Mark", "Jef", "Robert", "Mathy", "Chris", "Charlotte"};
	private static  int number = 1;
	
	public static DAOCustomer getCustomer(Random rand){
		DAOCustomer customer= new DAOCustomer();
			customer.setName(NAMES[rand.nextInt(NAMES.length)]);
			customer.setAddress(ADDRESSES[rand.nextInt(ADDRESSES.length)]);
			customer.setTelephone(TELEPHONES[rand.nextInt(TELEPHONES.length)]);
			customer.setEmail(EMAILS[rand.nextInt(EMAILS.length)]);
			customer.setContactPersoon(CONTACT_PERSONS[rand.nextInt(CONTACT_PERSONS.length)]);
			customer.setNumber(number++);
			return customer;
	}

}
