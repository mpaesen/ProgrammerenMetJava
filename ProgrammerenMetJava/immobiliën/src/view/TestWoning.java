package view;

import model.TypeWoning;
import model.Woning;
import model.factory.WoningFactory;

public class TestWoning {

    private Woning[] aantalWoningen;

    public static void main(String[] args) {
        TestWoning nieuweWoningen = new TestWoning();
        nieuweWoningen.initialisatie();
        nieuweWoningen.print();
    }

    public void initialisatie() {
        aantalWoningen = new Woning[10 + WoningFactory.random.nextInt(20)];
        for (int i = 0; i < aantalWoningen.length; i++) {
            aantalWoningen[i] = WoningFactory.creatieWoning(TypeWoning.values()[WoningFactory.random.nextInt(TypeWoning.values().length)]);
        }
    }

    public void print() {
        for (int i = 0; i < aantalWoningen.length; i++) {
            System.out.println("\nWoning " + (i + 1) + ": " + aantalWoningen[i].toString());
        }
    }
}
