public class DataTypes
{
    private byte    byteVar = 100;
    private char    charVar = 'a';
    private short   shortVar= 100;
    private int     intVar  = 100;
    private long    longVar = 100;
    private boolean booleanVar=false;
    private float   floatVar=100;
    private double  doubleVar=100;

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