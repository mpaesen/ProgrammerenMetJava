package com.groept.be.helper;

import com.groept.be.model.Visitor;

public class VisitorData {

	//Basis helper klasse om dummy data aan te maken die normaal uit de database hoort te komen
	public static Visitor[]  getVisitors()
	{
		Visitor[] result = new Visitor[3];
		
		result[0] = new Visitor("Stijn","Test1");
		result[1] = new Visitor("Jos","Test2");
		result[2] = new Visitor ("Sandra","Test3");
		
		return result;
	}
}
