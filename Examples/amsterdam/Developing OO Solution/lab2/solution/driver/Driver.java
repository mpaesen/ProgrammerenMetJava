package lab2.solution.driver;

import lab2.solution.model.*;

public class Driver {
	public static void displayTestProperties(Testable test) {
		System.out.println("Number of questions: " + test.getQuestionCount());
		System.out.println("\nBegin\n");
	}
	public static void main(String[] args) {
		Test myTest = null;

		if (args.length != 1) {
			  System.out.println("Please pass the test type on the command line: practice or certification");
			  System.exit(0);
			}

		System.out.println(Constants.APPNAME + " " +Constants.APPVERSION);

		if (args[0].equalsIgnoreCase("certification")) {
				myTest = new CertTest();
		}
		else if (args[0].equalsIgnoreCase("practice")) {
			myTest = new PracticeTest();
		}else{
			System.out.println("Invalid test type entered. Only PRACTICE or CERTIFICATION allowed as types");
			return;
		}

		boolean generated = myTest.generate();
		if(!generated) {
				System.out.println("Test could not be generated. Check for other details. Test system terminated");
				System.exit(0);
		}

		displayTestProperties(myTest);
		presentTest(myTest);

	}
	public static void presentTest(Testable test) {

		int counter = 1;
		char[] label = {'a','b','c','d','e','f','g','h','i','j'};

		for (int qnum = 0; qnum < test.getQuestionCount(); qnum++) {
		   Question question = test.getQuestion(qnum);
			// Display Question text
			System.out.println("\n" + (counter) + ". " + question.getText() + "\n");
			// Display text for each choice
			counter+=1;

			for (int cnum = 0; cnum < question.getCount(); cnum++) {
				Choice choice = question.getChoice(cnum);
				// Display a choice
				System.out.println("\t(" + label[cnum] + ") " + choice.getText());
			} // ends the inner for loop
		}// ends the outer for loop
	}// ends the presentTest(Test) method.
}