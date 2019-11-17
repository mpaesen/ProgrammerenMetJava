package business.informatie;

import java.util.ArrayList;

import business.Verplaatsing;
import business.berichten.Bericht;

/**
 * Write a description of class Vertraging here.
 * 
 * @author Mathy 
 * @version 1.0
 */
public class Vertraging extends Informatie
{
	public Vertraging(Verplaatsing verplaatsing, ArrayList<Bericht> berichten){
		super(verplaatsing, berichten);
	}

	@Override
	public String toString() {
		return "Vertraging [reden=" + super.toString() + "]";
	}
	
}
