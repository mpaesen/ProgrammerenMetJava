/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package lab4.driver;

import lab4.model.CertTest;
import lab4.model.Constants;
import lab4.model.PracticeTest;
import lab4.model.Test;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PersistTest {

	public static void main(String[] args) {
		Test myTest = null;
				if (args.length != 1) {
					System.out.println(
						"Please pass the test type on the command line: practice or certification");
					System.exit(0);
				}
				System.out.println(Constants.APPNAME + " " + Constants.APPVERSION);
				if (args[0].equalsIgnoreCase("certification")) {
					myTest = new CertTest(2, 30);
				} else if (args[0].equalsIgnoreCase("practice")) {
					myTest = new PracticeTest();
				} else {
					System.out.println(
						"Invalid Test type entered. Only PRACTICE or CERTIFICATION allowed as types");
					return;
				}
				myTest.generate();
				myTest.save(Constants.PERSIST_FILE_NAME);
				System.out.println("Test generated to file \""+ Constants.PERSIST_FILE_NAME+"\"");
	}
}
