/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) zorgt voor het opvragen van alle calls van een bepaalde klant.
 */
package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CallsPerKlant 
{
//data members
String klant;//uit jsf-inputveld

//getter en setter
public String getKlant() {
	return klant;
}

public void setKlant(String klant) {
	this.klant = klant;
}

/**
 * Method om alle calls van een bepaalde klant op te vragen.
 * @return
 * @throws DataNietGevondenException
 */
public String callsPerKlant() throws DataNietGevondenException
{
	String result = null;
	ResultSet rs = DBtools.getResultSetFromStatement("select * from calls where klantid = "+ klant.substring(0, klant.indexOf(" ")));
	try 
	{
		Call call;
		while (rs.next())
		{
			call = new Call(new Operator(rs.getInt("gebruikerid")),new Klant(rs.getInt("klantid")),rs.getInt("status"),rs.getInt("callid"),rs.getString("datum"),rs.getString("klachttoestel"),rs.getString("klachttype"),rs.getString("klachtbeschrijving"));
			result += call.toString();
		}
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
	return result;
}
}
