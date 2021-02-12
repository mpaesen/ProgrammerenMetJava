package ch2.mystuff;

public class MyOtherClass{
    public MyOtherClass() {
    }

    public MyOtherClass(int myVar) {
        this.myVar = myVar;
    }

    public MyOtherClass compareMyClasses(MyOtherClass obj) {
        if(getMyVar() >= obj.getMyVar())
            return this;
        return obj;
    }

    public int getMyVar(){
            return myVar;
        }

    public void setMyVar(int myVar){
            this.myVar = myVar;
        }

    public void displayMyVar(){
        System.out.println("Current value is: "+getMyVar());
        }

    private int myVar = 0;
}