/**
 * @author Kjell Lenaers
 * @version v1.00
 * Deze klasse bevat een method om namen te genereren voor de studententabel.
 */

package my.tools;

import java.util.Random;

public class Generators 
{
	//datamember
	Random generator = new Random();
	
	//default constructor
	public Generators()
	{}
	
	//method om een naam te genereren.
	public String generateName()
	{
		String v="aeiou",p="cvccvc";
		StringBuffer s=new StringBuffer();
		char t;
		for(int i=0;i<p.length();i++)
		while((v.indexOf(t=(char)(97+Math.random()*26))>=0 ^ p.charAt(i)=='v')
		|| s.append(t)==null);
		return s.toString();
	}

	}

