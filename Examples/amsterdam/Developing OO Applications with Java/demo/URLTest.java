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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class URLTest {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://www.ibm.com/index.html");
			u = new URL("file:///C:/docs/guide/net/overview/overview.html");
			URLConnection uc = u.openConnection();
			uc.connect();
			BufferedReader br =
				new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}