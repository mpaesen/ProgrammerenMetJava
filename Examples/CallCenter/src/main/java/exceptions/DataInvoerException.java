/**
 * @author Kjell Lenaers
 * @version v1.00
 * Custom exception: zie message.
 */

package exceptions;

public class DataInvoerException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	public String message = "De vereiste data kan niet gevonden worden ingegeven in de database. " +
	"De ingevoerde gegevens zijn incorrect of er is geen connectie met de database.";
	
	public DataInvoerException()
	{
	}

	public String getMessage() 
	{
		return message;
	}
}
