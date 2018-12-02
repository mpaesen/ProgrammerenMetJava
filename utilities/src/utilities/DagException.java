package utilities;


public class DagException extends Exception {
    private String text;

    public DagException(String str) {
        text = str;
    }

    public DagException(Datum arg) {
        this(arg.toString());
    }

    @Override
    public String toString() {
        return "DagException [Dag" + text + "] is geen correcte dag!!";
    }

}
