/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse maakt operator-objecten aan, welke de nodige gegevens bevatten voor de applicatie.
 */

package model;

import exceptions.DataNietGevondenException;
import persistentie.DBtools;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gebruiker {
//datamembers
String gebruikerNaam;
String gebruikerFunctie;
int gebruikerID;

//getters en setters
public String getGebruikerFunctie() {
	return gebruikerFunctie;
}
public void setGebruikerFunctie(String gebruikerFunctie) {
	this.gebruikerFunctie = gebruikerFunctie;
}
public int getGebruikerID() {
	return gebruikerID;
}
public void setGebruikerID(int gebruikerID) {
	this.gebruikerID = gebruikerID;
}
public String getGebruikerNaam() {
	return gebruikerNaam;
}
public void setGebruikerNaam(String gebruikerNaam) {
	this.gebruikerNaam = gebruikerNaam;
}

//default constructor
public Gebruiker()
{}

//custom constructors
public Gebruiker(int gebruikerID) throws DataNietGevondenException
{
	setGebruikerID(gebruikerID);
	ResultSet rs = DBtools.getResultSetFromStatement("select * from gebruikeren where gebruikerID ="+gebruikerID);
	try 
	{
		rs.absolute(1);
		setGebruikerNaam(rs.getString("gebruikernaam"));
		setGebruikerFunctie(rs.getString("functie"));
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
}

public Gebruiker(String gebruikerNaam) throws DataNietGevondenException
{
	setGebruikerNaam(gebruikerNaam);
	ResultSet rs = DBtools.getResultSetFromStatement("select * from gebruikers where gebruikersnaam = "+gebruikerNaam);
	try 
	{
		rs.absolute(1);
		setGebruikerID(rs.getInt("id"));
		setGebruikerFunctie(rs.getString("functie"));
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
}

//toString() methode voor een overzichtelijke output van het object
public String toString()
{
return "GebruikerID: "+gebruikerID+"<br>Gebruikernaam: "+gebruikerNaam+"<br>Gebruikerfunctie"+gebruikerFunctie+"<br>";	
}
}
