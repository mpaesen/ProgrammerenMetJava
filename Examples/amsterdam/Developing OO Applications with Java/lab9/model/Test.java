/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab9.model;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class Test implements Testable, Serializable {
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
		if (index < 0 || index >= questions.size()) {
			return null;
		}
		return (Question) questions.get(index);
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

	public void save(String fileName) {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(this);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static Test load(String fileName) throws TestLoadException {
		ObjectInputStream is = null;
		Test test = null;
		try {
			is = new ObjectInputStream(new FileInputStream(fileName));
			test = (Test) is.readObject();
		} catch (Exception e) {
			throw new TestLoadException("Could not load a test");

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return test;
	}

	/* (non-Javadoc)
	 * @see lab9.model.Testable#setPick(int, int)
	 */
	public void setPick(int qindex, int cindex) throws RemoteException {
		Question question = this.getQuestion(qindex);
		if (question != null) {
			question.resetAllPicks();

			Choice choice = question.getChoice(cindex);
			if (choice != null) {
				choice.setPicked(true);
			}
		}

	}
	/*	Test and it's Question & Choice are remote
	 *  therfore the Driver cannot directly invoke the Coice setPicked(boolean) method.
	 *  This setPick method will allow the Choice to be set remotely
	*/

	public boolean isCertTest() throws RemoteException {
		return (this instanceof CertTest);
	}

}
