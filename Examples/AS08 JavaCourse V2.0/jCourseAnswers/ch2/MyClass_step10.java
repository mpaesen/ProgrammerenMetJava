public class MyClass
{
    public static void main(String args[])
    {
        System.out.println("Welcome to MyClass");
        MyOtherClass myObj = new MyOtherClass();
        myObj.setMyVar(5);
        myObj.displayMyVar();
        MyOtherClass myObj2 = new MyOtherClass(10);
        myObj2.displayMyVar();
    }

}