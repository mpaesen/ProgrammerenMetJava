package business;

import test.enums.Steden;

import business.vervoermiddelen.VervoerMiddel;
import business.Datum;

/**
 * Abstract class Verplaatsing - write a description of the class here
 * 
 * @author Mathy 
 * @version 1.0
 */
public class Verplaatsing 
{
    // instance variables - replace the example below with your own
    private Steden vertrek;
	private Steden bestemming;
    private VervoerMiddel vervoermiddel;
    private Datum vanDate;
    private Datum totDate;


	public Steden getVertrek() {
		return vertrek;
	}

	public void setVertrek(Steden vertrek) {
		this.vertrek = vertrek;
	}

	public Steden getBestemming() {
		return bestemming;
	}

	public void setBestemming(Steden bestemming) {
		this.bestemming = bestemming;
	}

	public Datum getVanDate() {
		return vanDate;
	}

	public void setVanDate(Datum vanDate) {
		this.vanDate = vanDate;
	}

	public Datum getTotDate() {
		return totDate;
	}

	public void setTotDate(Datum totDate) {
		this.totDate = totDate;
	}
        
	public Verplaatsing(Steden vertrek, Steden bestemming, VervoerMiddel vervoermiddel, Datum vanDate, Datum totDate) {
		super();
		this.vertrek = vertrek;
		this.bestemming = bestemming;
		this.vervoermiddel = vervoermiddel;
		this.vanDate = vanDate;
		this.totDate = totDate;
	}
	
	public VervoerMiddel getVervoermiddel() {
		return vervoermiddel;
	}
	public void setVervoermiddel(VervoerMiddel vervoermiddel) {
		this.vervoermiddel = vervoermiddel;
	}

	@Override
	public String toString() {
		return "Verplaatsing [bestemming=" + bestemming + ", vertrek=" + vertrek
				+ ", vervoermiddel=" + vervoermiddel + ", vanDate=" + vanDate + ", totDate="
				+ totDate + "]";
	}
 
}
