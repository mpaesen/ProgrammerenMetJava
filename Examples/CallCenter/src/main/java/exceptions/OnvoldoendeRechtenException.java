package exceptions;


public class OnvoldoendeRechtenException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "+U hebt onvoldoende rechten om deze actie uit te voeren.";

	public String getMessage() 
	{
		return message;
	}
	
	public OnvoldoendeRechtenException()
	{}
}
