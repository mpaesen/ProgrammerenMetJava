/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) wordt gebruikt om alle afgehandelde calls van een bepaalde periode op te vragen.
 * Er wordt gebruik gemaakt van de TijdsMoment-klasse om na te gaan of het moment van de call binnen
 * de opgegeven periode valt.
 */

package model;

import exceptions.DataNietGevondenException;
import my.tools.TijdsMoment;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AfgehandeldeCallsPeriode 
{
//datamembers
TijdsMoment datumCall;
TijdsMoment periode;
String beginPeriode;//uit jsf-inputveld
String eindePeriode;//uit jsf-inputveld

//getters en setters
public String getBeginPeriode() {
	return beginPeriode;
}
public void setBeginPeriode(String beginPeriode) {
	this.beginPeriode = beginPeriode;
}
public String getEindePeriode() {
	return eindePeriode;
}
public void setEindePeriode(String eindePeriode) {
	this.eindePeriode = eindePeriode;
}

/**
 * Method om de afgehandelde calls binnen een bepaalde periode op te vragen en weer te geven.
 * @return
 * @throws DataNietGevondenException
 * @throws SQLException 
 */
public String afgehandeldeCallsPeriode() throws DataNietGevondenException, SQLException
{
String result = "";
String[] beginPeriodeGesplitst = beginPeriode.split(".");
String[] eindePeriodeGesplitst = eindePeriode.split(".");
periode = new TijdsMoment(Integer.parseInt(beginPeriodeGesplitst[0]),Integer.parseInt(beginPeriodeGesplitst[1]), Integer.parseInt(beginPeriodeGesplitst[2]),
		Integer.parseInt(eindePeriodeGesplitst[0]), Integer.parseInt(eindePeriodeGesplitst[1]), Integer.parseInt(eindePeriodeGesplitst[2]));
ResultSet rs = DBtools.getResultSetFromStatement("query");
while (rs.next())
{
	String datumString = rs.getString("datum");
	String[] datumStringGesplitst = datumString.split(".");
	datumCall = new TijdsMoment(Integer.parseInt(datumStringGesplitst[0]),Integer.parseInt(datumStringGesplitst[1]),Integer.parseInt(datumStringGesplitst[2]));
	if (datumCall.overlapt(periode))
	{
		result += datumCall.toString();
	}
}
return result;
}
}
