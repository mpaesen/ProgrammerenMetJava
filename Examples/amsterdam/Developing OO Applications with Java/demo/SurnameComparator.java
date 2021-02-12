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
import java.util.LinkedList;
import java.util.StringTokenizer;
class SurnameComparator implements java.util.Comparator {
	public int compare(Object a, Object b) {
		LinkedList tokenList1 = new LinkedList();
		LinkedList tokenList2 = new LinkedList();
		StringTokenizer name1 = new StringTokenizer((String) a, " ");
		StringTokenizer name2 = new StringTokenizer((String) b, " ");
		while (name1.hasMoreTokens())
			tokenList1.add(name1.nextToken());
		while (name2.hasMoreTokens())
			tokenList2.add(name2.nextToken());
		String aName = (String) tokenList1.getLast();
		String anotherName = (String) tokenList2.getLast();
		return aName.compareTo(anotherName);
	}
}
