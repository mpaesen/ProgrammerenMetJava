package lab3.solution.model;

import java.util.Iterator;
public class CertTest extends Test {
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
			String[] qinit = {
						"Platform independence means:",
						"*Not tied to one hardware or software architecture",
						"Needs no platform",
						"Difficult to control on a platform",
						"Nothing, just fancy term OO developers are using",
						null,
						"Which is the correct syntax:",
						"public static main(String[] argsP",
						"public static void main(String args)",
						"public main(String[] args)",
						"*public static void main(String[] args)",
						null,
						"Which of the following is a Java reserved word?",
						"*new",
						"old",
						"fast",
						"slow",
						null
						};

					int i =0;
					while(i < qinit.length){
						Question question = new Question();
						question.setText(qinit[i++]);

						String choiceText = qinit[i++];
						while(choiceText != null){
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
							choiceText = qinit[i++];
						}// end inner while loop
						addQuestion(question);
		}// end outer while loop
		return true;
	}
	public void recordResults() {
		System.out.println("Results sent to certification database");
	}
	private boolean verifyPrereqs() {
		return true;
	}
}