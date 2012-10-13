package view;

import model.VervoerMiddel;
import model.factory.VoertuigFactory;


/**
 * Write a description of class TestVoertuig here.
 * 
 * @author (Mathy Paesen) 
 * @version (21/09/2003)
 */
public class TestVoertuig
{

    private VervoerMiddel[] voertuigen;


	public void setUp() {
	    voertuigen = new VervoerMiddel[20];
	    for(int i=0; i<voertuigen.length; i++){
	           voertuigen[i] = VoertuigFactory.createVoertuig((int)(Math.random()*3.0)); //
	    }
	}
 

    public void print() {
	    for(int i=0; i<voertuigen.length; i++)
	           System.out.println("\nVoertuig "+i+": "+voertuigen[i]);    //polymorfie
	}

      public static void main(String[] args) {
		TestVoertuig voertuig = new TestVoertuig(); //object nodig om static methods te vermijden
		voertuig.setUp();
		voertuig.print(); 
	}
}