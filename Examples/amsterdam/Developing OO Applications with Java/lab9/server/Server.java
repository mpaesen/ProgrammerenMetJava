/*
 * Created on Jun 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab9.server;

import lab9.model.Constants;
import lab9.model.Test;
import lab9.model.TestLoadException;
import lab9.model.Testable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Server {

	public static void main(String[] args) {
		try {
			TestService service = new TestService();
			Testable test = Test.load(Constants.PERSIST_FILE_NAME);
			service.setTest(test);

			Naming.rebind("test", service);
			System.out.println("Test Server ready!");
		} catch (RemoteException e) {
			System.out.println("Test Server failed " + e);
		} catch (TestLoadException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
