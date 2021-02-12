package ch2;

import ch2.mystuff.MyOtherClass;

public class MyClass{
    public static MyOtherClass compareMyClasses(MyOtherClass obj1, MyOtherClass obj2) {
        if(obj1.getMyVar() >= obj2.getMyVar())
            return obj1;
        return obj2;
    }


    public static void main(String[] argv) {
        System.out.println("Welcome to MyClass");
        MyOtherClass myObj = new MyOtherClass();
        myObj.setMyVar(5);
        myObj.displayMyVar();
        MyOtherClass myObj2 = new MyOtherClass(10);
        myObj2.displayMyVar();
        MyOtherClass highestObj = compareMyClasses(myObj,myObj2);
        System.out.println("Highest value "+highestObj.getMyVar());
        highestObj = myObj.compareMyClasses(myObj2);
        System.out.println("Highest value "+highestObj.getMyVar());
    }
}