package lab7.driver;

import lab7.model.Cupboard;
import lab7.model.Person;

public class Driver {

	public static void main(String[] args) {
		Cupboard.init();
		
		Person someCustomer = Cupboard.login("ADAM", "ADAM123");
		
		if (someCustomer != null) {
			System.out.println("Welcome " +someCustomer.getName() +
				" you logged in successfully");
			Cupboard.listTests(someCustomer);
		} else {
			System.out.println("Sorry, access denied");
		}		
		
		someCustomer = Cupboard.login("CHAR","CHAR321");
		
		if (someCustomer != null) {
			System.out.println("Welcome " +someCustomer.getName() +
				" you logged in successfully");
			Cupboard.listTests(someCustomer);
		} else {
			System.out.println("Sorry, access denied");
		}
		
		someCustomer = Cupboard.login("ED","ED456");
		
		if (someCustomer != null) {
			System.out.println("Welcome " +someCustomer.getName() +
				" you logged in successfully");
			Cupboard.listTests(someCustomer);
		} else {
			System.out.println("Sorry, access denied");
		}
	}
}

