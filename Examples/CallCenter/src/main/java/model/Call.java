/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse maakt een call-object aan, met alle nodige informatie. 
 */

package model;

import exceptions.DataNietGevondenException;

public class Call 
{
//datamembers
private String datum;
private int callID;
private Klant klant;
private Operator operator;
private int status;
private String klachtToestel;
private String klachtType;
private String klachtBeschrijving;

//getters en setters

public String getKlachtToestel() {
	return klachtToestel;
}
public void setKlachtToestel(String klachtToestel) {
	this.klachtToestel = klachtToestel;
}
public String getKlachtType() {
	return klachtType;
}
public void setKlachtType(String klachtType) {
	this.klachtType = klachtType;
}
public String getKlachtBeschrijving() {
	return klachtBeschrijving;
}
public void setKlachtBeschrijving(String klachtBeschrijving) {
	this.klachtBeschrijving = klachtBeschrijving;
}
public int getCallID() {
	return callID;
}
public void setCallID(int callID) {
	this.callID = callID;
}
public String getDatum() {
	return datum;
}
public void setDatum(String datum) {
	this.datum = datum;
}
public Klant getKlant() {
	return klant;
}
public void setKlant(Klant klant) {
	this.klant = klant;
}
public Operator getOperator() {
	return operator;
}
public void setOperator(Operator operator) {
	this.operator = operator;
}

public Call()
{}

public Call(Operator operator, Klant klant, int status, int callID, String datum, String klachtToestel, String klachtType, String klachtBeschrijving) throws DataNietGevondenException
{
	setStatus(status);
	setDatum(datum);
	setCallID(callID);
	setOperator(operator);
	setKlant(klant);
	setKlachtToestel(klachtToestel);
	setKlachtType(klachtType);
	setKlachtBeschrijving(klachtBeschrijving);
}
public String toString()
{
return "Datum call: "+datum+"<br>"+operator.toString()+klant.toString()+"<br>Klachttype: "+klachtType+"<br>Betreffende toestel: "+klachtToestel+"<br>Klachtbeschrijving: "+klachtBeschrijving+"<br>";
}
public void setStatus(int status) {
	this.status = status;
}
public int getStatus() {
	return status;
}

}
