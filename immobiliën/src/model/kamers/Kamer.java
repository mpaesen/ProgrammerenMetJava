package model.kamers;

public class Kamer {

    private double oppervlakte;
    private TypeKamer type;

    public Kamer(TypeKamer type) {

        this.type = type;
    }

    public double getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(int oppervlakte) {
        this.oppervlakte = oppervlakte;
    }

    @Override
    public String toString() {
        return "Kamer{" +
                "oppervlakte=" + oppervlakte +
                ", type=" + type +
                '}';
    }
}



