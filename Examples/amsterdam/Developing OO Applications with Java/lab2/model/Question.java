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
public class Question {
	private Choice[] choices = new Choice[4];
	private String text;
	private int counter;
	/**
	 * 
	 */
	public Question() {
		super();
		text = new String("");
	}

	/**
	 * @return
	 */
	public Choice[] getChoices() {
		return choices;
	}

	/**
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param choices
	 */
	public void setChoices(Choice[] choices) {
		this.choices = choices;
	}

	/**
	 * @param string
	 */
	public void setText(String string) {
		text = string;
	}
	public void addChoice(Choice choice){
		choices[counter++] = choice;
	}
	
	public Choice getChoice(int index){
		return choices[index];
	}
	
	public int getCount(){
		return choices.length;
	}

}
