/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) wordt gebruikt een call af te sluiten en dit aan te passen in de database.
 */

package model;


import exceptions.DataInvoerException;
import persistentie.DBtools;

public class CallAfsluiten 
{
	//datamember
	String callString;//uit jsf-inputveld
	
	//getter en setter
	public String getCallString() {
		return callString;
	}

	public void setCallString(String callString) {
		this.callString = callString;
	}

	/**
	 * Method om een call af te sluiten.
	 * @param call
	 * @return
	 * @throws DataInvoerException
	 * @throws DataNietGevondenException 
	 */
	public String callAfsluiten() throws DataInvoerException
	{

		DBtools.updateTable("update calls set status = 0 where callid = "+callString.substring(0,callString.indexOf(" ")));
		return "CallAfgesloten";	
}

}
