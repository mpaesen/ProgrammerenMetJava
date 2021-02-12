package com.groept.be.model;

public class Visitor {
	
	private String name,nick;
	
	public Visitor(){}
	
	public Visitor(String naam, String nick)
	{
		this.name = naam;
		this.nick = nick;
	}
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		if(name != null)
			return this.name;
		else
			return "Bezoeker zonder naam.";
	}
	
}
