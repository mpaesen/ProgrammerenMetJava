package com.groept.be.controller;

import com.groept.be.helper.VisitorData;
import com.groept.be.model.Visitor;

public class VisitorService {
	
	private Visitor[] visitors;
	
	public VisitorService()
	{
		//setup dummy visitor data, normaal komt deze uit een database via de DAO klasse.
		this.visitors= VisitorData.getVisitors();
	}
	
	/**
	 * Zoeken van een bezoeker op basis van zijn nick
	 * @param nick
	 * @return Visitor
	 */
	public Visitor findVisitor(String nick)
	{
		for(Visitor visitor : this.visitors)
		{
			if(visitor !=null && visitor.getNick().trim().equals(nick.trim()))
				return visitor;
		}
		return null;
	}
	
	/**
	 * Creatie nieuwe bezoeker en registratie in de lijst met gekende bezoekers
	 * @param name
	 * @param nick
	 * @return Visitor
	 */
	public Visitor createNewVisitor(String name, String nick)
	{
		Visitor newVisitor = new Visitor (name,nick);
		
		Visitor[] list = new Visitor[this.visitors.length+1];
		
		for(int i=0;i<this.visitors.length;i++)
		{
			list[i]=this.visitors[i];
		}
		list[list.length-1] = newVisitor;
		
		this.visitors = list;
		
		return newVisitor;
	}

}
