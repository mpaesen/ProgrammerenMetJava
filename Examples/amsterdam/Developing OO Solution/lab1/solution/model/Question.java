package lab1.solution.model;

public class Question {
	private Choice[] choices = new Choice[4];
	private String text;
	private int counter;

	public Question() {
		setText("");
	}
	public void addChoice(Choice aChoice) {
		choices[counter] = aChoice;
		counter+=1;
	}
	protected void finalize() {
		System.out.println("Finalize called on " + this);
	}
	public Choice[] getChoices() {
		return choices;
	}
	public Choice getChoice(int index) {
		return choices[index];
	}
	public int getCount() {
		return choices.length;
	}
	public String getText() {
		return text;
	}
	public void setChoices(Choice[] newChoice) {
		choices = newChoice;
	}
	public void setText(String newText) {
		text = newText;
	}
}

