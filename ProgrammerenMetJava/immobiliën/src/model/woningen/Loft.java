package model.woningen;

public class Loft extends Studio {

    private boolean balkon;

    public Loft(byte aantal) {
        super(aantal);
    }

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }

    @Override
    public String toString() {
        return "Loft{" +
                "balkon=" + balkon +
                '}' + super.toString();
    }

    @Override
    public double getEenheidPrijs() {
        return 7500.00;
    }


    @Override
    public double berekenPrijs() {
        return 0;
    }
}
