package lab6.solution.model;

import java.io.Serializable;
import java.util.Iterator;
public class PracticeTest extends Test implements Serializable{
	public PracticeTest() {
		setPassThreshold(0);
		setLimitSeconds(300);
	}
	public PracticeTest(String aText) {
		super(aText);
	}
	public int computeScore(){
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
		String[] qinit = {
							"Which is correct?",
							"int a = new int(1);",
							"int a = new Integer(1);",
							"*int a = 1;",
							"Integer a = 1;",
							null,
							"J2SE stands for:",
							"Java 2 Special Edition",
							"Java 2 Service Editor",
							"Nothing. It simply stands for itself",
							"*Java 2 Standard Edition",
							null,
							"Platform independence means:",
							"*Not tied to one hardware or software architecture",
							"Needs no platform",
							"Difficult to control on a platform",
							"Only one platform can be used",
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
}