package lab5;
public class Driver {

	public static void main(String[] args) {
		Cupboard.init();
		
		Customer someCustomer = Cupboard.login("ADAM", "ADAM123");
		
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
	}
}

