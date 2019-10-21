package model.kamers;

public enum TypeKamer {
    BERGING("Berging"), SLAAP_KAMER("Slaap"), BAD_KAMER("Bad"), WC("WC"), GARAGE("Garage"), KEUKEN("Keuken"), WOON_KAMER("Woon");
    private String type;

    TypeKamer(String type) {
        this.type = type;
    }

    public static TypeKamer getTypeKamer(String type) {
        switch (type) {
            case "Slaap":
                return TypeKamer.SLAAP_KAMER;
            case "WC":
                return TypeKamer.WC;
            case "Berging":
                return TypeKamer.BERGING;
            case "Bad":
                return TypeKamer.BAD_KAMER;
            case "Woon":
                return TypeKamer.WOON_KAMER;
            case "Keuken":
                return TypeKamer.KEUKEN;
            case "Garage":
                return TypeKamer.GARAGE;
            default:
                throw new IllegalArgumentException("Wrong Kamer Type!");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeKamer{" +
                "type='" + type + '\'' +
                '}';
    }
}
