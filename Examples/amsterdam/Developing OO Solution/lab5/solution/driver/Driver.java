package lab5.solution.driver;

import lab5.solution.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	protected static String acceptConsole() {
		String inbuf = null;
		try {
			inbuf = in.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return inbuf;
	}
	public static void displayTestProperties(Testable test) {
		System.out.println("Number of questions: " + test.getQuestionCount());
		System.out.println("Time limit in seconds: " + test.getLimitSeconds());
		System.out.println("You must answer "  + test.getPassThreshold() + " questions correctly to pass");
		System.out.println("\nBegin\n");
	}
	public static void main(String[] args) {
		System.out.println(Constants.APPNAME + " " +Constants.APPVERSION);

		try{
			Test myTest = null;
			myTest = Test.load(Constants.PERSIST_FILE_NAME);

			displayTestProperties(myTest);
			presentTest(myTest);

			if(myTest instanceof CertTest) {
				((CertTest) myTest).recordResults();
			}
			presentResults(myTest);
		}catch(TestLoadException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Did you run PersistTest?");
		}
	}
	public static void presentResults(Testable test) {
		// Score test
		int score = test.computeScore();

		// Display results
		int pass = test.getPassThreshold();
		System.out.print("\nYou picked " + score + " correct ");
		System.out.println("out of " + test.getQuestionCount() + " possible.");
		if (!(test instanceof PracticeTest)) {
			System.out.println("You needed " + pass + " to pass.\n");
			if (score >= pass) {
				System.out.println("You PASSED. Congratulations!");
			} else {
					System.out.println("Sorry, you didn't pass.");
			}
		}
	}
	public static void presentTest(Testable test) {
		int correctIndex = 0;
		boolean isPractice = false;
		if(test instanceof PracticeTest) {
			isPractice = true;
		}

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
				if(choice.isCorrect()) {
					correctIndex = cnum;
				}
				// Display a choice
				System.out.println("\t(" + label[cnum] + ") " + choice.getText());
			} // ends the inner for loop
			// Prompt for answer
			System.out.print("\nAnswer > ");
			String inbuf = acceptConsole();

			if (isPractice)  {
				System.out.println("Correct answer is " + label[correctIndex]);
				correctIndex = 0;
				}

			System.out.println();
			// Process answer, if any
			Choice choice = null; // Assume invalid answer
			if (inbuf.length() > 0) {
				// Find index of response
				char answer = inbuf.charAt(0);
				for (int i = 0; i < label.length; i++) {
					// If this was the response:
					if (answer == label[i]) {
						if (i < question.getCount()) {
							choice = question.getChoice(i);
							break;
						}
					}
				}
			}
			// If user choice, pick it.
			if (choice != null) {
				choice.setPicked(true);
			}
		}// ends the outer for loop
	}// ends the presentTest(Test) method.
}