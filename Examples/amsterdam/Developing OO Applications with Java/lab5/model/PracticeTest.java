/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab5.model;
import java.io.Serializable;
import java.util.Iterator;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PracticeTest extends Test implements Serializable {

	/**
	 * 
	 */
	public PracticeTest() {
		super();
		setLimitSeconds(300);
		setPassThreshold(0);
	}

	/**
	 * @param aText
	 */
	public PracticeTest(String aText) {
		super(aText);
		setLimitSeconds(300);
		setPassThreshold(0);
	}

	public boolean generate() {
		String[] qinit =
			{
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
}
