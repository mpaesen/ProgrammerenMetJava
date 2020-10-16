package view;

import model.VervoerMiddel;
import model.factory.VoertuigFactory;

import java.util.ArrayList;
import java.util.Random;


/**
 * Write a description of class TestVoertuig here.
 *
 * @author (Mathy Paesen)
 * @version (21 / 09 / 2003)
 */
public class TestVoertuig {

    //private VervoerMiddel[] voertuigen;
    private ArrayList<VervoerMiddel> voertuigen = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) {
        TestVoertuig voertuig = new TestVoertuig(); //object nodig om static methods te vermijden
        voertuig.setUp();
        voertuig.print();
        System.out.println("Aantal aangemaakte vervoermiddelen " + VervoerMiddel.getNummer());
    }

    public void setUp() {

        for (int i = 0; i < 5 + random.nextInt(20); i++) {
            // voertuigen[i] = VoertuigFactory.createVoertuig((int)(Math.random()*3.0)); //0.0 >= x < 1.0
            voertuigen.add(VoertuigFactory.createVoertuig(random.nextInt(3)));
        }
    }

    public void print() {
        for (VervoerMiddel vervoerMiddel : voertuigen)
            System.out.println("\nVoertuig " + vervoerMiddel.getCurrentNummer() + ": " + vervoerMiddel);    //polymorfie
    }
}