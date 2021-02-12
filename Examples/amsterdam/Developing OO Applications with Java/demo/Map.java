/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Map {
	public static void main(String args[]) {
		SortedMap tm = new TreeMap();
		tm.put("apple", "MacIntosh");
		tm.put("orange", "Valentia");
		tm.put("banana", "Chiquita");
		System.out.println(tm);
	}
}
