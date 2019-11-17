package business;

/**
 * Write a description of class Reiziger here.
 * 
 * @author Mathy 
 * @version 1.0
 */

import java.util.Iterator;
import java.util.LinkedList;

public class Reiziger extends Persoon
{
	private String berichtVoorkeurMedium;
	private LinkedList <Inschrijving> inschrijvingen;

	public String getBerichtVoorkeurMedium() {
		return berichtVoorkeurMedium;
	}

	public void setBerichtVoorkeurMedium(String berichtVoorkeurMedium) {
		this.berichtVoorkeurMedium = berichtVoorkeurMedium;
	}
	 
    public LinkedList<Inschrijving> getInschrijvingen() {
		return inschrijvingen;
	}

	public void setInschrijvingen(LinkedList<Inschrijving> inschrijvingen) {
		this.inschrijvingen = inschrijvingen;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		Iterator <Inschrijving>iterator = inschrijvingen.iterator();
		while(iterator.hasNext()){
			buffer.append(iterator.next().toString());
		}
		return buffer.toString();
	}
}
