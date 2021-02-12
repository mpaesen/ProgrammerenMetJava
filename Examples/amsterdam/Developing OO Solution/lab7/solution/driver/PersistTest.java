package lab7.solution.driver;

import lab7.solution.model.CertTest;
import lab7.solution.model.Constants;
import lab7.solution.model.PracticeTest;
import lab7.solution.model.Test;
public class PersistTest {
	public static void main(String[] args) {
		Test test = null;
		if (args.length != 1) {
			System.out.println("Please pass the test type on the command line: practice or certification");
		 	System.exit(1);
		}

		if (args[0].equalsIgnoreCase("certification")) {
			 // **** Phase I: generate a certification test for an exam ****
		  	test = new CertTest(2,30);
		 }
		 else if (args[0].equalsIgnoreCase("practice")) {
			 // **** Phase I: create a practice test for an exam ****
			// Generate a test
			test = new PracticeTest();
		 }
		 else {
			System.out.println("Invalid test type entered. Only PRACTICE or CERTIFICATION allowed as types");
			return;
		 }

		test.generate();
		// Serialize test to a well-known file
		test.save(Constants.PERSIST_FILE_NAME);
		System.out.println("Test generated to file \"" + Constants.PERSIST_FILE_NAME + "\"");
	}
}