package lab5.solution;

/**
 * Insert the type's description here.
 * Creation date: (2/27/2002 1:23:34 PM)
 * @author: ILS User
 */
public class Driver {
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	Cupboard.init();
	
	Customer someCustomer = Cupboard.login("ADAM","ADAM123");

	if (someCustomer != null) {
		System.out.println("Welcome " + someCustomer.getName() +
			" you logged in successfully");
		Cupboard.listTests(someCustomer);
	} else {
		System.out.println("Sorry, access denied");
	}

	someCustomer = Cupboard.login("CHAR", "CHAR321");

	if (someCustomer != null) {
		System.out.println("Welcome " + someCustomer.getName() +
			" you logged in successfully");	
		Cupboard.listTests(someCustomer);
	} else {
		System.out.println("Sorry, access denied");
	}
}
}
