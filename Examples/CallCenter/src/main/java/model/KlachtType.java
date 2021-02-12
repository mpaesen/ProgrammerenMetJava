/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze enum bevat de mogelijke klachttypes, om de klachten gemakkelijker te categoreren en ze bij de juiste diensten
 * te krijgen.
 */

package model;

public enum KlachtType 
{
TOESTELKAPOT("toestel kapot"),
SOFTWAREPROBLEEM("softwareprobleem"),
INFORMATIEAANVRAAG("informatie-aanvraag"),
HERSTELLINGTELAAT("herstelling te laat");

String type;

public String getType() {
	return type;
}

KlachtType(String string)
{
	
}

}
