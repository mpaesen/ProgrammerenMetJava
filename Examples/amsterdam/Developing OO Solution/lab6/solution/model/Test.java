package lab6.solution.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Test implements Testable, Serializable{
	private int limitSeconds;
	private int passThreshold;
	private List questions;


	public Test() {
		questions = new ArrayList();
	}
	public Test(String aText) {
		System.out.println(aText);
		generate();
	}
	public static Test load(String fileName) throws TestLoadException{
		Test test = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
			test = (Test) is.readObject();
		} catch (Exception ex) {
		  throw new TestLoadException("Could not load test.");
		}
		return test;
	}
	public void addQuestion(Question aQuestion) {
		questions.add(aQuestion);
	}
	public abstract int computeScore();
	protected void finalize() {
		System.out.println("Finalize called on " + this);
	}
	public abstract boolean generate(); /*{
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
	} */
	public int getLimitSeconds() {
		return limitSeconds;
	}
	public int getPassThreshold() {
		return passThreshold;
	}
	public int getQuestionCount() {
		return questions.size();
	}
	public List getQuestions() {
		return questions;
	}
	public Question getQuestion(int index) {
		if(index >= questions.size()) {
			return null;
		}
		return (Question)questions.get(index);
	}
	public void setLimitSeconds(int newLimitSeconds) {
		limitSeconds = newLimitSeconds;
	}
	public void setPassThreshold(int newPassThreshold) {
		passThreshold = newPassThreshold;
	}
	public void setQuestions(List newQuestions) {
		questions = newQuestions;
	}
	public void save(String fileName) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(this);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}