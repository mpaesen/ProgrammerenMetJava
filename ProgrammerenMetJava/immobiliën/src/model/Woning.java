package model;

import model.kamers.Kamer;

import java.util.Arrays;

public abstract class Woning implements Verkoopbaar {
    private Kamer[] kamers;
    private byte aantalKamers;

    public Kamer[] getKamers() {
        return kamers;
    }

    public Kamer getKamer(byte i) {
        return kamers[i];
    }

    public void setKamer(byte i, Kamer kamer) {
        kamers[i] = kamer;
    }

    public byte getAantalKamers() {
        return aantalKamers;
    }

    public void setAantalKamers(byte aantalKamers) {
        if (this.kamers == null) {
            this.aantalKamers = aantalKamers;
            kamers = new Kamer[this.aantalKamers];
        }
    }

    @Override
    public String toString() {
        return "Woning{" + "aantalKamers = " + aantalKamers +
                ", kamers=" + Arrays.toString(kamers)
                +
                '}';
    }

    @Override
    public double getEenheidPrijs() {
        return 0;
    }

    @Override
    public abstract double berekenPrijs();

}
