public class DataTypes
{
    private byte    byteVar;
    private char    charVar;
    private short   shortVar;
    private int     intVar;
    private long    longVar;
    private boolean booleanVar;
    private float   floatVar;
    private double  doubleVar;

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