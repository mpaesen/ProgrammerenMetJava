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
import java.io.*;
public class BufferedConsole {
	public static void main(String[] args) {
		try {
			BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw =
				new BufferedWriter(new OutputStreamWriter(System.out));
			String s = br.readLine();
			while (s != null) {
				if(s.charAt(0) =='q')break;
				bw.write("s: " + s+"\n");
				s = br.readLine(); // end while loop
			}
			bw.flush();
			bw.close();
			br.close();
		} // end try block
		catch (IOException io) {
			System.out.println(io);
		}
	}
}
