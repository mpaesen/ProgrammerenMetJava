/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab7.model;

import java.io.*;
import java.util.Iterator;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CertTest extends Test implements Serializable {

	public CertTest(int passThreshold, int limitSeconds) {
		super();
		setLimitSeconds(limitSeconds);
		setPassThreshold(passThreshold);
	}

	public boolean generate() {

		if (!verifyPrereqs()) {
			System.out.println(
				"No test generated since prereq tests "
					+ "have not been completed");
			return false;
		}
		File file = new File(Constants.TEST_FILE_NAME);
		if (!file.canRead()) {
			System.out.println("Cannot read file " + Constants.TEST_FILE_NAME);
			System.exit(1);
		}

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));			

			String questionText = null;
			while ((questionText = reader.readLine()) != null) {

				
				questionText.trim();

				Question question = new Question();
				question.setText(questionText);
				String choiceText = reader.readLine().trim();

				while (!choiceText.equals("null")) {
					Choice choice = new Choice();
					if (choiceText.charAt(0) == '*') {
						choice.setCorrect(true);
						choiceText = choiceText.substring(1);
					}
					choice.setText(choiceText);
					question.addChoice(choice);
					choiceText = reader.readLine().trim();
				}

				addQuestion(question);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return true;
	}

	public int computeScore() {
		int score = 0;
		Iterator itq = getQuestions().iterator();
		while (itq.hasNext()) {
			Question question = (Question) itq.next();
			Iterator itc = question.getChoices().iterator();
			while (itc.hasNext()) {
				Choice choice = (Choice) itc.next();
				if (choice.isCorrect() && choice.isPicked()) {
					++score;
				}
			}
		}
		return score;
	}

	public void recordResults() {
		System.out.println("Results sent to certification database");
	}

	private boolean verifyPrereqs() {
		return true;
	}
}
