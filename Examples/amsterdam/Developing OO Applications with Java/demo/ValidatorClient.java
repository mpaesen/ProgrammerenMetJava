/*
 * Created on Jun 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
public class ValidatorClient {
	public static void main(String args[]) {
		if (args.length == 0 || !args[0].startsWith("rmi:")) {
			System.out.println(
				"Usage: java ValidatorClient"
					+ "rmi://host.domain.port/validator username password");
		}
		try {
			Object remote = Naming.lookup(args[0]);
			Validator reply = (Validator) remote;
			System.out.println(reply.validate(args[1], args[2]));
		} catch (MalformedURLException me) {
			System.out.println(args[0] + " is not a valid URL");
		} catch (RemoteException nbe) {
			System.out.println("Could not find requested object on the server");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}