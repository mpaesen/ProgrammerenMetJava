/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse zorgt voor het afhandelen van de login van de operators en de managers.
 */

package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login 
{
String gebruikersnaam;
String paswoord;

public String getGebruikersnaam() {
	return gebruikersnaam;
}
public void setGebruikersnaam(String gebruikersnaam) {
	this.gebruikersnaam = gebruikersnaam;
}
public String getPaswoord() {
	return paswoord;
}
public void setPaswoord(String paswoord) {
	this.paswoord = paswoord;
}

public String checkLogin() throws DataNietGevondenException, SQLException
{
	String result ="";
	ResultSet rs = DBtools.getResultSetFromStatement("select * from ");
	String echtPaswoord = rs.getString("paswoord");
	if (paswoord.equals(echtPaswoord))
	{
		result = "Ingelogd";
		HuidigeGebruiker.setHuidigeGebruiker(gebruikersnaam);
	}
	else
	{
		result = "NietIngelogd";
	}
	return result;
}
}
