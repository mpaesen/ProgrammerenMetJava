package exceptions;

public class MaximumAantalKamers extends Exception{
	private String text;

	public MaximumAantalKamers() {
		this("Maximum aantal kamers overschreden!");
	}

	public MaximumAantalKamers(String text) {
		super();
		setText(text);
	}

	/**
	 * @return Returns the text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            The text to set.
	 */
	public void setText(String text) {
		this.text = text;
	}

}
