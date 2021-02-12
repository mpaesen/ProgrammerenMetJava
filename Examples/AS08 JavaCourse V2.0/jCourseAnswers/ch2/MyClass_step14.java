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
        MyOtherClass highestObj = compareMyClasses(myObj,myObj2);
        System.out.println("highest value " + highestObj.getMyVar());
        highestObj = myObj.compareTo(myObj2);
        System.out.println("highest value " + highestObj.getMyVar());
    }

    public static MyOtherClass compareMyClasses(MyOtherClass obj1, MyOtherClass obj2)
    {
        if (obj1.getMyVar() >= obj2.getMyVar())
          return obj1;
        else
          return obj2;
    }

}