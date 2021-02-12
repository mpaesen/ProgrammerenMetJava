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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
public class ValidatorImpl extends UnicastRemoteObject implements Validator {
	Map memberMap;
	public ValidatorImpl() throws RemoteException {
		memberMap = new HashMap();
		memberMap.put("John", "Appleseed"); //could add several records here
	}
	public String validate(String aUserName, String aPassword)
		throws RemoteException {
		if (getMemberMap().containsKey(aUserName)
			&& getMemberMap().get(aUserName).equals(aPassword))
			return "Welcome " + aUserName; //early return if password is valid
		return "Sorry invalid login information!";
	}
	public Map getMemberMap() {
		return memberMap;
	}
}
