/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse maakt klantobjecten aan, welke enkel de nodige informatie over de klant bevatten voor de applicatie.
 */

package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Klant 
{
//datamembers
private int klantID;
private String klantNaam;

//getters en setters
public int getKlantID() {
	return klantID;
}
public void setKlantID(int klantID) {
	this.klantID = klantID;
}
public void setKlantNaam(String klantNaam) {
	this.klantNaam = klantNaam;
}
public String getKlantNaam() {
	return klantNaam;
}
//default constructor
public Klant()
{}
//custom constructors
public Klant(int klantID) throws DataNietGevondenException
{
	setKlantID(klantID);
	ResultSet rs = DBtools.getResultSetFromStatement("select * from klanten where klantID ="+klantID);
	try 
	{
		rs.absolute(1);
		setKlantNaam(rs.getString("klantnaam"));
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
}

public Klant(int klantID, String klantNaam)
{
setKlantID(klantID);
setKlantNaam(klantNaam);
}
//toString() methode voor een ordelijke output van de klantgegevens.
public String toString()
{
	return "KlantID: "+klantID+"<br>Klantnaam: "+klantNaam+"<br>";
}
}
