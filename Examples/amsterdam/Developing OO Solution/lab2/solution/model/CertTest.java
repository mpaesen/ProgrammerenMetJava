package lab2.solution.model;
public class CertTest extends Test {
	public CertTest() {
	}
	public CertTest(String aText) {
		super(aText);
	}
	public boolean generate() {
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
}