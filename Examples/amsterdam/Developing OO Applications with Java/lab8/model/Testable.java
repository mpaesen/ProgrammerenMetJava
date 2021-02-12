/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab8.model;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface Testable {
	public int getQuestionCount();
	public Question getQuestion(int index);
	public int computeScore();
	public int getPassThreshold();
	public int getLimitSeconds();
}
