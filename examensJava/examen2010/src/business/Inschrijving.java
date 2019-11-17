package business;

/**
 * Abstract class Inschrijving - write a description of the class here
 * 
 * @author Mathy 
 * @version 1.0
 */



import business.informatie.Informatie;

public class Inschrijving implements Observer
{
    // instance variables - replace the example below with your own

    private Datum totDate;
    private Informatie informatie;

        
    public Inschrijving(Datum totDate, Informatie informatie) {
		super();
		this.totDate = totDate;
		this.informatie = informatie;
		informatie.addObserver(this);
	}

	public Informatie getInformatie() {
		return informatie;
	}

	public void setInformatie(Informatie informatie) {
		this.informatie = informatie;
	}
	

	public Datum getDate() {
		return totDate;
	}
	


	public void setDate(Datum totDate) {
		this.totDate = totDate;
	}

	@Override
	public void update(Subject subject) {
		informatie = (Informatie)subject;		
	}   
	
	@Override
	public String toString() {
		return "Inschrijving [informatie=" + informatie + ", totDate="
				+ totDate +  "]";
	}
}
