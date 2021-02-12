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
import java.util.SortedMap;
import java.util.TreeMap;
public class Payroll {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		SortedMap t = new TreeMap(new SurnameComparator());
		t.put("Madonna", new Double(1234456.44));
		t.put("John Jacob Jingle Heimer Schmidt", new Double(145.89));
		t.put("Jennifer Jason Leigh", new Double(3456.55));
		t.put("Zachary Adams", new Double(23.33));
		System.out.println(t);
	}
}
