package lab9.solution.server;

import lab9.solution.model.CertTest;
import lab9.solution.model.Question;
import lab9.solution.model.Testable;

public class TestService extends java.rmi.server.UnicastRemoteObject implements Testable {
	public Testable test;

public TestService()throws java.rmi.RemoteException {
}

public int computeScore() throws java.rmi.RemoteException {
	if(test != null)
		return test.computeScore();
	return 0;
}

public int getLimitSeconds() throws java.rmi.RemoteException {
	if(test != null)
		return test.getLimitSeconds();
	return 0;
}

public int getPassThreshold() throws java.rmi.RemoteException {
	if(test != null)
		return test.getPassThreshold();
	return 0;
}

public Question getQuestion(int index) throws java.rmi.RemoteException {
	if(test != null)
		return test.getQuestion(index);
	return null;
}

public int getQuestionCount() throws java.rmi.RemoteException {
	if(test != null)
		return test.getQuestionCount();
	return 0;
}

public Testable getTest() {
	return test;
}

public boolean isCertTest() throws java.rmi.RemoteException {
		return(test instanceof CertTest);
}

public void setPick(int qindex, int cindex) throws java.rmi.RemoteException {
	if(test != null)
		test.setPick(qindex, cindex);
}

public void setTest(Testable newTest) {
	test = newTest;
}
}
