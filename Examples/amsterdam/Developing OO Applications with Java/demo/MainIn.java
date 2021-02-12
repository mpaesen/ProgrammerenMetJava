/*
 * Created on May 31, 2005
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

import java.io.FileInputStream;
import java.io.ObjectInputStream;
class MainIn {
	public static void main(String[] args) {
		try {
			// To read the objects, you will need a
			// FileInputStream and an ObjectInputStream.
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			fis = new FileInputStream("SerializedObj.ser");
			ois = new ObjectInputStream(fis);
			SampleObject newObj1 = (SampleObject) ois.readObject();
			SampleObject newObj2 = (SampleObject) ois.readObject();
			ois.close();
			// And the results
			System.out.println("SampleObject1 name: " + newObj1.getName()+ " id= "+newObj1.getAccountID());
			System.out.println("SampleObject2 name: " + newObj2.getName()+" id= "+newObj2.getAccountID());
		} catch (Exception e) {
			System.out.println("Main: main(): " + e);
		}
	}
}
