package lab6.driver;

import lab6.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	protected static BufferedReader in =
		new BufferedReader(new InputStreamReader(System.in));
			
	public static void main(String[] args) {

		Testable myTest = null;
		System.out.println(Constants.APPNAME+" "+ Constants.APPVERSION);
		try{
		
		myTest = Test.load(Constants.PERSIST_FILE_NAME);
		
		displayTestProperties(myTest);

		presentTest(myTest);
		if (myTest instanceof CertTest){
			((CertTest)myTest).recordResults();
		}
		presentResults(myTest);
		}catch(TestLoadException e){
			System.out.println(e.getMessage());
			System.out.println("Did you run PersistTest?");			
		}
	}

	public static void presentTest(Testable test) {
		int correctIndex = 0;
		boolean isPractice = false;
		int counter = 1;
		char[] label = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };

		if (test instanceof PracticeTest) {
			isPractice = true;
		}

		for (int qnum = 0; qnum < test.getQuestionCount(); qnum++) {
			Question question = test.getQuestion(qnum);
			// Display Question text
			System.out.println(
				"\n" + (counter) + ". " + question.getText() + "\n");
			// Display text for each choice
			counter += 1;

			for (int cnum = 0; cnum < question.getCount(); cnum++) {
				Choice choice = question.getChoice(cnum);
				// Display a choice
				if (choice.isCorrect()) {
					correctIndex = cnum;
				}
				System.out.println(
					"\t(" + label[cnum] + ") " + choice.getText());
			} // ends the inner for loop
			System.out.print("\nAnswer > ");
			String inbuf = acceptConsole();

			if (isPractice) {
				System.out.println("Correct answer is " + label[correctIndex]);
				correctIndex = 0;
			}
			System.out.println();
			Choice choice = null;
			if (inbuf.length() > 0) {
				char answer = inbuf.charAt(0);
				for (int i = 0; i < label.length; i++) {
					if (answer == label[i]) {
						if (i < question.getCount()) {
							choice = question.getChoice(i);
							break;
						}
					}
				}
			}
			if (choice != null) {
				choice.setPicked(true);
			}
		} // ends the outer for loop
	} // ends the presentTest(Test) method.

	public static void displayTestProperties(Testable test) {
		System.out.println("Number of questions: " + test.getQuestionCount());
		System.out.println("Time limit in seconds: " + test.getLimitSeconds());
		System.out.println(
			"You must answer "
				+ test.getPassThreshold()
				+ " questions correctly to pass");
		System.out.println("\nBegin\n");
	}
	
	protected static String acceptConsole() {
		String inBuf = null;
		try {
			inBuf = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return inBuf;
	}


	public static void presentResults(Testable test) {
		int score = test.computeScore();
		int pass = test.getPassThreshold();
		System.out.println(
			"You picked " + score + " correct out of " + test.getQuestionCount() + " possible.");

		if (!(test instanceof PracticeTest)) {
			System.out.println("You needed " + pass + " to pass.\n");
			if (score >= pass) {
				System.out.println("You PASSED. Congratulations!");
			} else {
				System.out.println("Sorry, you didn't pass.");
			}
		}
	}
}