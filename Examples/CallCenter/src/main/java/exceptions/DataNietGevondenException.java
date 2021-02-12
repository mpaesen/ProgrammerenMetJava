/**
 * @author Kjell Lenaers
 * @version v1.00
 * Custom exception: zie message.
 */

package exceptions;

public class DataNietGevondenException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public String message = "De vereiste data kan niet gevonden worden in de database. " +
	"De ingevoerde gegevens bestaan niet of er is geen connectie met de database.";
	
	public DataNietGevondenException()
	{
	}

	public String getMessage() 
	{
		return message;
	}
}
