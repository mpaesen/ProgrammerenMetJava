package ch5;

public class DataTypes {
    public void displayVars() {
        System.out.println("byteVar = " + byteVar);
        System.out.println("charVar = " + charVar);
        System.out.println("shortVar = " + shortVar);
        System.out.println("intVar = " + intVar);
        System.out.println("longVar = " + longVar);
        System.out.println("booleanVar = " + booleanVar);
        System.out.println("floatVar = " + floatVar);
        System.out.println("doubleVar = " + doubleVar);
    }

    public static void main(String[] argv) {
        DataTypes me = new DataTypes();
        me.displayVars();
    }

    public static final int INIT_VAL = 100000;
    public static final char QUOTE = '\'';
    private byte byteVar = (byte)INIT_VAL;
    private char charVar = 'a';
    short shortVar = (short)INIT_VAL;
    private int intVar = INIT_VAL;
    private long longVar = INIT_VAL;
    private boolean booleanVar = false;
    private float floatVar = INIT_VAL;
    private double doubleVar = INIT_VAL;
}
