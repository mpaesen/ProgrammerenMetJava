package business.berichten;

/**
 * Abstract class Bericht - write a description of the class here
 * 
 * @author Mathy 
 * @version 1.0
 */
public abstract class Bericht
{
    // instance variables - replace the example below with your own
	
	private String text;

	public Bericht(String text) {
		super();
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Bericht [text=" + text +  "]";
	}
}
