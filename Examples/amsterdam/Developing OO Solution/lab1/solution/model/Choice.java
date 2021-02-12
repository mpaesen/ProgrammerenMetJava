package lab1.solution.model;

public class Choice {
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
	public void setCorrect(boolean aCorrect) {
		correct = aCorrect;
	}
	public void setPicked(boolean aPicked) {
		picked = aPicked;
	}
	public void setText(String aText) {
		text = aText;
	}
}