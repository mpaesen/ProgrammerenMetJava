package lab05.solution;
public class DairyFarm extends Farm {

public DairyFarm(int aCowNbr, int aBarnSize) {
   super(aBarnSize);
   cows = aCowNbr;
}

public DairyFarm(int aCowNbr, int aBarnSize, int anArea) {
   super(aBarnSize, anArea);
   cows = aCowNbr;
}

public String toString(){
   return super.toString() + ", DairyFarm cows: " + cows;
}

private int cows;
}
