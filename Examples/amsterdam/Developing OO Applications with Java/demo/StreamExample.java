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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
class StreamExample {
	public static void main(String[] args) {
		// Notice the nesting of streams
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			String s;
			// For a String you test for null
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				if(s.charAt(0) =='q')break;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("main(): " + e);
		}
	}
}
