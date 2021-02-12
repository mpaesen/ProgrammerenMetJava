package lab9.solution.server;

import lab9.solution.model.Constants;
import lab9.solution.model.Test;
import lab9.solution.model.Testable;

public class Server {

public static void main(String[] args) {
	try {
	    TestService testService = new TestService();
	    Testable test = Test.load(Constants.PERSIST_FILE_NAME);
	    testService.setTest(test);

		java.rmi.Naming.rebind("test", testService);
		System.out.println("Test Server is ready.");
		
	} catch (Exception e) {
		System.out.println("Test Server failed: " + e);
	}
}
}
