/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MergeList {
	public void merge(Collection c) {
		LinkedList merger = new LinkedList(c);
		merger.addFirst("Orange");
		merger.addLast("Pomegranate");
		Object removedObj = merger.removeLast();
		//removes Pomegranate from the list
	}
}