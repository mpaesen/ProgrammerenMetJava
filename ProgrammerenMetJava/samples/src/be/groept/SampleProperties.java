/*
 * Created on Aug 20, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package be.groept;

/**
 * @author mpaesen
 * @version 1.0
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.File;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

public class SampleProperties {
	private Properties p = null;

	public SampleProperties(File f) throws IOException {
		p = new Properties();
		p.load(new FileInputStream(f));
	}

	public String getProperty(String key) {
		return p.getProperty(key);
	}

	public void setProperty(String key, String value) {
		p.setProperty(key, value);
	}

	public void list(PrintStream s) {
		p.list(s);
	}

	public void listWeb(PrintWriter s) {
		p.list(s);
	}

	public Enumeration elements() {
		return p.elements();
	}

	public Enumeration keys() {
		return p.keys();
	}

	public static SampleProperties getPropertiesFile(String file) {
		SampleProperties sp = null;
		try {
			File f = new File(file);
			if (f.exists()) {
				sp = new SampleProperties(f);
			} else {
				System.out.println("File " + f + " does not exist!");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} 
			return sp;
		
	}

	private static void showRates(SampleProperties sp) {
		System.out.println("All known currencies:\n=====================");
		sp.list(System.out);
		System.out.println("\nFor 3 Euro, you get " + 3
				* Float.parseFloat(sp.getProperty("eur2usd"))
				+ " dollars");
				
	}

	public static void main(String[] args) {
		try {
			if (args.length == 1) {
				SampleProperties sp = getPropertiesFile(args[0]);
				showRates(sp);
			} else {
				System.out
						.println("Usage: java SampleProperties file.properties");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}