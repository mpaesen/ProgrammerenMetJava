/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab8.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Question implements Serializable {
	private List choices;
	private String text;
	private int counter;
	/**
	 * 
	 */
	public Question() {
		super();
		text = new String("");
		choices = new ArrayList();
	}

	/**
	 * @return
	 */
	public ArrayList getChoices() {
		return (ArrayList) choices;
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
	public void setChoices(List choices) {
		this.choices = choices;
	}

	/**
	 * @param string
	 */
	public void setText(String string) {
		text = string;
	}
	public void addChoice(Choice choice) {
		choices.add(choice);
	}

	public Choice getChoice(int index) {
		if (index < 0 || index >= choices.size()) {
			return null;
		}
		return (Choice) choices.get(index);
	}

	public int getCount() {
		return choices.size();
	}

	public void resetAllPicks() {
		Iterator iter = choices.iterator();
		while (iter.hasNext()) {
			Choice choice = (Choice) iter.next();
			choice.setPicked(false);
		}
	}
}
