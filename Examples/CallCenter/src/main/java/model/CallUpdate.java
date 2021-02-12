/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse maakt een object aan voor een geupdate call, met alle nodige informatie. 
 */
package model;

import exceptions.DataNietGevondenException;

public class CallUpdate extends Call 
{
private String datumUpdate;

public CallUpdate(Operator operator, Klant klant, int status, int callID, String datum, String klachtToestel, String klachtType, String klachtBeschrijving, String datumUpdate) throws DataNietGevondenException
{
super(operator,klant,status,callID,datum,klachtToestel,klachtType,klachtBeschrijving);
setDatumUpdate(datumUpdate);
}

public void setDatumUpdate(String datumUpdate) 
{
	this.datumUpdate = datumUpdate;
}

public String getDatumUpdate() {
	return datumUpdate;
}
public String toString()
{
return super.toString() + "Datum update: " + getDatumUpdate() + "<br>";	
}
}
