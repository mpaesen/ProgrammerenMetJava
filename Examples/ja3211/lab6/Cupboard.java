package lab6;
public class Cupboard {
	private static java.util.Vector testCollection = new java.util.Vector();
	private static java.util.Vector personCollection = new java.util.Vector();
	
	public static void init() {
		Person thePerson = new Customer("Adam","adam@hotmail.com");		
		thePerson.createProfile("ADAM", "ADAM123");
		
		Person anotherPerson = new Developer("Charlene","char@email.com");
		anotherPerson.createProfile("CHAR", "CHAR321");

		personCollection.add(thePerson);
		personCollection.add(anotherPerson);
		
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
	
	public static Person login(String theUserId,String thePassword) {
		Person thePerson = null;
		
		for (int index=0; index < personCollection.size(); index++) {
			thePerson = (Person) personCollection.get(index);
			if (thePerson.getProfile().getUserId().equals(theUserId)) {
				break;
			}
		}
		
		if (thePerson != null) {
			boolean loggedIn = thePerson.login(theUserId, thePassword);
			
			if (loggedIn) {
				return thePerson;
			}
		}
		
		return null;
	}
	
	public static void listTests(Person thePerson) {
		String filter = "";
		
		if (thePerson.getProfile().getPrivilege().
		                           equals(Profile.DEVELOPER)) {
			filter = Test.DEVELOPMENT;
		} else if (thePerson.getProfile().getPrivilege().
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

