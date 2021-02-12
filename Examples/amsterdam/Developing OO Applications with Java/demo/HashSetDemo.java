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

import java.util.HashSet;
import java.util.Set;
public class HashSetDemo {
	public static void main(String args[]) {
		Set fruitBasket = new HashSet();
		fruitBasket.add("Apple");
		fruitBasket.add("Banana");
		fruitBasket.add("Cherry");
		fruitBasket.add("Fig");
		fruitBasket.add("Apple");
		System.out.println(fruitBasket);
	}
}
