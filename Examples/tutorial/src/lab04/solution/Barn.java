package lab04.solution;
public class Barn {

public Barn(int aSize) {
   //System.out.println("One-arg constructor, size is " + aSize);
   size = aSize;
   stalls = aSize / 150;
}

public String toString(){
   return "Barn size: " + size + " Barn stalls: " + stalls;
}

private int size;
private int stalls;
}
