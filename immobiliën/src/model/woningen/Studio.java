package model.woningen;

import model.Woning;

public class Studio extends Woning {
    public Studio(byte aantal) {
        setAantalKamers(aantal);

    }

    @Override
    public double berekenPrijs() {
        return 0;
    }

    @Override
    public String toString() {
        return "Studio{}" + super.toString();
    }
}
