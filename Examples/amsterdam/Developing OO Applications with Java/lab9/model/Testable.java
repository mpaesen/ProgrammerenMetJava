/*
 * Created on May 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab9.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface Testable extends Remote {
	public int getQuestionCount() throws RemoteException;
	public Question getQuestion(int index) throws RemoteException;
	public int computeScore() throws RemoteException;
	public int getPassThreshold() throws RemoteException;
	public int getLimitSeconds() throws RemoteException;

	public void setPick(int qindex, int cindex) throws RemoteException;
	/*	Test and it's Question & Choice are remote
	 *  therfore the Driver cannot directly invoke the Coice setPicked(boolean) method.
	 *  This setPick method will allow the Choice to be set remotely
	*/

	public boolean isCertTest() throws RemoteException;
}
