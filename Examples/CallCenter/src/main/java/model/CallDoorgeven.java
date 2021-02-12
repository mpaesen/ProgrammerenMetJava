/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) laat de manager toe om een call door te geven aan een andere operator.
 */
package model;

import exceptions.DataInvoerException;
import exceptions.OnvoldoendeRechtenException;
import persistentie.DBtools;

public class CallDoorgeven 
{
String callString;//uit jsf-inputveld
String operatorString;//uit jsf-inputveld

/**
 * Method om een call door te geven aan een andere operator.
 * @return
 * @throws DataInvoerException
 * @throws DataNietGevondenException
 * @throws OnvoldoendeRechtenException 
 */
public String callDoorgeven() throws DataInvoerException, OnvoldoendeRechtenException
{
String result = null;
	if (HuidigeGebruiker.getHuidigeGebruiker().gebruikerFunctie.equals("manager"))
	{
		DBtools.updateTable("update calls set operatorid = "+ operatorString.substring(0, operatorString.indexOf(" "))+
				"where id = " + callString.substring(0, operatorString.indexOf(" ")));
		result = "CallDoorgegeven";
	}
	else
	{
		throw new OnvoldoendeRechtenException();
	}
return result;	
}
}
