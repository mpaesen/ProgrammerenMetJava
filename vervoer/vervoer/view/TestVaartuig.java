package view;

import model.factory.VaartuigFactory;
import model.vaartuigen.Vaartuig;


/**
 * Write a description of class TestVoertuig here.
 * 
 * @author (Mathy Paesen) 
 * @version (8 april 2011)
 */
public class TestVaartuig
{

    private Vaartuig[] vaartuigen;


	public void setUp() {
	    vaartuigen = new Vaartuig[10];
	    for(int i=0; i<vaartuigen.length; i++){
	           vaartuigen[i] = VaartuigFactory.createVaartuig((int)(Math.random()*2.0)); //
	    }
	}
 

    public void print() {
	    for(int i=0; i<vaartuigen.length; i++)
	           System.out.println("\nvaartuig "+i+": "+vaartuigen[i]);    //polymorfie
	}

      public static void main(String[] args) {
		TestVaartuig vaartuig = new TestVaartuig(); //object nodig om static methods te vermijden
		vaartuig.setUp();
		vaartuig.print(); 
	}
}