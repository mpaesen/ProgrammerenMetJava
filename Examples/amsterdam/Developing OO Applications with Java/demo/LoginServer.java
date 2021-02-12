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
import java.rmi.RemoteException;
public class LoginServer {
	public static void main(String args[]) {
		try {
			ValidatorImpl aValidator = new ValidatorImpl();
			Naming.rebind("validator", aValidator);
			System.out.println("Login server open for business");
		} catch (RemoteException e) { //catches a RemoteException
			e.printStackTrace();
		} catch (MalformedURLException me) {
			System.out.println("MalformedURLException " + me);
		}
	}
}
