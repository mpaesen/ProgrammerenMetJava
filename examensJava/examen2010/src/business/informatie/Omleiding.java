package business.informatie;

import java.util.ArrayList;

import business.Verplaatsing;
import business.berichten.Bericht;

/**
 * Write a description of class Omleiding here.
 * 
 * @author Mathy 
 * @version 1.0
 */
public class Omleiding extends Informatie
{
	public Omleiding(Verplaatsing verplaatsing, ArrayList<Bericht> berichten){
		super(verplaatsing, berichten);
	}

	@Override
	public String toString() {
		return "Omleiding [reden=" + super.toString() + "]";
	}
 
}
