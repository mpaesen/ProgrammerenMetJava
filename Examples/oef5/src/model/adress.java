package model;

public class adress 
{

	String gemeente;
	String nummer;
	String postcode;
	String straat;
	
	public adress()
	{
		this.gemeente = null;
		this.nummer = null;
		this.postcode = null;
		this.straat = null;
	}
	
	public adress(String gemeente, String nummer, String postcode, String straat)
	{
		this.gemeente = gemeente;
		this.nummer = nummer;
		this.postcode = postcode;
		this.straat = straat;
	}
	
	public String getGemeete()
	{
		return gemeente;
	}
	
	public void setGemeente(String gemeente)
	{
		this.gemeente = gemeente;
	}
	
	public String getNummer()
	{
		return nummer;
	}
	
	public void setNummer(String nummer)
	{
		this.nummer = nummer;
	}
	public String getPostcode()
	{
		return postcode;
	}
	
	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}
	public String getStraat()
	{
		return straat;
	}
	
	public void setStraat(String straat)
	{
		this.straat = straat;
	}
	
	public String toString()
	{
		return "een address";
	}
	
}
