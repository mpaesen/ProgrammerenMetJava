package lab8.model;

import lab8.model.reviewer.Reviewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Cupboard {
	private static Vector testCollection = new Vector();
	private static Vector personCollection = new Vector();
	
	public static void init() {
		String prefix = "C:\\OOPwJava\\lab8\\solution\\";
		BufferedReader personReader = null;
		try {
			//BufferedReader personReader = new BufferedReader(
			personReader = new BufferedReader(
			   new FileReader(prefix + "persons.txt"));
			String name = null;
			while ((name = personReader.readLine()) != null) {
				String eMail = personReader.readLine();
				String userId = personReader.readLine();
				String password = personReader.readLine();
				String privilege = personReader.readLine();
				Person thePerson = null;
				if (privilege.equals("USER")) {
					thePerson = new Customer(name, eMail);
				} if (privilege.equals("DEVELOPER")) {
					thePerson = new Developer(name, eMail);
				} if (privilege.equals("REVIEWER")) {
					thePerson = new Reviewer(name, eMail);
				}
				thePerson.createProfile(userId, password);
				personCollection.add(thePerson);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (personReader != null) {
					personReader.close();
				}
			} catch (IOException ioe2) {
			}	
		}
	
		BufferedReader testReader = null;
		try {
			testReader = new BufferedReader(new FileReader(prefix + "tests.txt"));
			String name = null;
			while ((name = testReader.readLine()) != null){
				String area = testReader.readLine();
				String status = testReader.readLine();
				Test theTest = new Test(name, area);
				theTest.setStatus(status);
				testCollection.add(theTest);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (testReader != null) {
					testReader.close();
				}
			} catch (IOException ioe2) {
			}	
	
		}
	/*
		Person thePerson = new Customer("Adam","adam@hotmail.com");
		thePerson.createProfile("ADAM", "ADAM123");
	
		Person anotherPerson = new Developer("Charlene","char@email.com");
		anotherPerson.createProfile("CHAR", "CHAR321");
	
		Person aReviewer = new Reviewer("Edward","Ed@ed.org");
		aReviewer.createProfile("ED","ED456");
		
		personCollection.add(thePerson);
		personCollection.add(anotherPerson);
		personCollection.add(aReviewer);
		
		Test test1 = new Test("Basic Java2 Syntax", 
			"Application Development");
		test1.setStatus(Test.DEVELOPMENT);
		
		Test test2 = new Test("Java Servlets", 
			"Application Development");
		test2.setStatus(Test.PRODUCTION);
	
		Test test3 = new Test("Java Applets", 
			"Application Development");
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
	*/
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
		} else if (thePerson.getProfile().getPrivilege().
		                                  equals(Profile.REVIEWER)) {
		    filter = "ALL";                             
		}
		                                  		
		for (int index = 0; index < testCollection.size(); index++) {
			Test theTest = (Test) testCollection.get(index);
			if (theTest.getStatus().equals(filter) ||
			                                  filter.equals("ALL")) {
				System.out.println("\t" + theTest.getIdNumber() +
					" : " + theTest.getName() + " : " + theTest.getArea());
			}
		}
	}
}

