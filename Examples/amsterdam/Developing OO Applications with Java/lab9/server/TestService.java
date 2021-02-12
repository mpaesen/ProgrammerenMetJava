/*
 * Created on Jun 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab9.server;

import lab9.model.CertTest;
import lab9.model.Question;
import lab9.model.Testable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class TestService extends UnicastRemoteObject implements Testable {
	public Testable test;

	public TestService() throws RemoteException {
	}

	public int computeScore() throws RemoteException {
		if (test != null)
			return test.computeScore();
		return 0;
	}

	public int getLimitSeconds() throws RemoteException {
		if (test != null)
			return test.getLimitSeconds();
		return 0;
	}

	public int getPassThreshold() throws RemoteException {
		if (test != null)
			return test.getPassThreshold();
		return 0;
	}

	public Question getQuestion(int index) throws RemoteException {
		if (test != null)
			return test.getQuestion(index);
		return null;
	}

	public int getQuestionCount() throws RemoteException {
		if (test != null)
			return test.getQuestionCount();
		return 0;
	}

	public Testable getTest() {
		return test;
	}

	public boolean isCertTest() throws RemoteException {
		return (test instanceof CertTest);
	}

	public void setPick(int qindex, int cindex)
		throws java.rmi.RemoteException {
		if (test != null)
			test.setPick(qindex, cindex);
	}

	public void setTest(Testable newTest) {
		test = newTest;
	}

}
