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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class HashMapDemo {
	public static void main(String args[]) {
		Map punkerMap = new HashMap();
		punkerMap.put("Johnny Rotten", new Double(58584.34));
		punkerMap.put("Sid Vicious", new Double(2332.45));
		punkerMap.put("Joe Strummer", new Double(1000.34));
		punkerMap.put("Mick Jones", new Double(345345.34));
		Set punkerSet = punkerMap.entrySet();
		Iterator i = punkerSet.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.println(me.getKey() + ": " + me.getValue());
		}
		/*Sell more records and deposit money into the once bitter and disenfranchised youth's
		bank accounts*/
		double balance = ((Double) punkerMap.get("Joe Strummer")).doubleValue();
		punkerMap.put("Joe Strummer", new Double(balance + 14567.23));
		System.out.println(
			"Joe Strummer's new balance is now: "
				+ punkerMap.get("Joe Strummer"));
	}
}