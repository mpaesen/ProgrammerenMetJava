package model.kleuren;

public enum Kleur {
    
     
     WIT(0, "Wit"),  GROEN(1, "Groen"),  ROOD(2, "Rood"),  BLAUW(3, "Blauw"), GEEL(4, "Geel");  
     private final int kleurNumeric;
     private final String kleurString;
     
      Kleur(int kleurNumeric, String kleurString){
    	 this.kleurNumeric = kleurNumeric;
    	 this.kleurString = kleurString;
     }
      
     public int kleurNumeric(){
    	 return kleurNumeric;
     }
     
     public String kleurString(){
    	 return kleurString;
     }
}
