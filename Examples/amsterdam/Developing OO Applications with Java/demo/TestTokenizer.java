/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.util.StringTokenizer;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestTokenizer {

	/**
	 * 
	 */
	public TestTokenizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("Dit is een erg vreemde test","e");
		while(str.hasMoreTokens()){
			System.out.println(str.nextElement());
		}
	}
}
