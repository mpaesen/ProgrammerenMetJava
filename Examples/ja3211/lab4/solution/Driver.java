package lab4.solution;

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
	Customer theCustomer = new Customer("Adam","adam@hotmail.com");

	Profile theProfile = new Profile("ADAM", "ADAM123");

	theCustomer.setProfile(theProfile);

	boolean loginSuccessful = false;
	loginSuccessful = theCustomer.login("ADAM","ADAM123");

	if (loginSuccessful) {
		System.out.println(theCustomer.getName() +
			" logged in successfully");	
	} else {
		System.out.println(theCustomer.getName() +
			" did not log in successfully");
	}

	Customer anotherCustomer = new Customer("Charlene","char@email.com");

	Profile anotherProfile = new Profile("CHAR", "CHAR321");

	anotherCustomer.setProfile(anotherProfile);

	loginSuccessful = anotherCustomer.login("CHAR","WRONGPASSWORD");

	if (loginSuccessful) {
		System.out.println(anotherCustomer.getName() +
			" logged in successfully");	
	} else {
		System.out.println(anotherCustomer.getName() +
			" did not log in successfully");
	}
}
}
