package model.woningen;

import model.Woning;

public class Huis extends Woning {
    private boolean tuin;

    public Huis(byte aantal) {
        setAantalKamers(aantal);
    }

    public boolean getTuin() {
        return tuin;
    }

    public void setTuin(boolean tuin) {
        this.tuin = tuin;
    }

    @Override
    public String toString() {
        return "Huis{" +
                "tuin=" + tuin +
                '}' + super.toString();
    }

    @Override
    public double berekenPrijs() {
        return 0;
    }
}
