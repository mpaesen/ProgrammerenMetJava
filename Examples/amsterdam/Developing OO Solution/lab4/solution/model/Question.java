package lab4.solution.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Question implements Serializable{
	private List choices;
	private String text;

	public Question() {
		setText("");
		choices = new ArrayList();
	}
	public void addChoice(Choice aChoice) {
		choices.add(aChoice);
	}
	protected void finalize() {
		System.out.println("Finalize called on " + this);
	}
	public List getChoices() {
		return choices;
	}
	public Choice getChoice(int index) {
		if(index < choices.size()) {
			return (Choice)choices.get(index);
		}
		return null;
	}
	public int getCount() {
		return choices.size();
	}
	public String getText() {
		return text;
	}
	public void resetAllPicks() {
		Iterator it = choices.iterator();
		while(it.hasNext()) {
			Choice choice = (Choice)it.next();
			choice.setPicked(false);
		}
	}
	public void setChoices(List newChoices) {
		choices = newChoices;
	}
	public void setText(String newText) {
		text = newText;
	}
}

