/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab3.model;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class Test implements Testable {
	private List questions;
	private int limitSeconds;
	private int passThreshold;

	public Test() {
		super();
		questions = new ArrayList();
	}

	public Test(String aText) {
		this();
		System.out.println(aText);
	}

	/**
	 * @return
	 */
	public List getQuestions() {
		return questions;
	}

	/**
	 * @param questions
	 */
	public void setQuestions(List questions) {
		this.questions = questions;
	}

	public void addQuestion(Question aQuestion) {
		questions.add(aQuestion);
	}

	public int getQuestionCount() {
		return questions.size();
	}

	public Question getQuestion(int index) {
		if(index < 0 || index >= questions.size()){
			return null;
		}
		return (Question)questions.get(index);
	}

	public abstract boolean generate();

	/**
	 * @return
	 */
	public int getLimitSeconds() {
		return limitSeconds;
	}

	/**
	 * @return
	 */
	public int getPassThreshold() {
		return passThreshold;
	}

	/**
	 * @param i
	 */
	public void setLimitSeconds(int i) {
		limitSeconds = i;
	}

	/**
	 * @param i
	 */
	public void setPassThreshold(int i) {
		passThreshold = i;
	}

	public abstract int computeScore();
}
