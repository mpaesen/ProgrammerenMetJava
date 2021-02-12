package mystuff.chapter2;

public class MyOtherClass
{
    private int myVar = 0;

    public MyOtherClass()
    {
    }

    public MyOtherClass(int myVar)
    {
        this.myVar = myVar;
    }

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

    public MyOtherClass compareTo(MyOtherClass obj2)
    {
        if (getMyVar() >= obj2.getMyVar())
          return this;
        else
          return obj2;
    }

} // end class
