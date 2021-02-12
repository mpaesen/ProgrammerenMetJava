/*
 * Created on Feb 16, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HandelRequest {
	private HttpServletRequest req;
	/**
	 * 
	 */
	public HandelRequest(HttpServletRequest req) {
		super();
		this.req = req;
	}

	public String[] SQLParameters() {
		String[] parameterMarkers = new String[5];

		for (int i = 0; i < parameterMarkers.length; i++) {
			parameterMarkers[i] = (i<5?getParameter(i):"");
		}
		return parameterMarkers;
	}

	private String getParameter(int i) {
		switch (i) {
			case 0 :
				return req.getParameter("INSS");
			case 1 :
				return req.getParameter("Fname").toUpperCase();
			case 2 :
				return req.getParameter("Lname").toUpperCase();
			case 3 :
				return req.getParameter("Office");
			default :
				return "";
		}
	}
}
