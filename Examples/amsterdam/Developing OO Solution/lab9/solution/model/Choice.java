package lab9.solution.model;

import java.io.Serializable;
public class Choice implements Serializable{
	private String text;
	private boolean correct;
	private boolean picked;

	public Choice() {
	}

	protected void finalize() {
		System.out.println("Finialze called on " + this);
	}
	public String getText() {
		return text;
	}
	public boolean isCorrect() {
		return correct;
	}
	public boolean isPicked() {
		return picked;
	}
	public void setCorrect(boolean newCorrect) {
		correct = newCorrect;
	}
	public void setPicked(boolean newPicked) {
		picked = newPicked;
	}
	public void setText(String newText) {
		text = newText;
	}
}