/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse geeft een lijst van alle calls die op naam staan van een bepaalde operator.
 */


package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LijstOpenCallsPerOperator 
{
	//data members
	String operator;//vanuit jsf-inputveld

	/**
	 * Method om alle open calls van een bepaalde operator weer te geven.
	 * @return
	 * @throws DataNietGevondenException
	 */
	public String lijstOpenCalls() throws DataNietGevondenException
	{
		String result = null;
		ResultSet rs = DBtools.getResultSetFromStatement("select * from calls where status = 1 and gebruikersid = "+operator.substring(0,operator.indexOf(" ")));
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
