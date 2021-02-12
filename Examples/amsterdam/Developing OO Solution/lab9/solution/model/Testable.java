package lab9.solution.model;
public interface Testable extends java.rmi.Remote{
	int computeScore()throws java.rmi.RemoteException;
	int getLimitSeconds()throws java.rmi.RemoteException;
	int getPassThreshold()throws java.rmi.RemoteException;
	public int getQuestionCount()throws java.rmi.RemoteException;
	public boolean isCertTest() throws java.rmi.RemoteException;
	public Question getQuestion(int index)throws java.rmi.RemoteException;
	public void setPick(int qindex, int cindex) throws java.rmi.RemoteException;


}