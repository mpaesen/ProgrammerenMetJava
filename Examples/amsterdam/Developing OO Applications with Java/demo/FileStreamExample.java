/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.io.*;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
class FileStreamExample {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			// fr and fw must be declared in a try/catch
			// block.
			fr = new FileReader("input.txt");
			fw = new FileWriter("c:\\temp\\output.txt");
			br = new BufferedReader(fr);
			pw = new PrintWriter(fw);
			String s;
			while ((s = br.readLine()) != null) {
				pw.write(s+"\n");
				// Don't forget to flush the output stream.
				pw.flush();
			}
		} catch (IOException e1) {
			System.out.println("main(): " + e1);
		} finally {
			// Don't forget to close your streams.
			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
			} catch (IOException e2) {
			}
		}
	}
}
