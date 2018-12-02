package utilities;


public class MaandException extends Exception {
    private String text;

    public MaandException(String str) {
        text = str;
    }

    public MaandException(Datum arg) {
        this(arg.toString());
    }

    @Override
    public String toString() {
        return "MaandException [Maand" + text + "] is geen correcte maand!!";
    }

}
