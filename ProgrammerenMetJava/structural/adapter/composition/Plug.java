package structural.adapter.composition;

/**
 * The input for the plug is 5 AMP. which is a mismatch for a 15 AMP socket.
 * The Plug is the client. We need to cater to the requirements of the Plug.
 */
public interface Plug {
	public String getInput();
}// End of class