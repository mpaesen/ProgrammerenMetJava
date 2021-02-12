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

import java.util.SortedSet;
import java.util.TreeSet;
public class TreeSetDemo {
	public static void main(String args[]) {
		SortedSet fruitBasket = new TreeSet();
		fruitBasket.add("Banana");
		fruitBasket.add("Apple");
		fruitBasket.add("Fig");
		fruitBasket.add("Cherry");
		fruitBasket.add("Apple");
		System.out.println(fruitBasket);
	}
}
