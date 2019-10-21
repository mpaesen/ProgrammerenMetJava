package model.woningen;

public class Villa extends Huis {


    public Villa(byte aantal) {
        super(aantal);
        setAantalKamers(aantal);
    }


    @Override
    public double getEenheidPrijs() {
        return 5000.00;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tuin=" + getTuin() +
                '}' + super.toString();
    }

    public double berekenTotaleOppervlakte() {
        double opp = 0;
        for (byte i = 0; i < getAantalKamers(); i++) {
            opp += getKamer(i).getOppervlakte();
        }
        return opp;
    }

    @Override
    public double berekenPrijs() {
        double prijs = (berekenTotaleOppervlakte() * getEenheidPrijs());
        if (getTuin()) {
            prijs *= 1.1;
        }
        return prijs;
    }


}

