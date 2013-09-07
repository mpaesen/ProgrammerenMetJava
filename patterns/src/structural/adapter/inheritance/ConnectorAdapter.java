package structural.adapter.inheritance;

/**
 * ConnectorAdapter has is the connector between the socket and plug so as to
 * make the interface of one system to suit the client.
 */
public class ConnectorAdapter implements Socket {
	/**
	 * Method coming from the interface Socket which we have to make to fit the
	 * client plug
	 * 
	 * @return Desired output of 5 AMP
	 */
	public String getOutput() {
		Plug plug = new Plug();
		String output = plug.getInput();
		return output;
	}
}// End of class
