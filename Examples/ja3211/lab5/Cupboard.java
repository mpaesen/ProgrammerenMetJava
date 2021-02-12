package lab5;
public class Cupboard {
	private static java.util.Vector testCollection = new java.util.Vector();
	private static java.util.Vector customerCollection = new java.util.Vector();
	
	public static void init() {
		Customer theCustomer = new Customer("Adam","adam@hotmail.com");		
		theCustomer.createProfile("ADAM", "ADAM123", Profile.USER);
		
		Customer anotherCustomer = new Customer("Charlene","char@email.com");
		anotherCustomer.createProfile("CHAR", "CHAR321", Profile.DEVELOPER);

		customerCollection.add(theCustomer);
		customerCollection.add(anotherCustomer);
		
		Test test1 = new Test("Basic Java2 Syntax", "Application Development");
		test1.setStatus(Test.DEVELOPMENT);

		Test test2 = new Test("Java Servlets", "Application Development");
		test2.setStatus(Test.PRODUCTION);

		Test test3 = new Test("Java Applets", "Application Development");
		test3.setStatus(Test.PRODUCTION);

		Test test4 = new Test("XML Tags","XML");
		test4.setStatus(Test.DEVELOPMENT);

		Test test5 = new Test("XML Parsers","XML");
		test5.setStatus(Test.PRODUCTION);

		Test test6 = new Test("Beginning HTML","Web Development");
		test6.setStatus(Test.PRODUCTION);
		
		
		testCollection.add(test1);
		testCollection.add(test2);
		testCollection.add(test3);
		testCollection.add(test4);
		testCollection.add(test5);
		testCollection.add(test6);
	} 
	
	public static Customer login(String theUserId,String thePassword) {
		Customer theCustomer = null;
		
		for (int index=0; index < customerCollection.size(); index++) {
			theCustomer = (Customer) customerCollection.get(index);
			if (theCustomer.getProfile().getUserId().equals(theUserId)) {
				break;
			}
		}
		
		if (theCustomer != null) {
			boolean loggedIn = theCustomer.login(theUserId, thePassword);
			
			if (loggedIn) {
				return theCustomer;
			}
		}
		
		return null;
	}
	
	public static void listTests(Customer theCustomer) {
		String filter = "";
		
		if (theCustomer.getProfile().getPrivilege().
		                           equals(Profile.DEVELOPER)) {
			filter = Test.DEVELOPMENT;
		} else if (theCustomer.getProfile().getPrivilege().
											equals(Profile.USER)) {
			filter = Test.PRODUCTION;
		}
		
		for (int index = 0; index < testCollection.size(); index++) {
			Test theTest = (Test) testCollection.get(index);
			if (theTest.getStatus().equals(filter)) {
				System.out.println("\t" + theTest.getIdNumber() +
					" : " + theTest.getName() + " : " + theTest.getArea());
			}
		}
	}
}

