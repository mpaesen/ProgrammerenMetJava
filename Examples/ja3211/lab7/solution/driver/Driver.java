package lab7.solution.driver;

import lab7.solution.model.Cupboard;
import lab7.solution.model.Person;
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
	
	Person somePerson = Cupboard.login("ADAM","ADAM123");

	if (somePerson != null) {
		System.out.println("Welcome " + somePerson.getName() +
			" you logged in successfully");
		Cupboard.listTests(somePerson);
	} else {
		System.out.println("Sorry, access denied");
	}

	somePerson = Cupboard.login("CHAR", "CHAR321");

	if (somePerson != null) {
		System.out.println("Welcome " + somePerson.getName() +
			" you logged in successfully");	
		Cupboard.listTests(somePerson);
	} else {
		System.out.println("Sorry, access denied");
	}

	somePerson = Cupboard.login("ED", "ED456");

	if (somePerson != null) {
		System.out.println("Welcome " + somePerson.getName() +
			" you logged in successfully");	
		Cupboard.listTests(somePerson);
	} else {
		System.out.println("Sorry, access denied");
	}
}
}
