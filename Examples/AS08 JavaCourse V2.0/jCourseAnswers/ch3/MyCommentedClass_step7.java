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

    /**
     * Returns the current value of the myVar variable
     * @return current value of myVar variable
     * @see    MyCommentedClass#setMyVar
     */
    public int getMyVar()
    {
        return myVar;
    }

    /**
     * Given an integer value, sets myVar variable to it
     * @param myVarValue value to set instance variable to
     * @see    MyCommentedClass#getMyVar
     */
    public void setMyVar(int myVarValue)
    {
        myVar = myVarValue;
    }
} // end of class MyCommentedClass