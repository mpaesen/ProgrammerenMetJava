/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) zal zorgen voor een overzicht van de gebeurde updates van alle calls.
 */

package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CallUpdates 
{
	public String getCallUpdates() throws DataNietGevondenException
	{
		String result = null;
ResultSet rs = DBtools.getResultSetFromStatement("select * from callupdates");
try 
{
	CallUpdate callUpdate;
	while (rs.next())
	{
		callUpdate = new CallUpdate(new Operator(rs.getInt("gebruikerid")),new Klant(rs.getInt("klantid")),rs.getInt("status"),rs.getInt("callid"),rs.getString("datum"),rs.getString("klachttoestel"),rs.getString("klachttype"),rs.getString("klachtbeschrijving"),rs.getString("datumupdate"));
		result += callUpdate.toString();
	}
} 
catch (SQLException e) 
{
	throw new DataNietGevondenException();
}
return result;
}
	
}
