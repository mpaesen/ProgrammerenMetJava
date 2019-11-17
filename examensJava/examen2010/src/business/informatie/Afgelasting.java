package business.informatie;

import java.util.ArrayList;

import business.Verplaatsing;
import business.berichten.Bericht;

/**
 * Write a description of class Afgelasting here.
 * 
 * @author Mathy 
 * @version 1.0
 */
public class Afgelasting extends Informatie
{

	public Afgelasting(Verplaatsing verplaatsing, ArrayList<Bericht> berichten){
		super(verplaatsing, berichten);
	}

	@Override
	public String toString() {
		return "Afgelasting [reden=" + super.toString() + "]";
	}
 
}
