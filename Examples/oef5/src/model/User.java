package model;


public class User 
{
	long id;
	String firstname;
	String lastname;
	String gemeente;
	String nummer;
	String postcode;
	String straat;
	
	
	public User()
	{
		this.firstname = null;
		this.lastname = null;
		this.gemeente = null;
		this.nummer = null;
		this.postcode = null;
		this.straat = null;
	}
	
	public User(String firstname, String lastname, String gemeente, String nummer, String postcode, String straat)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.gemeente = gemeente;
		this.nummer = nummer;
		this.postcode = postcode;
		this.straat = straat;
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	
	public String getLastname()
	{
		return lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	public String getGemeente()
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
