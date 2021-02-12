package lab05.solution;
public class Barn {

public Barn(int aSize) {
   size = aSize;
   stalls = aSize / 150;
}

public String toString(){
   return "Barn size: " + size + " Barn stalls: " + stalls;
}

private int size;
private int stalls;
}
