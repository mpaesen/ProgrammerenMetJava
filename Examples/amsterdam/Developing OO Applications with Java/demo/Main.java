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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
class Main {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = null;
		try {
			// Get an instance of the SampleObjects and
			// set their state.
			SampleObject originalObj1 = new SampleObject();
			SampleObject originalObj2 = new SampleObject();
			originalObj1.setName("Mary Smith");
			originalObj1.setAge(32);
			originalObj1.setAccountID(1);			
			originalObj2.setName("John Doe");
			originalObj2.setAge(42);
			originalObj2.setAccountID(2);
			originalObj2.setCurrentDate(new Date(System.currentTimeMillis()));
			// To write the object, you will need a
			// FileOutputStream and an ObjectOutputStream.
			FileOutputStream fos = null;
			fos = new FileOutputStream("SerializedObj.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(originalObj1);
			oos.writeObject(originalObj2);
		} catch (Exception e) {
			System.out.println("Main: main(): " + e);
		} finally {
			oos.close();
		}
	}
}
