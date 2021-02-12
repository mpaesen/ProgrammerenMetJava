package jSrc.ch3;
/**
 * This class is the first class I ever created.
 * I am quite proud of it, I hope you enjoy it.
 * @author Student
 * @version 1.0
 */
public class MyCommentedClass
{
    private int myVar = 0;

    /**
     * This is the main method that gets control from
     * the command line.
     * @param args an array of Strings from the command line
     */
    public static void main(String args[])
    {
        System.out.println("Welcome to MyCommentedClass");
    }

    public int getMyVar()
    {
        return myVar;
    }

    public void setMyVar(int myVarValue)
    {
        myVar = myVarValue;
    }
} // end of class MyCommentedClass