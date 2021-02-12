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

public class Operator {
//datamembers
String operatorNaam;
String operatorFunctie;
int operatorID;

//getters en setters
public String getOperatorFunctie() {
	return operatorFunctie;
}
public void setOperatorFunctie(String operatorFunctie) {
	this.operatorFunctie = operatorFunctie;
}
public int getOperatorID() {
	return operatorID;
}
public void setOperatorID(int operatorID) {
	this.operatorID = operatorID;
}
public String getOperatorNaam() {
	return operatorNaam;
}
public void setOperatorNaam(String operatorNaam) {
	this.operatorNaam = operatorNaam;
}

//default constructor
public Operator()
{}

//custom constructors
public Operator(int operatorID) throws DataNietGevondenException
{
	setOperatorID(operatorID);
	ResultSet rs = DBtools.getResultSetFromStatement("select * from operatoren where operatorID ="+operatorID);
	try 
	{
		rs.absolute(1);
		setOperatorNaam(rs.getString("operatornaam"));
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
}
public Operator(int operatorID, String operatorNaam)
{
setOperatorID(operatorID);
setOperatorNaam(operatorNaam);
}

//toString() methode voor een overzichtelijke output van het object
public String toString()
{
return "OperatorID: "+operatorID+"<br>Operatornaam: "+operatorNaam+"<br>"+operatorFunctie+"<br>";	
}
}
