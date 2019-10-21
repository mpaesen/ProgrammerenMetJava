package model;

public enum TypeWoning {
    VILLA("Villa"), LOFT("Loft"), APPARTEMENT("Appartement"), STUDIO("Studio"), HUIS("Huis");
    private String type;

    TypeWoning(String type) {
        this.type = type;
    }

    public static TypeWoning getTypeKamer(String type) {
        switch (type) {
            case "Appartement":
                return TypeWoning.APPARTEMENT;
            case "Huis":
                return TypeWoning.HUIS;
            case "Villa":
                return TypeWoning.VILLA;
            case "Loft":
                return TypeWoning.LOFT;
            case "Studio":
                return TypeWoning.STUDIO;
            default:
                throw new IllegalArgumentException("Wrong Woning Type!");
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
        return "TypeWoning{" +
                "type='" + type + '\'' +
                '}';
    }
}
