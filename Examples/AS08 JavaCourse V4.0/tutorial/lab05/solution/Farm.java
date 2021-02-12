package lab05.solution;
public class Farm {

public Farm(int aBarnSize) {
   this(aBarnSize, 640);
}

public Farm(int aBarnSize, int anArea) {
   barn = new Barn(aBarnSize);
   area = anArea;
}

public String toString() {
   return  barn + ", Farm area: " + area;
}

private int area;
private Barn barn;
}
