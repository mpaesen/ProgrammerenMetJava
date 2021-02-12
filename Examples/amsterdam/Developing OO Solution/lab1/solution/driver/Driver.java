package lab1.solution.driver;

import lab1.solution.model.Choice;
import lab1.solution.model.Question;
import lab1.solution.model.Test;

import java.util.Properties;

public class Driver {
	public static void main(String[] args) {

		Properties props = System.getProperties();
		props.list(System.out);

		Test test = new Test("DEDS Version 1.0 Java Certification Test");
		presentTest(test);

		test = null;
	 	// Request GC
  		System.gc();
  		System.out.println("Requested gc");
	}
	public static void presentTest(Test test) {

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