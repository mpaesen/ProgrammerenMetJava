package model.woningen;

public class Appartement extends Loft {
    public Appartement(byte aantal) {
        super(aantal);
    }

    @Override
    public double berekenPrijs() {
        return super.berekenPrijs();
    }

    @Override
    public String toString() {
        return "Appartement{}" + super.toString();
    }
}
