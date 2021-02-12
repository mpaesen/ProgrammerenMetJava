/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab3.model;
import java.util.Iterator;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CertTest extends Test {


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
		
		
		String[] qinit =
			{
				"Platform independence means:",
				"*Not tied to one hardware or software architecture",
				"Needs no platform",
				"Difficult to control on a platform",
				"Nothing, just a fancy term OO developers are using",
				null,
				"Which is the correct syntax for a main method?",
				"public static main(String[] args)",
				"public static void main(String args)",
				"public main(String[] args)",
				"*public static void main(String[] args)",
				null,
				"Which of the following is a Java reserved word?",
				"*new",
				"old",
				"fast",
				"slow",
				null };
		int i = 0;
		while (i < qinit.length) {
			Question question = new Question();
			question.setText(qinit[i++]);
			String choiceText = qinit[i++];

			while (choiceText != null) {
				Choice choice = new Choice();
				if (choiceText.charAt(0) == '*') {
					choice.setCorrect(true);
					choiceText = choiceText.substring(1);
				}
				choice.setText(choiceText);

				question.addChoice(choice);
				choiceText = qinit[i++];
			}

			addQuestion(question);
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
