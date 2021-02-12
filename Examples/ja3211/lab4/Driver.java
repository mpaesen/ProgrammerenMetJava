package lab4;
public class Driver {

	public static void main(String[] args) {
		Customer theCustomer = new Customer("Adam","adam@hotmail.com");
		
		Profile theProfile = new Profile("ADAM", "ADAM123");
		
		theCustomer.setProfile(theProfile);
		
		boolean loginSuccessful = false;
		
		loginSuccessful = theCustomer.login("ADAM", "ADAM123");
		
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
	
		
		loginSuccessful = anotherCustomer.login("CHAR", "WRONGPASSWORD");
		
		if (loginSuccessful) {
			System.out.println(anotherCustomer.getName() +
			   " logged in successfully");
		} else {
			System.out.println(anotherCustomer.getName() +
			   " did not log in successfully");
		}
	}
}

