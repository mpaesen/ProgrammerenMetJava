/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab2.model;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CertTest extends Test {

	/**
	 * 
	 */
	public CertTest() {
		super();

	}

	/**
	 * @param aText
	 */
	public CertTest(String aText) {
		super(aText);

	}

	/* (non-Javadoc)
	 * @see lab2.model.Test#generate()
	 */
	public boolean generate() {
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

	public static void main(String[] args) {
	}
}
