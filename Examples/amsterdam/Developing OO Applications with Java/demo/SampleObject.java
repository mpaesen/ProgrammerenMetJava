/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SampleObject implements Serializable {
	private String name;
	private int age;

	transient private Date currentDate;
	 private int accountID;

	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param i
	 */
	public void setAge(int i) {
		age = i;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @return
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @return
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param i
	 */
	public void setAccountID(int i) {
		accountID = i;
	}

	/**
	 * @param date
	 */
	public void setCurrentDate(Date date) {
		currentDate = date;
	}

}
