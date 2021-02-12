package lab7.solution.model;

import java.io.*;
import java.util.Iterator;
public class CertTest extends Test implements Serializable{
	public CertTest() {
	}
	public CertTest(String aText) {
		super(aText);
	}
	public CertTest(int passThreshold, int limitseconds) {
		setPassThreshold(passThreshold);
		setLimitSeconds(limitseconds);
	}
	public int computeScore() {
		int score = 0;
		Iterator itq = getQuestions().iterator();

		// While unexamined questions in test:
		while (itq.hasNext()) {
			Question question = (Question)itq.next();

			// Display text for each choice
			Iterator itc = question.getChoices().iterator();
			while (itc.hasNext()) {
				Choice choice = (Choice)itc.next();
				if (choice.isPicked() && choice.isCorrect()) {
					++score;
				}
			}
		}
		return score;
	}
	public boolean generate() {
		if(!verifyPrereqs()) {
				System.out.println("No test generated since prereq tests have not been completed");
				return false;
		}
		File file = new File(Constants.TEST_FILE_NAME);

		if (!file.canRead()) {
			System.out.println("Cannot read file " + Constants.TEST_FILE_NAME);
			System.exit(1);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String questionText = null;;
			while((questionText = reader.readLine()) != null){
				questionText = questionText.trim();
				Question question = new Question();
				question.setText(questionText);

				String choiceText = reader.readLine().trim();
				while(!choiceText.equals("null")){
					Choice choice = new Choice();
					// Is this a correct choice?
					if (choiceText.charAt(0) == '*') {
						// Set correct, strip flag char
						choice.setCorrect(true);
						choiceText = choiceText.substring(1);
					}
					choice.setText(choiceText);
					question.addChoice(choice);
					// Append this choice to current question
					choiceText = reader.readLine().trim();
				}// end inner while loop
				addQuestion(question);
			}// end outer while loop
		} catch(IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}

		return true;
	}
	public void recordResults() {
		System.out.println("Results sent to certification database");
	}
	private boolean verifyPrereqs() {
		return true;
	}
}