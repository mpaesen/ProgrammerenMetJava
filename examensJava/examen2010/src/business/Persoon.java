package business;

public abstract class Persoon {
    private String naam;
    private String voorNaam;
    

    public String getNaam()
    {
        // put your code here
        return naam;
    }
    

    public void setNaam(String naam)
    {
        // put your code here
        this.naam = naam;
    }	
    public String getVoorNaam() {
		return voorNaam;
	}

	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	} 

	public String toString(){
		return String.format("%s\t%s", this.getNaam(), this.getVoorNaam());
	}
}
