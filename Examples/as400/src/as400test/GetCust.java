package as400test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.data.PcmlException;
import com.ibm.as400.data.ProgramCallDocument;

public class GetCust
{

	public static void main(final String[] argv)
	{
		final AS400 as400System = new AS400();
		ProgramCallDocument pcml = null;
		final String msgId, msgText;
		Object value = null;
		try
		{
			System.out.println("Creating ProgramCallDocument for GetCust pgm.");
			pcml = new ProgramCallDocument(as400System, "GETCUST");
			final boolean ok = pcml.callProgram("getcust");
			//	System.out.println(" rc is---> " + rc);
			if (!ok)
			{ /* Retrieve list of AS/400 messages & display them */
			}
			else
			{
				value = pcml.getValue("getcust.gotback.Name");
				System.out.println("Customer name: " + value);
			}
		}
		catch (final PcmlException exc)
		{
			System.out.println("*** Call to getcust failed. ***");
			System.exit(0);
		}
		System.exit(0);
	} // end main method
}