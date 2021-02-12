public class DataTypes
{
    public static final byte INIT_VAL = 100;
    private byte    byteVar = INIT_VAL;
    private char    charVar = 'a';
    private short   shortVar= INIT_VAL;
    private int     intVar  = INIT_VAL;
    private long    longVar = INIT_VAL;
    private boolean booleanVar=false;
    private float   floatVar= INIT_VAL;
    private double  doubleVar=INIT_VAL;

    public void displayVars()
    {
        System.out.println("byteVar = " + byteVar);
        System.out.println("charVar = " + charVar);
        System.out.println("shortVar = " + shortVar);
        System.out.println("intVar = " + intVar);
        System.out.println("longVar = " + longVar);
        System.out.println("booleanVar = " + booleanVar);
        System.out.println("floatVar = " + floatVar);
        System.out.println("doubleVar = " + doubleVar);
    }

    public static void main(String args[])
    {
        DataTypes me = new DataTypes();
        me.displayVars();
    }
} // end class DataTypes