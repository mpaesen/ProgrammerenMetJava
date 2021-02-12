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
public class Choice {

	/**
	 * 
	 */
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String text;
	private boolean correct;
	private boolean picked;
	/**
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param string
	 */
	public void setText(String string) {
		text = string;
	}

	/**
	 * @return
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * @param b
	 */
	public void setCorrect(boolean b) {
		correct = b;
	}

	/**
	 * @return
	 */
	public boolean isPicked() {
		return picked;
	}

	/**
	 * @param b
	 */
	public void setPicked(boolean b) {
		picked = b;
	}
	protected void finalize() throws Throwable{		
		System.out.println("Finalize called on"+this);
		super.finalize();
	}
}
