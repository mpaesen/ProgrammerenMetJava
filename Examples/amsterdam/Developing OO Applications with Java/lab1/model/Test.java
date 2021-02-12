/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab1.model;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Test {
	private Question[] questions = new Question[3];
	private int counter;

	public Test(String aText) {
		System.out.println(aText);
		generate();
	}

	/**
	 * @return
	 */
	public Question[] getQuestion() {
		return questions;
	}

	/**
	 * @param questions
	 */
	public void setQuestion(Question[] questions) {
		this.questions = questions;
	}

	public void addQuestion(Question aQuestion) {
		questions[counter++] = aQuestion;
	}

	public int getQuestionCount() {
		return questions.length;
	}

	public Question getQuestion(int index) {
		return questions[index];
	}

	public void generate() {
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
	}

	protected void finalize() throws Throwable{		
		System.out.println("Finalize called on"+this);
		super.finalize();
	}
}
