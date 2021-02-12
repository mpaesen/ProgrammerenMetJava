public class MyOtherClass
{
    private int myVar = 0;

    public int getMyVar()
    {
        return myVar;
    }

    public void setMyVar(int myVarValue)
    {
        myVar = myVarValue;
    }

    public void displayMyVar()
    {
        System.out.println("current value is " + getMyVar());
    }
} // end class